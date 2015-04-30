
public class Parser 
{
	private String theStmt;
	private int pos; //where am I in the theStmt string
	private static final String legalVariableCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
	private static final String legalOpCharacters = "+-*/% ";
	private VarExpression var1 = new VarExpression("");
	private VarExpression var2 = new VarExpression("");
	private VarExpression mainvar = new VarExpression(""); 
	private OpExpression operator = new OpExpression('-'); 
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
		
	}
	
	private String getNextToken(char c)
	{
		while(pos < this.theStmt.length())
		{
			if(this.theStmt.charAt(pos) == c)
			{
				pos++;
				break;
			}
			pos++;
		}
		return "" + c;
	}
	
	private String getNextToken(String legalChars)
	{
		String token = "";
		while(pos < this.theStmt.length())
		{
			if(legalChars.indexOf(this.theStmt.charAt(pos)) != -1)
			{
				token += this.theStmt.charAt(pos);
			}
			else
			{
				//this means we are at the end of the token
				//We are always trimming leading and trailing spaces
				//move forward one
				break;
			}
			pos++;
		}
		return token.trim();
	}
	
	private void parse_stmt()
	{
		//Print each time it reads something like:
		// Read: VarName = a
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		System.out.println("Read VarName: " + varName);
		mainvar.setVarName(varName); 
		System.out.println("set varexpression object: " + mainvar.getVarName()); 
		
		//burn past the =
		this.getNextToken('=');
		System.out.println("Burned =");
		
		// Reading: Math-Expr
		this.parse_math_expr();
		
		//burn past the ;
		this.getNextToken(';');
		System.out.println("Burned ;");
		
	}
	
	private void parse_math_expr()
	{
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			this.parse_math_expr();
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			var1.setVarName(varName);
			System.out.println("set varexpression object: " + var1.getVarName());
			
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		operator.setTheOp(op.charAt(0));
		System.out.println("set OpExpression object: " + operator.getTheOp());
		
		varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			this.parse_math_expr();
			this.getNextToken(')');
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			var2.setVarName(varName);
			System.out.println("set varexpression object: " + var2.getVarName());
		}
		MathExpression mather = new MathExpression(var1, var2, this.operator);
		VarDefStatement thestatement = new VarDefStatement(var2, mather); 
		System.out.println("The VarDefStatement VarExpression" + thestatement.getTheVarExpr().getVarName());
		
	}
	
}
