package simplifiedclass

import kotlin.collections.HashMap

class IDE(hashMap: HashMap<String, Int>) {

    val countryList = hashMap.values.toList()
    val contPerson = hashMap.keys.toList()


}