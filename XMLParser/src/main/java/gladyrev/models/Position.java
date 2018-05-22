package gladyrev.models;

/**
 * Класс модель позиций Position со свойствами <b>id</b>, <b>depCode</b>, <b>depJob</b> и <b>description</b>.
 */
public class Position {
    private int id;
    private String depCode;
    private String depJob;
    private String description;

    /**
     * Ниже расположены переопределение метода toString и методы доступа
     */
    @Override
    public String toString() {
        return "depCode: " + depCode + "; depJob: " + depJob + "; description:" + description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepJob() {
        return depJob;
    }

    public void setDepJob(String depJob) {
        this.depJob = depJob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
