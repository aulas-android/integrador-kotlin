import Constants.MINUTES_IN_MILLISECONDS
import java.util.Calendar

fun Calendar.getTimeOnPast(timeInMinutes: Long = (1L until 240L).random()): Calendar {
    return this.apply {
        timeInMillis -= MINUTES_IN_MILLISECONDS * timeInMinutes
    }
}