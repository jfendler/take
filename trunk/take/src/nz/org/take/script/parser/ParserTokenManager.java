/* Generated By:JavaCC: Do not edit this line. ParserTokenManager.java */
package nz.org.take.script.parser;
import nz.org.take.script.*;

public class ParserTokenManager implements ParserConstants
{
  public static  java.io.PrintStream debugStream = System.out;
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0xff00L) != 0L)
         {
            jjmatchedKind = 21;
            return 21;
         }
         if ((active0 & 0x2L) != 0L)
            return 11;
         return -1;
      case 1:
         if ((active0 & 0x4800L) != 0L)
            return 21;
         if ((active0 & 0xb700L) != 0L)
         {
            jjmatchedKind = 21;
            jjmatchedPos = 1;
            return 21;
         }
         return -1;
      case 2:
         if ((active0 & 0x8700L) != 0L)
            return 21;
         if ((active0 & 0x3000L) != 0L)
         {
            jjmatchedKind = 21;
            jjmatchedPos = 2;
            return 21;
         }
         return -1;
      case 3:
         if ((active0 & 0x1000L) != 0L)
            return 21;
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 21;
            jjmatchedPos = 3;
            return 21;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 3;
         return jjMoveStringLiteralDfa1_0(0x10L);
      case 32:
         return jjStartNfaWithStates_0(0, 1, 11);
      case 40:
         return jjStopAtPos(0, 26);
      case 41:
         return jjStopAtPos(0, 28);
      case 44:
         return jjStopAtPos(0, 27);
      case 46:
         return jjStopAtPos(0, 5);
      case 58:
         return jjStopAtPos(0, 7);
      case 59:
         return jjStopAtPos(0, 25);
      case 61:
         return jjStopAtPos(0, 6);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x4800L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 81:
      case 113:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa1_0(0x100L);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
static private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(1, 4);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 70:
      case 102:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(1, 11, 21);
         break;
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 78:
      case 110:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(1, 14, 21);
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0xa000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 68:
      case 100:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 21);
         break;
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x3000L);
      case 70:
      case 102:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 21);
         break;
      case 82:
      case 114:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(2, 8, 21);
         break;
      case 84:
      case 116:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(2, 15, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 78:
      case 110:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 21);
         break;
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 89:
      case 121:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 13, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
static private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
static private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 21;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 21)
                        kind = 21;
                     jjCheckNAdd(20);
                  }
                  else if (curChar == 58)
                  {
                     if (kind > 20)
                        kind = 20;
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(18, 19);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 18)
                        kind = 18;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 32)
                  {
                     if (kind > 24)
                        kind = 24;
                     jjCheckNAdd(11);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(9, 10);
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 1:
                  if ((0xaffff42b00000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 4:
                  if ((0xaffff42b00000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 5:
                  if (curChar != 47)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(6);
                  break;
               case 6:
                  if ((0x8bffb42b00000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 8:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(9, 10);
                  break;
               case 9:
                  if ((0x8bffb42b00000000L & l) != 0L)
                     jjCheckNAddTwoStates(9, 10);
                  break;
               case 10:
                  if (curChar == 34 && kind > 23)
                     kind = 23;
                  break;
               case 11:
                  if (curChar != 32)
                     break;
                  if (kind > 24)
                     kind = 24;
                  jjCheckNAdd(11);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAddStates(0, 2);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  jjCheckNAdd(13);
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(14, 15);
                  break;
               case 15:
                  if (curChar == 46)
                     jjCheckNAdd(16);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(16);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(18, 19);
                  break;
               case 19:
                  if (curChar == 58 && kind > 20)
                     kind = 20;
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 21:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 21)
                        kind = 21;
                     jjCheckNAdd(20);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddTwoStates(18, 19);
                  break;
               case 2:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 21)
                        kind = 21;
                     jjCheckNAddStates(3, 5);
                  }
                  else if (curChar == 64)
                  {
                     if (kind > 17)
                        kind = 17;
                     jjCheckNAdd(4);
                  }
                  if (curChar == 64)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar != 64)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(1);
                  break;
               case 1:
                  if ((0x7fffffe97fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAdd(1);
                  break;
               case 3:
                  if (curChar != 64)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x7fffffe97fffffeL & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(4);
                  break;
               case 6:
                  if ((0x7fffffe97ffffffL & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 9:
                  if ((0x7fffffe97ffffffL & l) != 0L)
                     jjAddStates(6, 7);
                  break;
               case 17:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAddStates(3, 5);
                  break;
               case 18:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddTwoStates(18, 19);
                  break;
               case 20:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 21 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   13, 14, 15, 18, 19, 20, 9, 10, 
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\56", "\75", "\72", null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, "\73", 
"\50", "\54", "\51", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x1fffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[21];
static private final int[] jjstateSet = new int[42];
static protected char curChar;
public ParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}
public ParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 21; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

public static Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 10 && (0x400L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
