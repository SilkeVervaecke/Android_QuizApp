package ehb.sv;

import android.app.Application;

import ehb.sv.data.UserDatabase;
import ehb.sv.data.UserRepository

public class QuestApplication : Application() {
    val database by lazy { UserDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}
