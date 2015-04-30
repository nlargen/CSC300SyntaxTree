
public class VarDefStatement 
{
	private VarExpression theVarExpr;
	private MathExpression theMathExpr;
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr)
	{
		this.setTheVarExpr(theVarExpr);
		this.setTheMathExpr(theMathExpr);
	}

	public VarExpression getTheVarExpr() {
		return theVarExpr;
	}

	public void setTheVarExpr(VarExpression theVarExpr) {
		this.theVarExpr = theVarExpr;
	}

	public MathExpression getTheMathExpr() {
		return theMathExpr;
	}

	public void setTheMathExpr(MathExpression theMathExpr) {
		this.theMathExpr = theMathExpr;
	}
}
