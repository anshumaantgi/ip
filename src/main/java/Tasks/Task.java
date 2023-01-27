package Tasks;

public class Task {
    protected String message;
    protected boolean marked = false;
    public static final String TASK_SIGN = "";

    /**
     * Constructor for the Task
     * @param m
     */
    public Task(String m) {
        this.message = m;
    }

    /**
     * Getter for the message inside task
     * @return this.message
     */
    public String getMessage(){

        return this.message;
    }

    /**
     * Getter for the status icon of marked or unmarked
     * @return String of marked or unmarked icon
     */
    public String getStatusIcon(){

        return (this.isMarked()? "[X]": "[ ]");
    }

    /**
     * Return the Storage Representation of the Task
     * @return
     */
    public String getStorageFormat() {
        return TASK_SIGN + "," + this.isMarked()+","+this.getMessage();
    }

    /**
     *
     * @return
     */
    public String getRepresentation(){

        return this.getStatusIcon() + " " + this.getMessage();
    }

    /**
     * Toggles the marked boolean to true
     */
    public void mark() {

        this.marked = true;
    }

    /**
     * toggles the marked boolean to false
     */
    public void unmark(){

        this.marked = false;
    }

    /**
     * Return the current value of marked feild
     * @return this.marked
     */
    public boolean isMarked(){

        return this.marked;
    }


}
