import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;
import java.util.Scanner;

public class TestToSpeech {

    private static final String VOICES_KEY = "freetts.voices";
    private static final String VOICES_VALUE = "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory";
    private static final String CENTRAL_DATA = "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral";

    public static void main (String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            String data = scan.nextLine();
            System.setProperty(VOICES_KEY, VOICES_VALUE);

            Central.registerEngineCentral(CENTRAL_DATA);
            Synthesizer sy = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            sy.allocate();
            sy.resume();
            sy.speakPlainText(data, null);
            sy.waitEngineState(Synthesizer.QUEUE_EMPTY);
            sy.deallocate();
        } catch (Exception e) {
        }
    }
}
