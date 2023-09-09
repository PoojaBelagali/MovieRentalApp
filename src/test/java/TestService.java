import com.etraveli.service.MovieRentalServiceImpl;
import com.etraveli.util.MovieType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestService {
    public MovieRentalServiceImpl service = new MovieRentalServiceImpl();

    @Before
    public void setup() {
        addCustomers(service);
        addMovies(service);
        rentMovies(service);
    }
    private static void addCustomers(MovieRentalServiceImpl service) {
        service.addCustomer("CUST-001","Jhon Cena");
        service.addCustomer("CUST-002","Machael Roy");
        service.addCustomer("CUST-003","Arun Patel");
        service.addCustomer("CUST-004","Priyanka C");
        service.addCustomer("CUST-005","Rohan Kumar");

    }

    private static void addMovies(MovieRentalServiceImpl service) {
        service.addMovie("MOV-001","Star Wars", MovieType.REGULAR);
        service.addMovie("MOV-002","John Wick-4", MovieType.NEW);
        service.addMovie("MOV-003","Kung-Fu Panda-2", MovieType.CHILDREN);
        service.addMovie("MOV-004","Bridget Jones's Diary", MovieType.REGULAR);
        service.addMovie("MOV-005","Barbie", MovieType.NEW);
        service.addMovie("MOV-006","Frozen", MovieType.CHILDREN);
        service.addMovie("MOV-007","When Harry Met Sally", MovieType.REGULAR);
        service.addMovie("MOV-008","Oppenheimer", MovieType.NEW);
        service.addMovie("MOV-009","Wall-e", MovieType.CHILDREN);

    }

    private static void rentMovies(MovieRentalServiceImpl service) {
        service.rentMovie("CUST-001","MOV-002", 2);
        service.rentMovie("CUST-003","MOV-004", 4);
        service.rentMovie("CUST-001","MOV-006", 1);
        service.rentMovie("CUST-004","MOV-003", 5);
        service.rentMovie("CUST-004","MOV-008", 3);
        service.rentMovie("CUST-004","MOV-001", 2);

    }

    @Test
    public void test_1(){
        System.out.println(service.getStatement("CUST-001"));
        String expected = "Rental Record for Jhon Cena\n\tFrozen\t1.5\n\tJohn Wick-4\t6.0\nAmount owed is 7.5\nYou earned 2 frequent points\n";
        Assert.assertEquals(expected, service.getStatement("CUST-001"));
    }

    @Test
    public void test_3(){
        System.out.println(service.getStatement("CUST-003"));
        String expected = "Rental Record for Arun Patel\n\tBridget Jones's Diary\t7.0\nAmount owed is 7.0\nYou earned 1 frequent points\n";
        Assert.assertEquals(expected, service.getStatement("CUST-003"));
    }

    @Test
    public void test_4(){
        System.out.println(service.getStatement("CUST-004"));
        String expected = "Rental Record for Priyanka C\n\tOppenheimer\t9.0\n\tKung-Fu Panda-2\t4.5\n\tStar Wars\t2.0\nAmount owed is 15.5\nYou earned 4 frequent points\n";
        Assert.assertEquals(expected, service.getStatement("CUST-004"));
    }

}
