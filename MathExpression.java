
public class MathExpression extends Expression
{
	private Expression leftOperand;
	private Expression rightOperand;
	private OpExpression operator;
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression operator)
	{
		this.setLeftOperand(leftOperand);
		this.setRightOperand(rightOperand);
		this.setOperator(operator);
	}

	public Expression getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}

	public Expression getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}

	public OpExpression getOperator() {
		return operator;
	}

	public void setOperator(OpExpression operator) {
		this.operator = operator;
	}
}
