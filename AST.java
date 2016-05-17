//AST.java


abstract class ExprArith {

    abstract int eval ();

}//ExprArith

abstract class BinOpArith extends ExprArith {

    ExprArith e1, e2;

}//BinOp

class Cte extends ExprArith {

    int val;

    Cte (int val) {
        this.val = val;
    }//Cte

    int eval () {
        return val;
    }//eval

}//Cte


class Inv extends ExprArith {

    ExprArith e;

    Inv (ExprArith e) {
        this.e = e;
    }//Inv

    int eval () {
        return -e.eval();
    }//eval

}//Inv




class Add extends BinOpArith {

    Add (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Add

    int eval () {
        return e1.eval() + e2.eval();
    }//eval

}//Add

class Sub extends BinOpArith {

    Sub (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Sub

    int eval () {
        return e1.eval() - e2.eval();
    }//eval

}//Sub

class Mul extends BinOpArith {

    Mul (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Mul

    int eval () {
        return e1.eval() * e2.eval();
    }//eval

}//Mul

class Div extends BinOpArith {

    Div (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Div

    int eval () {
        return e1.eval() / e2.eval();
    }//eval

}//Div

class  Number extends ExprArith{

    int val;

    Number (int val) {
        this.val = val;
    }//Number
    int eval () {
        return val;
    }//eval
}


abstract class ExprBool{

    abstract boolean eval ();

}

abstract class BinOpBool extends ExprBool{

	ExprBool e1, e2;
}

abstract class BinOpBoolArith extends ExprBool{
	ExprArith e1, e2;
}


/*class Bool extends ExprBool {

    boolean val;

    Bool (boolean bool) {
        this.val = val;
    }

    boolean eval () {
        return val;
    }
}*/

class Oppose extends ExprBool {

    ExprBool e;

    Oppose (ExprBool e) {
        this.e = e;
    }//Oppose

    boolean eval () {
        return !e.eval();
    }//eval
}


/*class ArrayOfInt extends {
	int[] tab;

    int[] ArrayOfInt (int[] tab) {
        this.tab = tab[];
    }
    int eval () {
        return tab;
    }
}*/



class And extends BinOpBool {

	And (ExprBool e1, ExprBool e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//And

    boolean eval () {
        return e1.eval()&&e2.eval();
    }//eval
}

class Or extends BinOpBool {

    Or (ExprBool e1, ExprBool e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Or
    boolean eval () {
        return e1.eval()||e2.eval();
    }//eval
}

class Superior extends BinOpBoolArith {

	Superior (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Superior

    boolean eval () {
        return e1.eval()>e2.eval();
    }//eval
}

class Inferior extends BinOpBoolArith {
	Inferior (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Inferior

    boolean eval () {
        return e1.eval()<e2.eval();
    }//eval
}

class Egal extends BinOpBoolArith {
	Egal (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Egal

    boolean eval () {
        return e1.eval()==e2.eval();
    }//eval
}

class Different extends BinOpBoolArith {
	Different (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//Different

    boolean eval () {
        return !(e1.eval()==e2.eval());
    }//eval

}

class SuperiorEqual extends BinOpBoolArith {

    SuperiorEqual (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//SuperiorEqual

    boolean eval () {
        return (e1.eval()>=e2.eval());
    }//eval

}

class InferiorEqual extends BinOpBoolArith {

    InferiorEqual (ExprArith e1, ExprArith e2) {
        this.e1 = e1;
        this.e2 = e2;
    }//InferiorEqual

    boolean eval () {
        return (e1.eval()<=e2.eval());
    }//eval
}


