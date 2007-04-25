/* Generated By:JavaCC: Do not edit this line. Parser.java */
   package nz.org.take.script.parser;
        import nz.org.take.script.*;
        public class Parser implements ParserConstants {
                Script select = new Script();
                public static void main(String[] args) throws ParseException,TokenMgrError {
                        Parser parser = new Parser(System.in);
                        parser.parse(new Script());
                }

  static final public void parse(Script script) throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
      case QUERY:
      case LABEL:
      case COMMENT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        var(script);
        break;
      case COMMENT:
        comment(script);
        break;
      case QUERY:
        query(script);
        break;
      case LABEL:
        rule(script);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void comment(Script script) throws ParseException {
        Token t;
         Comment c = new Comment();
    t = jj_consume_token(COMMENT);
         c.setText(t.image.substring(2));
         script.add(c);
  }

  static final public void query(Script script) throws ParseException {
         QuerySpec q = new QuerySpec();
    jj_consume_token(QUERY);
    predicateQ(q);
    jj_consume_token(21);
    io(q);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(22);
      io(q);
    }
    jj_consume_token(23);
         script.add(q);
  }

  static final public void predicateQ(QuerySpec q) throws ParseException {
        Token t;
    t = jj_consume_token(NAME);
         q.setPredicate(t.image);
  }

  static final public void io(QuerySpec q) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IN:
      in(q);
      break;
    case OUT:
      out(q);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void in(QuerySpec q) throws ParseException {
        Token t;
    t = jj_consume_token(IN);
         q.addToIOSpec(true);
  }

  static final public void out(QuerySpec q) throws ParseException {
        Token t;
    t = jj_consume_token(OUT);
         q.addToIOSpec(false);
  }

  static final public void var(Script script) throws ParseException {
         VariableDeclaration v = new VariableDeclaration();
    jj_consume_token(VAR);
    vartype(v);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOT:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      jj_consume_token(DOT);
      vartype(v);
    }
    varname(v);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      jj_consume_token(22);
      varname(v);
    }
         script.add(v);
  }

  static final public void vartype(VariableDeclaration var) throws ParseException {
        Token t;
    t = jj_consume_token(NAME);
         var.addToType(t.image);
  }

  static final public void varname(VariableDeclaration var) throws ParseException {
        Token t;
    t = jj_consume_token(NAME);
         var.addName(t.image);
  }

  static final public void rule(Script script) throws ParseException {
         Rule r = new Rule();
    id(r);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      jj_consume_token(IF);
      condition(r);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        jj_consume_token(AND);
        condition(r);
      }
      jj_consume_token(THEN);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    condition(r);
         script.add(r);
  }

  static final public void id(Rule r) throws ParseException {
        Token t;
    t = jj_consume_token(LABEL);
         r.setId(t.image.substring(0,t.image.length()-1));
  }

  static final public void condition(Rule r) throws ParseException {
         Condition c = new Condition();
    buildCondition(c);
         r.add(c);
  }

  static final public void buildCondition(Condition c) throws ParseException {
    if (jj_2_1(2)) {
      buildConditionType1(c);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NAME:
        buildConditionType2(c);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void buildConditionType1(Condition c) throws ParseException {
    term(c);
    jj_consume_token(DOT);
    predicate(c);
    jj_consume_token(21);
    terms(c);
    jj_consume_token(23);
         c.setPredicateType(PredicateType.JAVA);
  }

  static final public void buildConditionType2(Condition c) throws ParseException {
    predicate(c);
    jj_consume_token(21);
    terms(c);
    jj_consume_token(23);
         c.setPredicateType(PredicateType.SIMPLE);
  }

  static final public void terms(TermContainer c) throws ParseException {
    term(c);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      jj_consume_token(22);
      term(c);
    }
  }

  static final public void term(TermContainer c) throws ParseException {
    if (jj_2_2(3)) {
      variableTerm(c);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NAME:
        complexTerm(c);
        break;
      case STRING_LITERAL:
        stringLiteral(c);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void variableTerm(TermContainer c) throws ParseException {
        Token t;
         VariableTerm v = new VariableTerm();
    t = jj_consume_token(NAME);
         v.setName(t.image);
         c.add(v);
  }

  static final public void stringLiteral(TermContainer c) throws ParseException {
        Token t;
         ConstantTerm v = new ConstantTerm();
    t = jj_consume_token(STRING_LITERAL);
         v.setValue(t.image.substring(1,t.image.length()-1));
         v.setType("java.lang.String");
         c.add(v);
  }

  static final public void complexTerm(TermContainer c) throws ParseException {
         ComplexTerm ct = new ComplexTerm();
    function(ct);
    jj_consume_token(21);
    terms(ct);
    jj_consume_token(23);
         c.add(ct);
  }

  static final public void function(ComplexTerm ct) throws ParseException {
        Token t;
    t = jj_consume_token(NAME);
         ct.setFunction(t.image);
  }

  static final public void predicate(Condition c) throws ParseException {
        Token t;
    t = jj_consume_token(NAME);
         c.setPredicate(t.image);
  }

  static final private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static final private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static final private boolean jj_3R_8() {
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  static final private boolean jj_3R_12() {
    if (jj_3R_14()) return true;
    if (jj_scan_token(21)) return true;
    return false;
  }

  static final private boolean jj_3R_7() {
    if (jj_3R_9()) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  static final private boolean jj_3_2() {
    if (jj_3R_8()) return true;
    return false;
  }

  static final private boolean jj_3R_9() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) {
    jj_scanpos = xsp;
    if (jj_3R_11()) return true;
    }
    }
    return false;
  }

  static final private boolean jj_3_1() {
    if (jj_3R_7()) return true;
    return false;
  }

  static final private boolean jj_3R_10() {
    if (jj_3R_12()) return true;
    return false;
  }

  static final private boolean jj_3R_13() {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  static final private boolean jj_3R_14() {
    if (jj_scan_token(NAME)) return true;
    return false;
  }

  static final private boolean jj_3R_11() {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static public boolean lookingAhead = false;
  static private boolean jj_semLA;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x28440,0x28440,0x400000,0x1800,0x20,0x400000,0x80,0x100,0x10000,0x400000,0x50000,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[2];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static final private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector jj_expentries = new java.util.Vector();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  static public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[24];
    for (int i = 0; i < 24; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 24; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

  static final private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static final private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

        }
