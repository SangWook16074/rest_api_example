package com.example.rest_api_example.human.controller

import com.example.rest_api_example.human.entity.Human
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/humans")
class HumanController {
    final var humans = mutableListOf<Human>()

    /*
    컨트롤러가 생성되면
    생성자에 의해서 배열에는 아래의 사람객체가 생성됨.
     */
    init {
        humans.addAll(
            listOf(
                Human(1, "짱구", 5),
                Human(2, "철수", 5),
                Human(3, "훈이", 5),
                Human(4, "맹구", 5),
            )
        )
    }

    /*
    모든 사람 객체를 불러오는 Get 메소드
    요청이 성공적으로 전달되면
    모든 사람 객체의 정보를 전달하면서
    HTTP Status Code 200을 반환함.
     */
    @GetMapping
    private fun getHumanList() : ResponseEntity<List<Human>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(humans)
    }

    /**
     * id를 통해 특정 사람 객체를 불러오는 Get 메소드
     * 요청이 성공적으로 전달되면
     * 해당 사람 객체의 정보를 전달하면서
     * HTTP Status Code 200을 반환함.
     * 정보가 존재하지 않으면
     * HTTP Status Code 204를 반환함.
     */
    @GetMapping("/{id}")
    private fun getHumanById(@PathVariable id : String) : ResponseEntity<Any> {
        for (h in humans) {
            /**
             * 반복문 중 해당 ID를 가진 사람 객체를 찾게 되면
             * 해당 사람 객체를 반환하고
             * Http Status Code 200을 반환함.
             */
            if (h.id == id.toLong()) {
                return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(h)
            }
        }

        /**
         * 반복문을 통해 값을 찾지 못하면
         * Http Status Code 204를 반환.
         */
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    /**
     * 사람 객체를 생성하는 Post 메소드
     * 성공적으로 요청을 수행하면
     * Http Status Code 201을 반환함.
     */
    @PostMapping
    fun postHuman(@RequestBody human : Human) : ResponseEntity<Human> {
        humans.add(human)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(human)
    }

    /**
     * 사람 객체의 정보를 갱신하는 Put 메소드
     * 성공적으로 요청을 수행하면
     * Http Status Code 200을 반환함.
     * 만약 데이터가 존재하지 않으면 Post 메소드를 실행함.
     */
    @PutMapping("/{id}")
    fun putHuman(@PathVariable id : String, @RequestBody human : Human) : ResponseEntity<Human> {
        var index : Int = -1 // 초기 인덱스 값은 -1
        for (h in humans) {
            /**
             * 반복문을 수행하면서 해당 ID와
             * 동일한 ID를 가진 사람 객체를 찾으면
             * 해당 객체의 인덱스값은 인덱스에 전달하고
             * 해당 인덱스의 값을 새롭게 전달함.
             */
            if (h.id == id.toLong()) {
                index = humans.indexOf(h)
                humans[index] = human
            }
        }

        /**
         * 반복문을 통해 해당 객체를 찾지 못하면
         * 인덱스는 그대로 -1임.
         * -1이라면 Post 메소드를 실행해서 사람 객체를 새롭게 생성함
         * Http Status Code는 201을 반환함.
         * 그렇지 않으면 성공적으로 요청을 수행하였기 때문에,
         * Http Status Code는 200을 반환함.
         */
        return if (index != -1) ResponseEntity.status(HttpStatus.OK).body(human) else postHuman(human)
    }

    /**
     * 사람 객체를 배열에서 삭제하는 메소드
     * 요청이 성공하면 Http Status Code 204를 전달함.
     */
    @DeleteMapping("/{id}")
    fun deleteHuman(@PathVariable id : String) : ResponseEntity<Any> {
        humans.removeIf { it.id == id.toLong() }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}