package com.oriaxx77.algorythm.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Transform a simple math expression (num,+,-,*(,),/) in infix notation to
 * postfix notation. 
 * E.g. 3+4 becomes 3 4 + .
 * E.g. A * B + C becomes A B * C +
 * 
 *
 */
public class ShuntingYardInfixToPostfix 
{
	
	
	
	public String transform( String infix )
	{
		final String ops = "-+/*^";
        StringBuilder postfix = new StringBuilder();
        Stack<Integer> operators = new Stack<>();
		
		for (String token : infix.split("\\s")) 
		{
            if (token.isEmpty())
                continue;
            char symbol = token.charAt( 0 );    
            int idx = ops.indexOf( symbol );
            
            // check for operator
            if ( idx != -1 ) 
            {
            	if ( operators.isEmpty() )
            	{
            		operators.push( idx );
            	}
            		
            }
		}
		
		System.out.println( Arrays.toString( infix.split( "\\s" ) ) );
//		String clearStr = clearUnwantedChars( str );
//		
//		
//		
//		
//		List<String> tokenList = Arrays.asList( s.split( " " ) );
//									 
//		// current symbol
//		// operator stack
//		// postfix string
//		
//		System.out.println( tokenList ); 
		return "";
	}

	
	private String clearUnwantedChars( String s ) {
		return s.chars().filter( this::allowedChar ).mapToObj( String::valueOf ).collect( Collectors.joining() ); 
	}
	
	private boolean allowedChar( int c ) {
		String charString = new StringBuilder().append( (char)c ).toString();
		return "0123456789+/*-".contains( charString );
	}
	
	public static void main(String[] args) {
		
		ShuntingYardInfixToPostfix infixToPostfix = new ShuntingYardInfixToPostfix();
		infixToPostfix.transform( "3 + 4 - 6" );
		
		System.out.println( );
	}
}
