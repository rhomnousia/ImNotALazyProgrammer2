package WorkTimerApplication;

/**
 * Created by Johan on 12/8/13.
 */
public class BasicInterruption implements Interruption {
    private final String reasonForInterruption;
    public BasicInterruption(String reasonForInterruption) {
        this.reasonForInterruption = reasonForInterruption;
    }
    @Override
    public String getReasonForInterruption() {
        return reasonForInterruption;
    }

    private long lengthOfTimeForInterruption;
    @Override
    public long getLengthOfTimeOfInterruption() {
        return lengthOfTimeForInterruption;
    }
    public void setLengthOfTimeOfInterruption(long lengthOfTimeForInterruption) {
        this.lengthOfTimeForInterruption = lengthOfTimeForInterruption;
    }

    private String typeOfInterruption;
    @Override
    public String getTypeOfInterruption() {
        return typeOfInterruption;
    }
    public void setTypeOfInterruption(String typeOfInterruption) {
        this.typeOfInterruption = typeOfInterruption;
    }
}
