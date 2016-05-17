package timeofday;

import de.vksi.c4j.ContractReference;
import de.vksi.c4j.Pure;

@ContractReference(TimeOfDayContract.class)
public class TimeOfDay {
   public static final int HOUR_MIN = 0;
   public static final int HOUR_MAX = 23;
   public static final int MINUTE_MIN = 0;
   public static final int MINUTE_MAX = 59;
   public static final int SECOND_MIN = 0;
   public static final int SECOND_MAX = 59;

   private int hour;
   private int minute;
   private int second;

   public TimeOfDay(int hour, int minute, int second) {
      setHour(hour);
      setMinute(minute);
      setSecond(second);
   }

   public void setHour(int hour) {
      this.hour = hour;
   }

   public void setMinute(int minute) {
      this.minute = minute;
   }

   public void setSecond(int second) {
      this.second = second;
   }

   @Pure
   public int getHour() {
      return hour;
   }

   @Pure
   public int getMinute() {
      return minute;
   }

   @Pure
   public int getSecond() {
      return second;
   }
}