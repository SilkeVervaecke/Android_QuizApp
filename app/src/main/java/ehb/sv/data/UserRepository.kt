package ehb.sv.data

import androidx.annotation.WorkerThread
import ehb.sv.classes.User
import kotlinx.coroutines.flow.Flow


class UserRepository(private val userDAO: UserDAO) {

    val getAll: Flow<List<User>> = userDAO.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        userDAO.insert(user)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(user: User) {
        userDAO.updateUser(user)
    }


}