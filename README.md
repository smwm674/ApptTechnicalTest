# ApptTechnicalTest
There is following error in the code
which can be resolved by creating the mock of TextUtils as following 

@Mock
TextUtils mMockTextUtils
    
Or

The other way si to change the function called isValidData as following 
fun isValidData(latitude: String, longitude: String): Boolean {
        return !latitude.isNullOrEmpty() && !longitude.isNullOrEmpty()
    }
