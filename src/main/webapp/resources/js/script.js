var myFunc = function (evt) {};
var canvasId = "myCanvas";
var yId = "myCanvas";
var xId = "myCanvas";
document.getElementById(canvasId).addEventListener("click", myFunc);
var myGraph;
function draw(R) {
    myGraph = new Graph({
        canvasId: canvasId,
        minX: -3,
        minY: -6,
        maxX: 3,
        maxY: 6,
        unitsPerTick: 1
    });

    myGraph.canvas.removeEventListener("click", myFunc);
    myFunc = function (evt) {
        var answer = myGraph.getClickCoords(evt);
        alert("Point is (" + answer.x + ";" + answer.y + ")");
        document.getElementById(xId).value = answer.x;
        document.getElementById(yId).value = answer.y;
    };
    myGraph.canvas.addEventListener("click", myFunc);

    myGraph.drawEquationX(function (x) {
        var y = Number(x) + Number(x) - Number(R);
        if (x < 0 || x > R/2)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        var y = Math.sqrt(R * R / 4 - x * x);
        if (x > 0 || isNaN(y) || y < 0)
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
        if (x > R/2 || x < -R/2)
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
        if (y > R/2 || y < -R)
            return null;
        return x;
    }, 'blue', 3);

    /* Draws a point
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
    */
}
