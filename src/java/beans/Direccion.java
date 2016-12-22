package beans;

public class Direccion{
    private String keywords;
    private String url;
    private String descripcion;

    public Direccion(String keywords, String url, String descripcion) {
        this.keywords = keywords;
        this.url = url;
        this.descripcion = descripcion;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
