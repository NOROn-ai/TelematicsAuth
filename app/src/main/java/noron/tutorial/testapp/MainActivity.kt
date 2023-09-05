package noron.tutorial.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.telematicssdk.auth.TelematicsAuth
import com.telematicssdk.auth.api.model.Gender
import com.telematicssdk.auth.api.model.MaritalStatus

class MainActivity : AppCompatActivity() {
    private val INSTANCE_ID = "9d0c2602-fb6a-419c-8843-07d846c1edc1"
    private val INSTANCE_KEY = "0e353265-11c2-4b03-9da9-9df7ab037449"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDeviceToken()
        setContentView(R.layout.activity_main)
    }

    fun createDeviceToken() {
        TelematicsAuth.createDeviceToken(
            INSTANCE_ID,
            INSTANCE_KEY
        )
            .onSuccess {result ->
                println("device token:")
                println(result.deviceToken)
                println("access token:")
                println(result.accessToken)
                println("refresh token:")
                println(result.refreshToken)
    }
    .onError { e ->
        e.printStackTrace()
    }
    }

    fun login(deviceToken: String) {
        TelematicsAuth.login(
            INSTANCE_ID,
            INSTANCE_KEY,
            deviceToken
        )
            .onSuccess{
                it.accessToken
                it.refreshToken
            }
            .onError{ e ->
                e.printStackTrace()
            }
    }

    fun getUser(accessToken: String) {
        TelematicsAuth.getUserProfile(
            INSTANCE_ID,
            INSTANCE_KEY,
            accessToken
        )
            .onSuccess{
                println( it.firstName)
            }
            .onError{ e ->
                e.printStackTrace()
            }
    }

    fun updateUser(deviceToken: String, accessToken: String){
        TelematicsAuth.updateUserProfile(
            INSTANCE_ID,
            INSTANCE_KEY,
            deviceToken,
            accessToken,
            "email",
            "phone",
            "clientId",
            "firstname",
            "lastname",
            "birthDay", //yyyy-MM-DD'T'HH:mm:ss
            MaritalStatus.Married,
            0,
            "address",
            Gender.Male
        )
            .onSuccess{

            }
            .onError{

            }
    }

    fun refreshToken(accessToken: String, refreshToken: String){
        TelematicsAuth.refreshToken(
            INSTANCE_ID,
            INSTANCE_KEY,
            accessToken,
            refreshToken
        )
            .onSuccess{
                it.refreshToken
            }
            .onError{

            }
    }
}