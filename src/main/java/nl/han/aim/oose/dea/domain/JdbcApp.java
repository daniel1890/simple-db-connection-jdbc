package nl.han.aim.oose.dea.domain;

public class JdbcApp {

    public static void main(String[] args) {
        System.out.println("Main!!!");
        ItemDAO items = new ItemDAO();
        items.findAll().forEach(i -> System.out.println(i.getSku()));

    }
}
