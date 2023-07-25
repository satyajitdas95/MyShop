package com.satyajit.myshop.ui.homescreen

import com.satyajit.myshop.data.model.AllProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Test {

//    fun testFun(): Flow<List<AllProductsResponse.Product>> {
//        //get data from network
//        //delete eveerything in db
//        //insert data
//        //emit flow from db
//
//        netwrok.getAllPRopducts()
//            .flatmap{netwrokResponse->
//                return@flatmap db.deleteProduct()
//                    .flatmap{deleteID->
//                        return@flatmap db.insert(netwrokResponse)
//                    }
//            }
//            .flatmap{insertID->
//                return@flatmap db.getPRoduct()
//            }
//    }
//
//
//    fun testFun2(): Flow<List<AllProductsResponse.Product>> {
//        //get data from network
//        //delete eveerything in db
//        //insert data
//        //emit flow from db
//
//        netwrok.getAllPRopducts()
//            .flatmap{netwrokResponse->
//                return@flatmap db.deleteProduct().flatmap{
//                    flow { emit netwrokResponse }
//                }
//            }
//            .flatmap{it->
//                return@flatmap db.insert(netwrokResponse)
//            }
//            .flatmap{insertID->
//                return@flatmap db.getPRoduct()
//            }
//    }
}