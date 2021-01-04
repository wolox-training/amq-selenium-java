package utils.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Asterisk;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EmbedEvent;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.HookTestStep;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestSourceRead;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;
import io.github.cdimascio.dotenv.Dotenv;
import utils.screenshots.Screenshots;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.aventstack.extentreports.reporter.configuration.ViewName.*;

/**
 * Adaptada de: https://medium.com/@praveendavidmathew/creating-cucumber-extent-report-the-right-way-3298a247e545
 * https://sqa.stackexchange.com/questions/44536/how-to-implement-extent-report-in-cucumber-using-eventlistener-and-where-to-find
 * https://github.com/grasshopper7/extentreports-cucumber6-adapter
 */
public class Report implements EventListener {

    private static Dotenv dotenv = Dotenv.load();

    public static final String IMAGE_PNG = "image/png";
    public static final String EXT_PNG = ".png";
    private static final String IMAGES = "img/";
    private static final String EVIDENCIAS =
            dotenv.get("PATH.EVIDENCE") + File.separator + currentDate()
            + File.separator;
    private static ThreadLocal<Report> reportThreadLocal = new ThreadLocal<>();
    private Map<String, ExtentTest> feature = new HashMap<String, ExtentTest>();
    private ExtentTest scenario;
    private ExtentTest step;
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private boolean withHook;

    public Report() {
        if (reportThreadLocal.get() == null) {
            reportThreadLocal.set(this);
        }
        withHook = Boolean.parseBoolean(dotenv.get("REPORT.HOOKS"));
    }

    public static Report getReportThreadLocal() {
        return reportThreadLocal.get();
    }

    private static String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd.HHmmssSSS");
        return dateFormat.format(new Date());
    }

    public static LoggerReport logger() {
        Report report = getReportThreadLocal();
        if (report != null) {
            ExtentTest step = report.step;
            if (step != null) {
                return new LoggerReport(step);
            }
        }
        return null;
    }

    public static void remove() {
        reportThreadLocal.remove();
    }

    /**
     * Método que se ejecuta de forma automatica, permite registrar que eventos se van a capturar
     * durante la ejecución de la prueba
     *
     * @param publisher Instancia del publicador de eventos
     */
    /*
     * :: is method reference , so this::collecTag means collectTags method in
     * 'this' instance. Here we says runStarted method accepts or listens to
     * TestRunStarted event type
     */
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher
            .registerHandlerFor(TestRunStarted.class, Report.getReportThreadLocal()::runStarted);
        publisher
            .registerHandlerFor(TestRunFinished.class, Report.getReportThreadLocal()::runFinished);
        publisher
            .registerHandlerFor(TestSourceRead.class, Report.getReportThreadLocal()::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class,
            Report.getReportThreadLocal()::scenarioStarted);
        publisher
            .registerHandlerFor(TestStepStarted.class, Report.getReportThreadLocal()::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class,
            Report.getReportThreadLocal()::stepFinished);
        publisher.registerHandlerFor(EmbedEvent.class, Report.getReportThreadLocal()::embedEvent);
    }

    /**
     * Método que se invoca cuano inicia la ejecución de un Test. En este método se crea la
     * instancia del reporte
     *
     * @param event Instancia del evento
     */
    /*
     * Here we set argument type as TestRunStarted if you set anything else then the
     * corresponding register shows error as it doesn't have a listner method that
     * accepts the type specified in TestRunStarted.class
     */
    private void runStarted(TestRunStarted event) {
        if (extent == null) {
            extent = new ExtentReports();
            spark = createExtentSparkReporter("ExtentReportResults.html");
            ExtentSparkReporter failReport = createExtentSparkReporter("failReportResult.html");
            failReport.filter()
                .statusFilter()
                .as(new Status[]{Status.FAIL})
                .apply();

            extent.attachReporter(spark);
            extent.attachReporter(failReport);
        }
    }

    /**
     * Método que crea una instancia de un {@link ExtentSparkReporter} y realiza una configuración
     * básica del mismo
     *
     * @param name Nombre del archivo del nuevo reporte
     * @return Instancia de {@link ExtentSparkReporter} creada
     */
    private ExtentSparkReporter createExtentSparkReporter(String name) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(EVIDENCIAS.concat(name));
        reporter.config().setTheme(Theme.STANDARD);
        reporter.viewConfigurer()
            .viewOrder()
            .as(new ViewName[]{
                DASHBOARD, TEST, CATEGORY, EXCEPTION, AUTHOR, DEVICE, LOG
            })
            .apply();

        return reporter;
    }

    /**
     * Metodo que se invoca cuando el test finaliza, esto sucede cuando todos los archivos features
     * son completados, se emite la orden de generación de reporte (flush)
     *
     * @param event Instancia del evento generado
     */
    private void runFinished(TestRunFinished event) {
        extent.flush();
    }

    /**
     * Metodo que se invoca cuando un archivo feature es leido, en este momento se crea el nuevo
     * feature
     *
     * @param event Instancia del evento de lectura del feature
     */
    private void featureRead(TestSourceRead event) {
        String featureSource = event.getUri().toString();
        String featureName = featureSource.split(".*/")[1];
        if (feature.get(featureSource) == null) {
            feature.putIfAbsent(featureSource, extent.createTest(featureName));
        }
    }

    /**
     * Método ejecutado cuando inicia la ejecución de un scenario, en este momento se crea el nodo
     * para el scenario
     *
     * @param event Instancia del evento
     */
    private void scenarioStarted(TestCaseStarted event) {
        String featureName = event.getTestCase().getUri().toString();
        scenario = feature.get(featureName).createNode(event.getTestCase().getName());
        event.getTestCase().getTags().forEach(scenario::assignCategory);
    }

    /**
     * Método que se ejecuta cuando un step inicia, el método crea el nodo para el nuevo step. Se
     * puede generar el evento cuando inicia un step o cuando se ejecuta un Hook
     *
     * @param event Instancia del evento generado
     */
    private void stepStarted(TestStepStarted event) {
        String stepName;
        String keyword = "Triggered the hook :";
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
            stepName = steps.getStep().getText();
            keyword = steps.getStep().getKeyword();
            step = scenario.createNode(Given.class, keyword + " " + stepName);
        } else {
            HookTestStep hoo = (HookTestStep) event.getTestStep();
            stepName = hoo.getHookType().name();
            step = scenario.createNode(Asterisk.class, keyword + " " + stepName);
        }
    }

    /**
     * Método que se ejecuta cuando un step finaliza
     *
     * @param event Instancia del evento
     */
    private void stepFinished(TestStepFinished event) {
        Status status;
        String menssage;
        switch (event.getResult().getStatus()) {
            case PASSED:
                status = Status.PASS;
                step.pass("This passed");
                break;
            case SKIPPED:
                status = Status.SKIP;
                step.skip("This step was skipped");
                break;
            default:
                status = Status.FAIL;
        }
        if (event.getResult().getError() != null) {
            Media media = createMediaImage(event.getTestCase().getName().concat(EXT_PNG),
                Screenshots.captureScreenShotWithTestStepName(), IMAGE_PNG);
            step.log(status, event.getResult().getError().getMessage(), media);
            step.log(status, event.getResult().getError(), media);
        }
        if (!withHook && step.getModel().getName().contains("Triggered the hook :")
            && !scenario.getModel().hasException()) {
            scenario.getModel().getChildren().remove(step.getModel());
        }
    }

    /**
     * Metodo que permite la adicion de imagenes a los reportes
     *
     * @param event Evento generado con la inclusion de un elemento embebido
     */
    private synchronized void embedEvent(EmbedEvent event) {
        String mimeType = event.getMediaType();
        String extension = "png";
        String scenarioName = event.getName();

        StringBuilder fileName = new StringBuilder(scenarioName).append(System.currentTimeMillis())
            .append(".")
            .append(extension);
        step.info("", createMediaImage(fileName.toString(), event.getData(), mimeType));

    }

    /**
     * Metodo que adiciona la imagen en la estructura del reporte
     *
     * @param data Datos de la imagen
     * @return Media que contiene la imagen adjunta
     */
    public synchronized Media createMediaImage(byte[] data) {

        StringBuilder fileName = new StringBuilder(
            Report.currentDate())
            .append(".png");
        return createMediaImage(fileName.toString(), data, IMAGE_PNG);
    }

    /**
     * Metodo que adiciona la imagen en la estructura del reporte
     *
     * @param fileName Nombre del archivo
     * @param data     Datos de la imagen
     * @param mimeType Tipo de imagen
     * @return Media que contiene la imagen adjunta
     */
    public synchronized Media createMediaImage(String fileName, byte[] data, String mimeType) {
        try {
            StringBuilder subPath = new StringBuilder(IMAGES)
                .append(getScenarioName().replace('"', '|').replace(':', '-'));
            StringBuilder basePath = new StringBuilder(EVIDENCIAS)
                .append(subPath.toString());

            Path path = Paths.get(basePath.toString(), fileName.toString());
            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            Files.write(path, data);
            subPath.append(File.separator).append(fileName);
            return MediaEntityBuilder
                .createScreenCaptureFromPath(subPath.toString())
                .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MediaEntityBuilder.createScreenCaptureFromPath(null).build();
    }

    private String getScenarioName() {
        final String scenarioName = scenario.getModel().getName();
        long n = scenario.getModel().getParent().getChildren()
            .stream()
            .filter(t -> t.getName().equals(scenarioName)).count();
        return String.format("%s-%02d", scenarioName, n);
    }
}
