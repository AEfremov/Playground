package com.efremov.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.efremov.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    
    private lateinit var homeViewModel: HomeViewModel
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var answer = ""

//        val count = getPrimes(1000)
//        val sb = StringBuilder()
//        count.asSequence().forEach {
//            sb.append(it).append(",")
//        }

//        val s = summ(5, 10)

//        val anagrams = getAnagrams("нос", "сон", "снедь", "днесь")

//        val numbers = buildBalancedArray(10, arrayOf(1, 12, 3, 9, 5, 2, 4, 6, 8, 10))

//        val sequence = binaryVector(arrayListOf(1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1))

//        val answer = checkValidBracers("{()}[]")

        answer = checkOccurrences("hgjkdhdjfdjkhh", "jhh").toString()
//        answer = checkOccurrencesNoContainMethod("hgjkdhdjfdjkhh", "jhh").toString()

        text_home.text = answer
    }

    // Написать функцию getPrimes(n) // Должна вернуть простые числа от 2 до n
    private fun getPrimes(n: Int) : ArrayList<Int> {
        val numbers = arrayListOf<Int>()
        for (i in 2 until n) {
            var pr = true
            for (j in 2 until i / 2 + 1) {
                if (i % j == 0) {
                    pr = false
                }
            }
            if (pr) numbers.add(i)
        }
        return numbers
    }

    // Сложение двух чисел, используя только оператор +1
    private fun summ(a: Int, b: Int) : Int {
        var summ = a
        var i = 0
        while (i != b) {
            summ += 1
            i += 1
        }
        return summ
    }

    // Написать функцию getAnagrams
    // getAnagrams(“нос”, “сон”, “снедь”, “днесь”)
    // Должна вернуть
    // ["нос", "сон"],
    // ["днесь", "снедь"]
    private fun getAnagrams(arg1: String, arg2: String, arg3: String, arg4: String) : HashMap<String, String> {
        val anagramPairs = hashMapOf<String, String>()
        var isAnagram = false
        if (arg1.length == arg2.length) {
            for (i in 0 until arg1.length) {
                if (arg1[i] == arg2[arg2.length - i - 1]) {
                    isAnagram = true
                }
            }
        }

        var isAnagram2 = false
        if (arg3.length == arg4.length) {
            for (i in 0 until arg3.length) {
                if (arg3[i] == arg4[arg4.length - i - 1]) {
                    isAnagram2 = true
                }
            }
        }

        if (isAnagram) { anagramPairs[arg1] = arg2 }
        if (isAnagram2) { anagramPairs[arg3] = arg4 }

        return anagramPairs
    }

    // Вам задано положительное целое число n, гарантируется, что n четное (то есть делится на 2).
    // Вы хотите построить такой массив a длины n, что:
    // Первые n/2 элементов a четные (делятся на 2);
    // вторые n/2 элементов a нечетные (не делятся на 2);
    // все элементы в a различны и положительны;
    // сумма элементов первой половины равна сумме элементов второй половины
    private fun buildBalancedArray(arrayLength: Int, numbers: Array<Int>) : ArrayList<Int> {
        val answer = arrayListOf<Int>()
        val evenNumbers = arrayListOf<Int>() // четные
        val oddNumbers = arrayListOf<Int>()  // нечетные

        if (arrayLength % 2 == 0 && numbers.size == arrayLength) {
            numbers.asSequence().forEach {
                if (it % 2 == 0) {
                    evenNumbers.add(it)
                } else {
                    oddNumbers.add(it)
                }
            }
            answer.addAll(evenNumbers)
            answer.addAll(oddNumbers)

            var evenNumbersSum = 0
            var oddNumbersSum = 0
            evenNumbers.asSequence().forEach { evenNumbersSum += it }
            oddNumbers.asSequence().forEach { oddNumbersSum += it }
            Toast.makeText(activity, "$evenNumbersSum, $oddNumbersSum", Toast.LENGTH_SHORT).show()

            if (oddNumbers.size < evenNumbers.size) {

                if (oddNumbersSum < evenNumbersSum) {

                    oddNumbers.asSequence().forEach {}

                    var tempEvenNumbersSum = 0
                    evenNumbers.asSequence().forEach {

                        if (tempEvenNumbersSum + it < oddNumbersSum) {

                            tempEvenNumbersSum += it

                        } else if (tempEvenNumbersSum + it > oddNumbersSum) {


                        } else if (tempEvenNumbersSum + it == oddNumbersSum) {


                        }

                    }

                }
            }

        } else {
            Toast.makeText(activity, "Введите корректные исходные данные", Toast.LENGTH_SHORT).show()
        }

        return answer
    }

    // Дан бинарный вектор. Необходимо найти наибольшую последовательность подряд идущих 1 (единиц)
    private fun binaryVector(vector: ArrayList<Int>) : Int {
        var currentSequenceLength = 0
        var maxSequenceLength = 0

        vector.asSequence().forEach {
            if (it == 1) {
                currentSequenceLength += 1
                if (currentSequenceLength > maxSequenceLength) {
                    maxSequenceLength = currentSequenceLength
                }
            } else {
                if (currentSequenceLength > maxSequenceLength) {
                    maxSequenceLength = currentSequenceLength
                }
                currentSequenceLength = 0
            }
        }

        if (maxSequenceLength % 2 == 0) {
            Toast.makeText(activity, "Найденая последовательность 1 - четная", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Найденая последовательность 1 - нечетная", Toast.LENGTH_SHORT).show()
        }

        return maxSequenceLength
    }

    // Написать функцию, проверяющую правильно расставленные скобки;" check("{()}[]") // true
    private fun checkValidBracers(sequence: String) : Boolean {
        var isValidBracers = false
        var openBracers = 0
        var closedBracers = 0
        var unusedBracers = 0

        sequence.asSequence().forEach {
            when (it) {
                '{', '(', '[' -> {
                    openBracers += 1
                }
                '}', ')', ']' -> {
                    closedBracers += 1
                }
                else -> {
                    unusedBracers += 1
                }
            }
        }

        return openBracers == closedBracers
    }

    // Даны две строки строчных латинских символов: строка J и строка S.
    // Проверить, какое количество символов из S входит в J
    private fun checkOccurrences(j: String, s: String) : Int {
        val jArray = arrayListOf<Char>()
        val sArray = arrayListOf<Char>()
        val checkedSymbols = arrayListOf<Char>()
        j.asSequence().forEach { jArray.add(it) }
        s.asSequence().forEach { sArray.add(it) }
        var count = 0

        sArray.asSequence().forEach { sChar ->
            if (!checkedSymbols.contains(sChar)) {
                jArray.asSequence().forEachIndexed { index, jChar ->
                    if (jChar == sChar) {
                        count += 1
                        if (!checkedSymbols.contains(sChar)) {
                            checkedSymbols.add(sChar)
                        }
                    }
                }
            }
        }

        return count
    }

    private fun checkOccurrencesNoContainMethod(j: String, s: String) : Int {
        val jArray = arrayListOf<Char>()
        val sArray = arrayListOf<Char>()
        val checkedSymbols = arrayListOf<Char>()
        j.asSequence().forEach { jArray.add(it) }
        s.asSequence().forEach { sArray.add(it) }
        var count = 0

        sArray.asSequence().forEach { sChar ->
            for (jArrayIndex in jArray.indices) {
                if (sChar == jArray[jArrayIndex]) {
                    var toAdd = true
                    for (index in checkedSymbols.indices) {
                        if (checkedSymbols[index] == sChar) {
                            toAdd = false
                            break
                        }
                    }
                    if (toAdd) {
                        count += 1
                        checkedSymbols.add(sChar)
                    }
                    break
                }
            }
        }

        return count
    }
}
