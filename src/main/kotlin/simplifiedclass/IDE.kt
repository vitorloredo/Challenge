package simplifiedclass

import kotlin.collections.HashMap

class IDE(hashMap: HashMap<String, Double>) {

    val countryList = hashMap.values.toList()
    val contPerson = hashMap.keys.toList()

}