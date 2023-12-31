package calendarApp.json;


import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import calendarApp.core.Appointment;
import calendarApp.core.Calendar;
/* For running main-method
import calendarApp.core.DaysOfTheWeek;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
*/
import calendarApp.core.CalendarLogic;

// Module to access appointment- and calendar- serializers and deserializers
public class CalendarAppModule extends SimpleModule {
    private static final String NAME = "CalendarAppModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil() {};
    
    // Connects the Appointment and Calendar classes with their respective serializers/deseralizers
    public CalendarAppModule() {
        super(NAME, VERSION_UTIL.version());
        addSerializer(Appointment.class, new AppointmentSerializer());
        addSerializer(Calendar.class, new CalendarSerializer());
        addSerializer(CalendarLogic.class, new CalendarLogicSerializer());
        addDeserializer(Appointment.class, new AppointmentDeserializer());
        addDeserializer(Calendar.class, new CalendarDeserializer());
        addDeserializer(CalendarLogic.class, new CalendarLogicDeserializer());
      }

    /*
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new CalendarAppModule());
        Calendar calendar = new Calendar("jsonTest");
        Appointment appointment1 = new Appointment("Fotball", "husk fotball", DaysOfTheWeek.WEDNESDAY, 7, 9, 0, 30);
        calendar.addAppointment(appointment1);          
        Appointment appointment2 = new Appointment("Math", "husk mattebok", DaysOfTheWeek.THURSDAY, 11, 12, 30, 15);
        calendar.addAppointment(appointment2);
        try {
            System.out.println(mapper.writeValueAsString(calendar));
        } catch (JsonProcessingException e) {
            System.out.println("Virket ikke");
            e.printStackTrace();
        }

        try {
            String json = mapper.writeValueAsString(calendar);
            Calendar calendar2 = mapper.readValue(json, Calendar.class);
            for (Appointment appointment : calendar2.getAppointments()) {
                System.out.println(appointment);
            }
        } catch (JsonProcessingException e) {
            System.out.println("Virket ikke");
            e.printStackTrace();
        }
    }
    */
  }
