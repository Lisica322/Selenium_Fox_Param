package consts;

public enum AdressRgsUrl {
    BASE_URL("http://www.rgs.ru​");
    private String url;

    AdressRgsUrl(String url) {
        this.url = url;
    }

    public String getBaseUrl() {
        return url;
    }
}
