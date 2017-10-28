var myFunc = function (evt) {};
var canvasId = "myCanvas";
document.getElementById(canvasId).addEventListener("click", myFunc);
var myGraph;

function draw() {
    var R = document.forms[0].R.value;
    myGraph = new Graph({
        canvasId: canvasId,
        minX: -4,
        minY: -5,
        maxX: 4,
        maxY: 5,
        unitsPerTick: 1
    });

    myGraph.canvas.removeEventListener("click", myFunc);
    myFunc = function (evt) {
        var answer = myGraph.getClickCoords(evt);
        window.location.href = "index.html?R=" + Number(R) + "&Y=" + Number(answer.y) + "&X=" + Number(answer.x);
    };
    myGraph.canvas.addEventListener("click", myFunc);

    myGraph.drawEquationX(function (x) {
        var y = Number(R) + 2 * Number(x);
        if (x < 0 || y > 0)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        var y = Math.sqrt(R * R / 4 - x * x);
        if (x > 0 || y < 0)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        var y = -R;
        if (x > 0 || x < -R/2)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        var y = 0;
        if (x > 0 || x < -R/2)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationY(function (y) {
        var x = -R/2;
        if (y > 0 || y < -R)
            return null;
        return x;
    }, 'blue', 3);

    myGraph.drawEquationY(function (y) {
        var x = 0;
        if (y > 0 || y < -R)
            return null;
        return x;
    }, 'blue', 3);

    const ctx = myGraph.context;
    const centerX = myGraph.centerX;
    const centerY = myGraph.centerY;
    const unitX = myGraph.unitX;
    const unitY = myGraph.unitY;
    var X = 0;
    var Y = 0;
    ctx.beginPath();
    ctx.arc(X, Y, 3, 0, 2 * Math.PI, true);
    ctx.fill();
    ctx.stroke();
}
