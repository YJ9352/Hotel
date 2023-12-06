package com.example.myapplication.hotel

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    println("호텔예약 프로그램 입니다.")
    println("[메뉴]")
    println("1. 방예약, 2. 예약목록 출력, 3. 예약목록(정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력, 6. 예약 변경/취소")
    var info = readLine()!!.toInt()

    var hotelmain = HotelMain()
    hotelmain.hotelMenu(info)
}

class HotelMain {

    @RequiresApi(Build.VERSION_CODES.O)
    fun hotelMenu(info: Int) : Any {
        return if (info == 1) {
            println("${info}번을 선택하셨습니다")
            println("호텔 예약을 시작합니다.")
            println("예약하실 방 번호를 입력해주세요.")
            var roomNum = readLine()!!.toInt()
            if (100 < roomNum && roomNum <= 999) {
                println("선택하신 방 번호는 ${roomNum} 입니다.")

                var now1 = LocalDate.now()
                var strNow1 = now1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

                println("오늘 날짜는 ${strNow1} 입니다. 예약하실 날짜를 입력해주세요.(yyyy-MM-dd)")
                var reserDate = readLine()!!.toString()
                var dateNow1 = LocalDate.parse(reserDate, DateTimeFormatter.ISO_DATE)


                if ((strNow1 > dateNow1.toString())) {
                    println("예약이 불가능합니다.")
                    println("오늘 ${strNow1} 보다 이후 날짜를 입력해주세요.")
                    return println("프로그램을 다시 시작해 주세요.")
                } else if ((strNow1 <= dateNow1.toString())) {
                    println("예약이 완료되었습니다.")
                    println("예약날짜는 ${reserDate} 입니다.")
                } else {
                    return println("다시 예약해 주세요.")
                }

                println("예약 날짜는 ${reserDate} 입니다. 체크아웃 날짜를 입력해주세요.(yyyy-MM-dd)")
                var checkOut = readLine()!!.toString()
                var dateNow2 = LocalDate.parse(checkOut, DateTimeFormatter.ISO_DATE)

                if ((dateNow1.toString() >= dateNow2.toString())) {
                    println("체크아웃이 불가능합니다.")
                    println("예약일 : ${checkOut} 보다 이후 날짜를 입력해주세요.")
                    return println("프로그램을 다시 시작해 주세요..")
                } else if ((dateNow2.toString() > dateNow1.toString())) {
                    println("체크아웃이 완료되었습니다.")
                    println("체크아웃 날짜는 ${checkOut} 입니다.")

                    // 호텔결제
                    var guestMoney = 100000
                    var roomCharge = 80000
                    var pee: Int = guestMoney - roomCharge

                    println("호텔 예약이 완료되었습니다. 요금이 결제되었습니다.")
                    println("잔액은 ${pee}입니다.")

                } else {
                    return println("다시 예약해 주세요.")
                }

            // 여기는 방 번호 선택
            } else {
                println("해당 호수는 존재하지 않습니다.")
                return roomNum
            }
        // 여기서부터 다시 메뉴선택
        } else if (info == 2){
            println("${info}번을 선택하셨습니다")
            0
        } else if (info == 3){
            println("${info}번을 선택하셨습니다")
            0
        } else if (info == 4){
            println("${info}번을 선택하셨습니다")
            println("프로그램을 종료합니다.")
            return info
        } else if (info == 5){
            println("${info}번을 선택하셨습니다")
            0
        } else if (info == 6){
            println("${info}번을 선택하셨습니다")
            0
        } else {
            0
        }
    }
}