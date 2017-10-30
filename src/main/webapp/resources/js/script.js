function drawAPoint(X, Y, result, myGraph) {
    alert("Point is ("+X+";"+Y+"), result="+result);
    if (result == true) {
        myGraph.drawPoint(X, Y, 'green');
    }
    else {
        myGraph.drawPoint(X, Y, 'orange');
    }
}
function draw(rId,myGraph) {
    myGraph.context.clearRect(0, 0, myGraph.canvas.width, myGraph.canvas.height);
    const R = ice.ace.instance(rId).getValue();
    myGraph.drawXAxis();
    myGraph.drawYAxis();
    myGraph.drawEquationX(function (x) {
        const y = Number(x) + Number(x) - Number(R);
        if (x < 0 || x > R/2)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        const y = Math.sqrt(R * R / 4 - x * x);
        if (x > 0 || isNaN(y) || y < 0)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        const y = -R;
        if (x > 0 || x < -R/2)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationX(function (x) {
        const y = 0;
        if (x > R/2 || x < -R/2)
            return null;
        return y;
    }, 'blue', 3);

    myGraph.drawEquationY(function (y) {
        const x = -R/2;
        if (y > 0 || y < -R)
            return null;
        return x;
    }, 'blue', 3);

    myGraph.drawEquationY(function (y) {
        const x = 0;
        if (y > R/2 || y < -R)
            return null;
        return x;
    }, 'blue', 3);
}
