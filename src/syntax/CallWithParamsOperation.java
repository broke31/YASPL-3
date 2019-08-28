package syntax;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java_cup.runtime.ComplexSymbolFactory.Location;
import visitor.Visitor;

public class CallWithParamsOperation extends StatementNode {
  private final IdentifierExpression functionName;
  private String domain;
  private final List<Expression> args;

  public CallWithParamsOperation(Location left, Location right, IdentifierExpression id,
      List<Expression> args) {
    super(left, right);
    this.functionName = id;
    Collections.reverse(args);
    this.args = args;
  }


  public IdentifierExpression getFunctionName() {
    return functionName;
  }

  public List<Expression> getArgs() {
    return args;
  }

  @Override
  public <T, P> T accept(Visitor<T, P> visitor, P param) {
    return visitor.visit(this, param);
  }

  public String getDomain() {
    StringJoiner sj = new StringJoiner(",");
    args.forEach(e -> sj.add(e.getNodeType().getValue()));
    this.domain = sj.toString();
    return sj.toString();
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }
}
