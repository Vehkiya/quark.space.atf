package page.common;

public interface Page {

    void open();

    void refresh();

    String getPageName();

    String getUrl();

    String getPageTitle();

    Boolean isCurrentPage();
}
