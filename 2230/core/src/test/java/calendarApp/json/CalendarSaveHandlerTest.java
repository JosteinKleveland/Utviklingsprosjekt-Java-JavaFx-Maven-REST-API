package calendarApp.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import calendarApp.core.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CalendarSaveHandlerTest {


    // private final static String SAVE_FOLDER = "/workspace/gr2230/2230/data/src/main/java/calendarApp/data/savedCalendars/";
    // private static String testCalendarName = "testCalendar";
    // private static String filePath = SAVE_FOLDER + testCalendarName + ".json";
    
    // //Check if testCalendar exsists, and delete it if so
    // @BeforeEach
    // public void testSetup(){
    //     File file = new File(filePath);
    //     if(file.isFile()) {
    //         file.delete();
    //     }
    //     assertFalse(file.isFile());
    // }

    // @Test
    // @DisplayName("Check that correct file path is returned")
    // public void getFilePathTest(){
    //     assertEquals(filePath, CalendarSaveHandler.getFilePath(testCalendarName));
    // }    

    // @Test
    // @DisplayName("Check that calendar is created and saved") 
    // public void saveCalendarTest() throws IOException{
    //     // Create and save a new calendar
    //     try {
    //         Calendar testCalendar = new Calendar("Steinar");
    //         CalendarSaveHandler.save(testCalendar);
    //         // Check if new file was created
    //         File file = new File(CalendarSaveHandler.getFilePath("Steinar"));
    //         assertTrue(file.exists());
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } 
    // }

    // @Test
    // @DisplayName("Check that calendar is loaded correctly") 
    // public void loadCalendarTest() throws IOException{
    //     assertTrue(CalendarSaveHandler.load("testCalendar").getClass() == Calendar.class);
    //     assertTrue(CalendarSaveHandler.load("testCalendar").getClass().getName() == "testCalendar");
    // }

    // @Test
    // @DisplayName("Check that calendar is loaded correctly") 
    // public void getAllFileNamesTest() throws IOException {
    //     CalendarSaveHandler calendarSaveHandler = new CalendarSaveHandler();
    //     int numberOfFileNames = calendarSaveHandler.getAllFileNames().size();
    //     Calendar testCalendar = new Calendar("Ole");
    //     CalendarSaveHandler.save(testCalendar);
    //     int newNumberOfFileNames = calendarSaveHandler.getAllFileNames().size();
    //     assertTrue(newNumberOfFileNames == numberOfFileNames + 1);
    // }
}
