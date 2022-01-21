function solution(nums) {
    let answer = 0;
    const NUMS_LENGTH = nums.length;
    for(let i = 0; i < NUMS_LENGTH; i++) {
        for(let j = i + 1; j < NUMS_LENGTH; j++) {
            for(let k = j + 1; k < NUMS_LENGTH; k++){
                let num = nums[i] + nums[j] + nums[k];
                if(isPrime(num)) {
                    answer++;
                }
            }
        }
    }
    return answer;
}

/* 소수 판별 - https://stackoverflow.com/questions/40200089/number-prime-test-in-javascript */
const isPrime = function (num) {
    for(let i = 2, s = Math.sqrt(num); i <= s; i++)
        if(num % i === 0) return false;
    return num > 1;
}

console.log(solution([1, 2, 7, 6, 4]));