function TreeNode (val, left, right) {
    this.val = (val === undefined ? 0  : val);
    this.left = (left===undefined ? null : left);
    this.right = (right===undefined ? null : right);
}

const allPossibleFBT = function (n) {
    const resultList = [];

    if (n % 2 === 0) return resultList;
    if (n === 1) {
        resultList.push(new TreeNode(0));
        return resultList;
    }
    n -= 1;

    for (let i = 1; i <= n; i += 2) {
        const left = allPossibleFBT(i);
        const right = allPossibleFBT(n - i);

        for (const l of left) {
            for(const r of right) {
                const root = new TreeNode(0, l, r);
                resultList.push(root);
            }
        }
    }

    return resultList;
}

const result = allPossibleFBT(7);