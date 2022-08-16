package ehb.sv.data

import androidx.room.*
import ehb.sv.classes.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Flow<List<User>>

    @Query("SELECT * FROM user WHERE name LIKE :first LIMIT 1")
    fun findByName(first: String): Flow<User>

    @Update
    suspend fun updateUser(user: User)

    @Insert
    suspend fun insertAll(vararg users: User)

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}