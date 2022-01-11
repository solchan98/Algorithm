const swap = function (arr) {
  const temp = arr[0];
  arr[0] = arr[1];
  arr[1] = temp;
}

const solution = function (arrList) {
  let x = 0, y = 0;
  arrList.map((arr) => {
    if(arr[1] > arr[0]) {
      swap(arr);
    }
    if(arr[0] > x) {
      x = arr[0];
    }
    if(arr[1] > y) {
      y = arr[1];
    }
  });
  return x * y;
}

const result = solution([[60, 50], [30, 70], [60, 30], [80, 40]]);
console.log(result);