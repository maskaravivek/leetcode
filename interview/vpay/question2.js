function solution(input) {
    var len = input.length;

    var arr = input.split('');
    if (len <= 1) {
        return false;
    }

    var containsParenthesis = false;
    var containsNegative = false;
    var containsDecimal = false;
    var containsCurrency = false;
    var numberOfThousands = 0;
    var numberOfDigits = 0;
    var decimalIndex = -1;
    var lastDigit = '';
    var lastDigitIndex = -1;
    for (let i = len - 1; i >= 0; i--) {
        if (arr[i] === ')') {
            // console.log('paren end')
            if (i !== len - 1) {
                return false;
            } else {
                containsParenthesis = true;
            }
        } else if (arr[i] === '(') {
            if (i !== 0 || !containsParenthesis) {
                return false;
            }
        } else if ((arr[i] === '$' || arr[i] === '¥' || arr[i] === '€')) {
            containsCurrency = true;
            if (!(i === 0 || i === 1)) {
                return false;
            }
            if (arr[i] === '¥' && containsDecimal) {
                return false;
            }
        } else if (arr[i] === ',') {
            numberOfThousands = numberOfThousands + 1;
        } else if (arr[i] === '-') {
            if (i != 0) {
                return false;
            } else {
                containsNegative = true;
            }
        } else if (arr[i] === '.') {
            if (i <= 1 || i == len - 1 || containsDecimal) {
                return false;
            } else {
                containsDecimal = true;
                decimalIndex = i;
            }
        } else {
            if (isNaN(parseInt(arr[i], 10))) {
                return false;
            } else {
                lastDigit = arr[i];
                lastDigitIndex = i;
                numberOfDigits = numberOfDigits + 1;
            }
        }
    }

    if (containsNegative && containsParenthesis) {
        return false;
    }

    if (!containsCurrency) {
        return false;
    }

    if (containsDecimal && len - decimalIndex - 1 !== 2) {
        return false;
    }

    if (numberOfDigits == 0) {
        return false;
    }

    if (lastDigit === '0' && numberOfDigits > 1) {
        if (arr[lastDigitIndex + 1] !== '.') {
            return false;
        }
    }

    console.log((numberOfDigits / 3) - 1)
    if (numberOfThousands !== 0 && (numberOfDigits / 3) - 1 !== numberOfThousands) {
        console.log(numberOfDigits / 3)
        if (numberOfDigits % 3 === 0) {
            if ((numberOfDigits / 3) - 1 !== numberOfThousands) {
                return false;
            }
        } else {
            if (Math.floor(numberOfDigits / 3) !== numberOfThousands) {
                return false;
            }
        }
    }



    return true;
}

// console.log(solution("$450"))
// console.log(solution("$450,000"))
// console.log(solution("-€23"))
// console.log(solution("(¥2400)"))
// console.log(solution("$4500.00"))
// console.log(solution("€0.25"))
// console.log(solution("cat"))
// console.log(solution("$45,0"))
// console.log(solution("$45,0"))
// console.log(solution("$45,0"))
// console.log(solution("(€350"))
// console.log(solution("(-$3.50)"))
// console.log(solution("¥120.00"))
// console.log(solution("$-50"))
// console.log(solution(" €43.25"))
// console.log(solution("$65."))
// console.log(solution("€82.1"))
// console.log(solution("45.50"))
console.log(solution("¥1200,000"))

// console.log(solution("$4,500"))
// console.log(solution("€1,000,000"))
// console.log(solution("¥1,200,000"))

// console.log(solution("¥0.10"))