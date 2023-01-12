package com.heavyweightsoftware.romannumeralconverter

import spock.lang.Specification

class RomanNumeralTest extends Specification {
    def "GetNumeralValue"() {
        expect:
        amt == RomanNumeral.getNumeralValue((char) romNum)

        where:
        romNum | amt
        'I' | 1
        'V' | 5
        'X' | 10
        'L' | 50
        'C' | 100
        'D' | 500
        'M' | 1000
        "G" | 0
    }

    def "ParseValue"() {
        expect:
        amt == RomanNumeral.parseValue(romNum)

        where:
        romNum | amt
        "I" | 1
        "II" | 2
        "III" | 3
        "IV" | 4
        "V" | 5
        "VI" | 6
        "VII" | 7
        "VIII" | 8
        "IX" | 9
        "X" | 10
        "XI" | 11
        "XII" | 12
        "XIII" | 13
        "XIV" | 14
        "XV" | 15
        "XVI" | 16
        "XVII" | 17
        "XVIII" | 18
        "XIX" | 19
        "XX" | 20
        "XXI" | 21
        "XXII" | 22
        "XXIII" | 23
        "XXIV" | 24
        "XXV" | 25
        "XX" | 20
        "XXV" | 25
        "XXX" | 30
        "XXXV" | 35
        "XL" | 40
        "XLV" | 45
        "L" | 50
        "LV" | 55
        "LX" | 60
        "LXV" | 65
        "LXX" | 70
        "LXXV" | 75
        "LXXX" | 80
        "LXXXV" | 85
        "XC" | 90
        "XCV" | 95
        "IC" | 99
        "C" | 100
        "CV" | 105
        "CX" | 110
        "CXV" | 115
        "CXX" | 120
        "CXXV" | 125
        "CXXX" | 130
        "CXXXV" | 135
        "CXL" | 140
        "C" | 100
        "CXXV" | 125
        "CL" | 150
        "CLXXV" | 175
        "CC" | 200
        "CCXXV" | 225
        "CCL" | 250
        "CCLXXV" | 275
        "CCC" | 300
        "CCCXXV" | 325
        "CCCL" | 350
        "CCCLXXV" | 375
        "CD" | 400
        "CDXXV" | 425
        "CDL" | 450
        "CDLXXV" | 475
        "D" | 500
        "DXXV" | 525
        "DL" | 550
        "DLXXV" | 575
        "DC" | 600
        "DCXXV" | 625
        "DCL" | 650
        "DCLXXV" | 675
        "DCC" | 700
        "DCCL" | 750
        "DCCCXXV" | 825
        "CM" | 900
        "CMLXXV" | 975
        "ML" | 1050
        "MCXXV" | 1125
        "MCC" | 1200
        "MCCLXXV" | 1275
        "MCCCL" | 1350
        "MCDXXV" | 1425
        "MD" | 1500
        "MDLXXV" | 1575
        "MDCL" | 1650
        "MDCCXXV" | 1725
        "MDCCC" | 1800
        "MDCCCLXXV" | 1875
        "MCML" | 1950
        "MIM" | 1999
        "MMXXV" | 2025
        "MMC" | 2100
        "MMCLXXV" | 2175
        "MMCCL" | 2250
        "MMCCCXXV" | 2325
        "MMCD" | 2400
        "MMCDLXXV" | 2475
        "MMDL" | 2550
    }
}
