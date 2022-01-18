package org.eclipse.xtext.xtext.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_JAVACODESTRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'false'", "'true'", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'tokenLimit'", "'setup'", "'.'", "'generate'", "'as'", "'import'", "'@'", "':'", "';'", "'returns'", "'<'", "'>'", "'::'", "'|'", "'&'", "'?=>'", "'{'", "'}'", "'current'", "'!'", "'['", "']'", "'terminal'", "'->'", "'EOF'", "'..'", "'enum'", "'hidden'", "'hoistingDebug'", "'fragment'", "'=>'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_JAVACODESTRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalXtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtext.g"; }


    	private XtextGrammarAccess grammarAccess;

    	public void setGrammarAccess(XtextGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleGrammar"
    // InternalXtext.g:53:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // InternalXtext.g:54:1: ( ruleGrammar EOF )
            // InternalXtext.g:55:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammar();

            state._fsp--;

             after(grammarAccess.getGrammarRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // InternalXtext.g:62:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:66:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // InternalXtext.g:67:2: ( ( rule__Grammar__Group__0 ) )
            {
            // InternalXtext.g:67:2: ( ( rule__Grammar__Group__0 ) )
            // InternalXtext.g:68:3: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // InternalXtext.g:69:3: ( rule__Grammar__Group__0 )
            // InternalXtext.g:69:4: rule__Grammar__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleInitBlock"
    // InternalXtext.g:78:1: entryRuleInitBlock : ruleInitBlock EOF ;
    public final void entryRuleInitBlock() throws RecognitionException {
        try {
            // InternalXtext.g:79:1: ( ruleInitBlock EOF )
            // InternalXtext.g:80:1: ruleInitBlock EOF
            {
             before(grammarAccess.getInitBlockRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInitBlock();

            state._fsp--;

             after(grammarAccess.getInitBlockRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInitBlock"


    // $ANTLR start "ruleInitBlock"
    // InternalXtext.g:87:1: ruleInitBlock : ( ( rule__InitBlock__Group__0 ) ) ;
    public final void ruleInitBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:91:2: ( ( ( rule__InitBlock__Group__0 ) ) )
            // InternalXtext.g:92:2: ( ( rule__InitBlock__Group__0 ) )
            {
            // InternalXtext.g:92:2: ( ( rule__InitBlock__Group__0 ) )
            // InternalXtext.g:93:3: ( rule__InitBlock__Group__0 )
            {
             before(grammarAccess.getInitBlockAccess().getGroup()); 
            // InternalXtext.g:94:3: ( rule__InitBlock__Group__0 )
            // InternalXtext.g:94:4: rule__InitBlock__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__InitBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInitBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInitBlock"


    // $ANTLR start "entryRuleGrammarID"
    // InternalXtext.g:103:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // InternalXtext.g:104:1: ( ruleGrammarID EOF )
            // InternalXtext.g:105:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // InternalXtext.g:112:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:116:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // InternalXtext.g:117:2: ( ( rule__GrammarID__Group__0 ) )
            {
            // InternalXtext.g:117:2: ( ( rule__GrammarID__Group__0 ) )
            // InternalXtext.g:118:3: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // InternalXtext.g:119:3: ( rule__GrammarID__Group__0 )
            // InternalXtext.g:119:4: rule__GrammarID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalXtext.g:128:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalXtext.g:129:1: ( ruleAbstractRule EOF )
            // InternalXtext.g:130:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalXtext.g:137:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:141:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalXtext.g:142:2: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalXtext.g:142:2: ( ( rule__AbstractRule__Alternatives ) )
            // InternalXtext.g:143:3: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalXtext.g:144:3: ( rule__AbstractRule__Alternatives )
            // InternalXtext.g:144:4: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // InternalXtext.g:153:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // InternalXtext.g:154:1: ( ruleAbstractMetamodelDeclaration EOF )
            // InternalXtext.g:155:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // InternalXtext.g:162:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:166:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // InternalXtext.g:167:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // InternalXtext.g:167:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // InternalXtext.g:168:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // InternalXtext.g:169:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // InternalXtext.g:169:4: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractMetamodelDeclaration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // InternalXtext.g:178:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // InternalXtext.g:179:1: ( ruleGeneratedMetamodel EOF )
            // InternalXtext.g:180:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGeneratedMetamodel();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // InternalXtext.g:187:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:191:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // InternalXtext.g:192:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // InternalXtext.g:192:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // InternalXtext.g:193:3: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // InternalXtext.g:194:3: ( rule__GeneratedMetamodel__Group__0 )
            // InternalXtext.g:194:4: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // InternalXtext.g:203:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // InternalXtext.g:204:1: ( ruleReferencedMetamodel EOF )
            // InternalXtext.g:205:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReferencedMetamodel();

            state._fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // InternalXtext.g:212:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:216:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // InternalXtext.g:217:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // InternalXtext.g:217:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // InternalXtext.g:218:3: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // InternalXtext.g:219:3: ( rule__ReferencedMetamodel__Group__0 )
            // InternalXtext.g:219:4: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleAnnotation"
    // InternalXtext.g:228:1: entryRuleAnnotation : ruleAnnotation EOF ;
    public final void entryRuleAnnotation() throws RecognitionException {
        try {
            // InternalXtext.g:229:1: ( ruleAnnotation EOF )
            // InternalXtext.g:230:1: ruleAnnotation EOF
            {
             before(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getAnnotationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalXtext.g:237:1: ruleAnnotation : ( ( rule__Annotation__Group__0 ) ) ;
    public final void ruleAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:241:2: ( ( ( rule__Annotation__Group__0 ) ) )
            // InternalXtext.g:242:2: ( ( rule__Annotation__Group__0 ) )
            {
            // InternalXtext.g:242:2: ( ( rule__Annotation__Group__0 ) )
            // InternalXtext.g:243:3: ( rule__Annotation__Group__0 )
            {
             before(grammarAccess.getAnnotationAccess().getGroup()); 
            // InternalXtext.g:244:3: ( rule__Annotation__Group__0 )
            // InternalXtext.g:244:4: rule__Annotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleParserRule"
    // InternalXtext.g:253:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // InternalXtext.g:254:1: ( ruleParserRule EOF )
            // InternalXtext.g:255:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRule();

            state._fsp--;

             after(grammarAccess.getParserRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // InternalXtext.g:262:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:266:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // InternalXtext.g:267:2: ( ( rule__ParserRule__Group__0 ) )
            {
            // InternalXtext.g:267:2: ( ( rule__ParserRule__Group__0 ) )
            // InternalXtext.g:268:3: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // InternalXtext.g:269:3: ( rule__ParserRule__Group__0 )
            // InternalXtext.g:269:4: rule__ParserRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "ruleRuleNameAndParams"
    // InternalXtext.g:279:1: ruleRuleNameAndParams : ( ( rule__RuleNameAndParams__Group__0 ) ) ;
    public final void ruleRuleNameAndParams() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:283:2: ( ( ( rule__RuleNameAndParams__Group__0 ) ) )
            // InternalXtext.g:284:2: ( ( rule__RuleNameAndParams__Group__0 ) )
            {
            // InternalXtext.g:284:2: ( ( rule__RuleNameAndParams__Group__0 ) )
            // InternalXtext.g:285:3: ( rule__RuleNameAndParams__Group__0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 
            // InternalXtext.g:286:3: ( rule__RuleNameAndParams__Group__0 )
            // InternalXtext.g:286:4: rule__RuleNameAndParams__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "entryRuleParameter"
    // InternalXtext.g:295:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalXtext.g:296:1: ( ruleParameter EOF )
            // InternalXtext.g:297:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalXtext.g:304:1: ruleParameter : ( ( rule__Parameter__NameAssignment ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:308:2: ( ( ( rule__Parameter__NameAssignment ) ) )
            // InternalXtext.g:309:2: ( ( rule__Parameter__NameAssignment ) )
            {
            // InternalXtext.g:309:2: ( ( rule__Parameter__NameAssignment ) )
            // InternalXtext.g:310:3: ( rule__Parameter__NameAssignment )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment()); 
            // InternalXtext.g:311:3: ( rule__Parameter__NameAssignment )
            // InternalXtext.g:311:4: rule__Parameter__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Parameter__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeRef"
    // InternalXtext.g:320:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalXtext.g:321:1: ( ruleTypeRef EOF )
            // InternalXtext.g:322:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalXtext.g:329:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:333:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalXtext.g:334:2: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalXtext.g:334:2: ( ( rule__TypeRef__Group__0 ) )
            // InternalXtext.g:335:3: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // InternalXtext.g:336:3: ( rule__TypeRef__Group__0 )
            // InternalXtext.g:336:4: rule__TypeRef__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // InternalXtext.g:345:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:346:1: ( ruleAlternatives EOF )
            // InternalXtext.g:347:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // InternalXtext.g:354:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:358:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // InternalXtext.g:359:2: ( ( rule__Alternatives__Group__0 ) )
            {
            // InternalXtext.g:359:2: ( ( rule__Alternatives__Group__0 ) )
            // InternalXtext.g:360:3: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // InternalXtext.g:361:3: ( rule__Alternatives__Group__0 )
            // InternalXtext.g:361:4: rule__Alternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleConditionalBranch"
    // InternalXtext.g:370:1: entryRuleConditionalBranch : ruleConditionalBranch EOF ;
    public final void entryRuleConditionalBranch() throws RecognitionException {
        try {
            // InternalXtext.g:371:1: ( ruleConditionalBranch EOF )
            // InternalXtext.g:372:1: ruleConditionalBranch EOF
            {
             before(grammarAccess.getConditionalBranchRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getConditionalBranchRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // InternalXtext.g:379:1: ruleConditionalBranch : ( ( rule__ConditionalBranch__Alternatives ) ) ;
    public final void ruleConditionalBranch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:383:2: ( ( ( rule__ConditionalBranch__Alternatives ) ) )
            // InternalXtext.g:384:2: ( ( rule__ConditionalBranch__Alternatives ) )
            {
            // InternalXtext.g:384:2: ( ( rule__ConditionalBranch__Alternatives ) )
            // InternalXtext.g:385:3: ( rule__ConditionalBranch__Alternatives )
            {
             before(grammarAccess.getConditionalBranchAccess().getAlternatives()); 
            // InternalXtext.g:386:3: ( rule__ConditionalBranch__Alternatives )
            // InternalXtext.g:386:4: rule__ConditionalBranch__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // InternalXtext.g:395:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // InternalXtext.g:396:1: ( ruleUnorderedGroup EOF )
            // InternalXtext.g:397:1: ruleUnorderedGroup EOF
            {
             before(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnorderedGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // InternalXtext.g:404:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:408:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // InternalXtext.g:409:2: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // InternalXtext.g:409:2: ( ( rule__UnorderedGroup__Group__0 ) )
            // InternalXtext.g:410:3: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // InternalXtext.g:411:3: ( rule__UnorderedGroup__Group__0 )
            // InternalXtext.g:411:4: rule__UnorderedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // InternalXtext.g:420:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalXtext.g:421:1: ( ruleGroup EOF )
            // InternalXtext.g:422:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalXtext.g:429:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:433:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalXtext.g:434:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalXtext.g:434:2: ( ( rule__Group__Group__0 ) )
            // InternalXtext.g:435:3: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalXtext.g:436:3: ( rule__Group__Group__0 )
            // InternalXtext.g:436:4: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // InternalXtext.g:445:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // InternalXtext.g:446:1: ( ruleAbstractToken EOF )
            // InternalXtext.g:447:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // InternalXtext.g:454:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:458:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // InternalXtext.g:459:2: ( ( rule__AbstractToken__Alternatives ) )
            {
            // InternalXtext.g:459:2: ( ( rule__AbstractToken__Alternatives ) )
            // InternalXtext.g:460:3: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // InternalXtext.g:461:3: ( rule__AbstractToken__Alternatives )
            // InternalXtext.g:461:4: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractToken__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleSemanticPredicate"
    // InternalXtext.g:470:1: entryRuleSemanticPredicate : ruleSemanticPredicate EOF ;
    public final void entryRuleSemanticPredicate() throws RecognitionException {
        try {
            // InternalXtext.g:471:1: ( ruleSemanticPredicate EOF )
            // InternalXtext.g:472:1: ruleSemanticPredicate EOF
            {
             before(grammarAccess.getSemanticPredicateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSemanticPredicate();

            state._fsp--;

             after(grammarAccess.getSemanticPredicateRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSemanticPredicate"


    // $ANTLR start "ruleSemanticPredicate"
    // InternalXtext.g:479:1: ruleSemanticPredicate : ( ( rule__SemanticPredicate__Alternatives ) ) ;
    public final void ruleSemanticPredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:483:2: ( ( ( rule__SemanticPredicate__Alternatives ) ) )
            // InternalXtext.g:484:2: ( ( rule__SemanticPredicate__Alternatives ) )
            {
            // InternalXtext.g:484:2: ( ( rule__SemanticPredicate__Alternatives ) )
            // InternalXtext.g:485:3: ( rule__SemanticPredicate__Alternatives )
            {
             before(grammarAccess.getSemanticPredicateAccess().getAlternatives()); 
            // InternalXtext.g:486:3: ( rule__SemanticPredicate__Alternatives )
            // InternalXtext.g:486:4: rule__SemanticPredicate__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SemanticPredicate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSemanticPredicateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSemanticPredicate"


    // $ANTLR start "entryRuleGatedSemanticPredicate"
    // InternalXtext.g:495:1: entryRuleGatedSemanticPredicate : ruleGatedSemanticPredicate EOF ;
    public final void entryRuleGatedSemanticPredicate() throws RecognitionException {
        try {
            // InternalXtext.g:496:1: ( ruleGatedSemanticPredicate EOF )
            // InternalXtext.g:497:1: ruleGatedSemanticPredicate EOF
            {
             before(grammarAccess.getGatedSemanticPredicateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGatedSemanticPredicate();

            state._fsp--;

             after(grammarAccess.getGatedSemanticPredicateRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGatedSemanticPredicate"


    // $ANTLR start "ruleGatedSemanticPredicate"
    // InternalXtext.g:504:1: ruleGatedSemanticPredicate : ( ( rule__GatedSemanticPredicate__Group__0 ) ) ;
    public final void ruleGatedSemanticPredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:508:2: ( ( ( rule__GatedSemanticPredicate__Group__0 ) ) )
            // InternalXtext.g:509:2: ( ( rule__GatedSemanticPredicate__Group__0 ) )
            {
            // InternalXtext.g:509:2: ( ( rule__GatedSemanticPredicate__Group__0 ) )
            // InternalXtext.g:510:3: ( rule__GatedSemanticPredicate__Group__0 )
            {
             before(grammarAccess.getGatedSemanticPredicateAccess().getGroup()); 
            // InternalXtext.g:511:3: ( rule__GatedSemanticPredicate__Group__0 )
            // InternalXtext.g:511:4: rule__GatedSemanticPredicate__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GatedSemanticPredicate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGatedSemanticPredicateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGatedSemanticPredicate"


    // $ANTLR start "entryRuleDisambiguatingSemanticPredicate"
    // InternalXtext.g:520:1: entryRuleDisambiguatingSemanticPredicate : ruleDisambiguatingSemanticPredicate EOF ;
    public final void entryRuleDisambiguatingSemanticPredicate() throws RecognitionException {
        try {
            // InternalXtext.g:521:1: ( ruleDisambiguatingSemanticPredicate EOF )
            // InternalXtext.g:522:1: ruleDisambiguatingSemanticPredicate EOF
            {
             before(grammarAccess.getDisambiguatingSemanticPredicateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDisambiguatingSemanticPredicate();

            state._fsp--;

             after(grammarAccess.getDisambiguatingSemanticPredicateRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisambiguatingSemanticPredicate"


    // $ANTLR start "ruleDisambiguatingSemanticPredicate"
    // InternalXtext.g:529:1: ruleDisambiguatingSemanticPredicate : ( ( rule__DisambiguatingSemanticPredicate__Group__0 ) ) ;
    public final void ruleDisambiguatingSemanticPredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:533:2: ( ( ( rule__DisambiguatingSemanticPredicate__Group__0 ) ) )
            // InternalXtext.g:534:2: ( ( rule__DisambiguatingSemanticPredicate__Group__0 ) )
            {
            // InternalXtext.g:534:2: ( ( rule__DisambiguatingSemanticPredicate__Group__0 ) )
            // InternalXtext.g:535:3: ( rule__DisambiguatingSemanticPredicate__Group__0 )
            {
             before(grammarAccess.getDisambiguatingSemanticPredicateAccess().getGroup()); 
            // InternalXtext.g:536:3: ( rule__DisambiguatingSemanticPredicate__Group__0 )
            // InternalXtext.g:536:4: rule__DisambiguatingSemanticPredicate__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DisambiguatingSemanticPredicate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDisambiguatingSemanticPredicateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisambiguatingSemanticPredicate"


    // $ANTLR start "entryRuleJavaAction"
    // InternalXtext.g:545:1: entryRuleJavaAction : ruleJavaAction EOF ;
    public final void entryRuleJavaAction() throws RecognitionException {
        try {
            // InternalXtext.g:546:1: ( ruleJavaAction EOF )
            // InternalXtext.g:547:1: ruleJavaAction EOF
            {
             before(grammarAccess.getJavaActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleJavaAction();

            state._fsp--;

             after(grammarAccess.getJavaActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJavaAction"


    // $ANTLR start "ruleJavaAction"
    // InternalXtext.g:554:1: ruleJavaAction : ( ( rule__JavaAction__CodeAssignment ) ) ;
    public final void ruleJavaAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:558:2: ( ( ( rule__JavaAction__CodeAssignment ) ) )
            // InternalXtext.g:559:2: ( ( rule__JavaAction__CodeAssignment ) )
            {
            // InternalXtext.g:559:2: ( ( rule__JavaAction__CodeAssignment ) )
            // InternalXtext.g:560:3: ( rule__JavaAction__CodeAssignment )
            {
             before(grammarAccess.getJavaActionAccess().getCodeAssignment()); 
            // InternalXtext.g:561:3: ( rule__JavaAction__CodeAssignment )
            // InternalXtext.g:561:4: rule__JavaAction__CodeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__JavaAction__CodeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getJavaActionAccess().getCodeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJavaAction"


    // $ANTLR start "entryRuleJavaCode"
    // InternalXtext.g:570:1: entryRuleJavaCode : ruleJavaCode EOF ;
    public final void entryRuleJavaCode() throws RecognitionException {
        try {
            // InternalXtext.g:571:1: ( ruleJavaCode EOF )
            // InternalXtext.g:572:1: ruleJavaCode EOF
            {
             before(grammarAccess.getJavaCodeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleJavaCode();

            state._fsp--;

             after(grammarAccess.getJavaCodeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJavaCode"


    // $ANTLR start "ruleJavaCode"
    // InternalXtext.g:579:1: ruleJavaCode : ( ( rule__JavaCode__SourceAssignment ) ) ;
    public final void ruleJavaCode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:583:2: ( ( ( rule__JavaCode__SourceAssignment ) ) )
            // InternalXtext.g:584:2: ( ( rule__JavaCode__SourceAssignment ) )
            {
            // InternalXtext.g:584:2: ( ( rule__JavaCode__SourceAssignment ) )
            // InternalXtext.g:585:3: ( rule__JavaCode__SourceAssignment )
            {
             before(grammarAccess.getJavaCodeAccess().getSourceAssignment()); 
            // InternalXtext.g:586:3: ( rule__JavaCode__SourceAssignment )
            // InternalXtext.g:586:4: rule__JavaCode__SourceAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__JavaCode__SourceAssignment();

            state._fsp--;


            }

             after(grammarAccess.getJavaCodeAccess().getSourceAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJavaCode"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // InternalXtext.g:595:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // InternalXtext.g:596:1: ( ruleAbstractTokenWithCardinality EOF )
            // InternalXtext.g:597:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // InternalXtext.g:604:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:608:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // InternalXtext.g:609:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // InternalXtext.g:609:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // InternalXtext.g:610:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // InternalXtext.g:611:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            // InternalXtext.g:611:4: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // InternalXtext.g:620:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXtext.g:621:1: ( ruleAction EOF )
            // InternalXtext.g:622:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalXtext.g:629:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:633:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXtext.g:634:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalXtext.g:634:2: ( ( rule__Action__Group__0 ) )
            // InternalXtext.g:635:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXtext.g:636:3: ( rule__Action__Group__0 )
            // InternalXtext.g:636:4: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // InternalXtext.g:645:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:646:1: ( ruleAbstractTerminal EOF )
            // InternalXtext.g:647:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTerminal();

            state._fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // InternalXtext.g:654:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:658:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // InternalXtext.g:659:2: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // InternalXtext.g:659:2: ( ( rule__AbstractTerminal__Alternatives ) )
            // InternalXtext.g:660:3: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // InternalXtext.g:661:3: ( rule__AbstractTerminal__Alternatives )
            // InternalXtext.g:661:4: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTerminal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // InternalXtext.g:670:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalXtext.g:671:1: ( ruleKeyword EOF )
            // InternalXtext.g:672:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // InternalXtext.g:679:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:683:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // InternalXtext.g:684:2: ( ( rule__Keyword__ValueAssignment ) )
            {
            // InternalXtext.g:684:2: ( ( rule__Keyword__ValueAssignment ) )
            // InternalXtext.g:685:3: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // InternalXtext.g:686:3: ( rule__Keyword__ValueAssignment )
            // InternalXtext.g:686:4: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Keyword__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getKeywordAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // InternalXtext.g:695:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:696:1: ( ruleRuleCall EOF )
            // InternalXtext.g:697:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCall();

            state._fsp--;

             after(grammarAccess.getRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // InternalXtext.g:704:1: ruleRuleCall : ( ( rule__RuleCall__Group__0 ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:708:2: ( ( ( rule__RuleCall__Group__0 ) ) )
            // InternalXtext.g:709:2: ( ( rule__RuleCall__Group__0 ) )
            {
            // InternalXtext.g:709:2: ( ( rule__RuleCall__Group__0 ) )
            // InternalXtext.g:710:3: ( rule__RuleCall__Group__0 )
            {
             before(grammarAccess.getRuleCallAccess().getGroup()); 
            // InternalXtext.g:711:3: ( rule__RuleCall__Group__0 )
            // InternalXtext.g:711:4: rule__RuleCall__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleNamedArgument"
    // InternalXtext.g:720:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // InternalXtext.g:721:1: ( ruleNamedArgument EOF )
            // InternalXtext.g:722:1: ruleNamedArgument EOF
            {
             before(grammarAccess.getNamedArgumentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getNamedArgumentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // InternalXtext.g:729:1: ruleNamedArgument : ( ( rule__NamedArgument__Group__0 ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:733:2: ( ( ( rule__NamedArgument__Group__0 ) ) )
            // InternalXtext.g:734:2: ( ( rule__NamedArgument__Group__0 ) )
            {
            // InternalXtext.g:734:2: ( ( rule__NamedArgument__Group__0 ) )
            // InternalXtext.g:735:3: ( rule__NamedArgument__Group__0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup()); 
            // InternalXtext.g:736:3: ( rule__NamedArgument__Group__0 )
            // InternalXtext.g:736:4: rule__NamedArgument__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleLiteralCondition"
    // InternalXtext.g:745:1: entryRuleLiteralCondition : ruleLiteralCondition EOF ;
    public final void entryRuleLiteralCondition() throws RecognitionException {
        try {
            // InternalXtext.g:746:1: ( ruleLiteralCondition EOF )
            // InternalXtext.g:747:1: ruleLiteralCondition EOF
            {
             before(grammarAccess.getLiteralConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteralCondition();

            state._fsp--;

             after(grammarAccess.getLiteralConditionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralCondition"


    // $ANTLR start "ruleLiteralCondition"
    // InternalXtext.g:754:1: ruleLiteralCondition : ( ( rule__LiteralCondition__Group__0 ) ) ;
    public final void ruleLiteralCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:758:2: ( ( ( rule__LiteralCondition__Group__0 ) ) )
            // InternalXtext.g:759:2: ( ( rule__LiteralCondition__Group__0 ) )
            {
            // InternalXtext.g:759:2: ( ( rule__LiteralCondition__Group__0 ) )
            // InternalXtext.g:760:3: ( rule__LiteralCondition__Group__0 )
            {
             before(grammarAccess.getLiteralConditionAccess().getGroup()); 
            // InternalXtext.g:761:3: ( rule__LiteralCondition__Group__0 )
            // InternalXtext.g:761:4: rule__LiteralCondition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralCondition"


    // $ANTLR start "entryRuleDisjunction"
    // InternalXtext.g:770:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // InternalXtext.g:771:1: ( ruleDisjunction EOF )
            // InternalXtext.g:772:1: ruleDisjunction EOF
            {
             before(grammarAccess.getDisjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // InternalXtext.g:779:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:783:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // InternalXtext.g:784:2: ( ( rule__Disjunction__Group__0 ) )
            {
            // InternalXtext.g:784:2: ( ( rule__Disjunction__Group__0 ) )
            // InternalXtext.g:785:3: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // InternalXtext.g:786:3: ( rule__Disjunction__Group__0 )
            // InternalXtext.g:786:4: rule__Disjunction__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // InternalXtext.g:795:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // InternalXtext.g:796:1: ( ruleConjunction EOF )
            // InternalXtext.g:797:1: ruleConjunction EOF
            {
             before(grammarAccess.getConjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getConjunctionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // InternalXtext.g:804:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:808:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // InternalXtext.g:809:2: ( ( rule__Conjunction__Group__0 ) )
            {
            // InternalXtext.g:809:2: ( ( rule__Conjunction__Group__0 ) )
            // InternalXtext.g:810:3: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // InternalXtext.g:811:3: ( rule__Conjunction__Group__0 )
            // InternalXtext.g:811:4: rule__Conjunction__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // InternalXtext.g:820:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // InternalXtext.g:821:1: ( ruleNegation EOF )
            // InternalXtext.g:822:1: ruleNegation EOF
            {
             before(grammarAccess.getNegationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // InternalXtext.g:829:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:833:2: ( ( ( rule__Negation__Alternatives ) ) )
            // InternalXtext.g:834:2: ( ( rule__Negation__Alternatives ) )
            {
            // InternalXtext.g:834:2: ( ( rule__Negation__Alternatives ) )
            // InternalXtext.g:835:3: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // InternalXtext.g:836:3: ( rule__Negation__Alternatives )
            // InternalXtext.g:836:4: rule__Negation__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // InternalXtext.g:845:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalXtext.g:846:1: ( ruleAtom EOF )
            // InternalXtext.g:847:1: ruleAtom EOF
            {
             before(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAtom();

            state._fsp--;

             after(grammarAccess.getAtomRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalXtext.g:854:1: ruleAtom : ( ( rule__Atom__Alternatives ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:858:2: ( ( ( rule__Atom__Alternatives ) ) )
            // InternalXtext.g:859:2: ( ( rule__Atom__Alternatives ) )
            {
            // InternalXtext.g:859:2: ( ( rule__Atom__Alternatives ) )
            // InternalXtext.g:860:3: ( rule__Atom__Alternatives )
            {
             before(grammarAccess.getAtomAccess().getAlternatives()); 
            // InternalXtext.g:861:3: ( rule__Atom__Alternatives )
            // InternalXtext.g:861:4: rule__Atom__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Atom__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParenthesizedCondition"
    // InternalXtext.g:870:1: entryRuleParenthesizedCondition : ruleParenthesizedCondition EOF ;
    public final void entryRuleParenthesizedCondition() throws RecognitionException {
        try {
            // InternalXtext.g:871:1: ( ruleParenthesizedCondition EOF )
            // InternalXtext.g:872:1: ruleParenthesizedCondition EOF
            {
             before(grammarAccess.getParenthesizedConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedCondition();

            state._fsp--;

             after(grammarAccess.getParenthesizedConditionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedCondition"


    // $ANTLR start "ruleParenthesizedCondition"
    // InternalXtext.g:879:1: ruleParenthesizedCondition : ( ( rule__ParenthesizedCondition__Group__0 ) ) ;
    public final void ruleParenthesizedCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:883:2: ( ( ( rule__ParenthesizedCondition__Group__0 ) ) )
            // InternalXtext.g:884:2: ( ( rule__ParenthesizedCondition__Group__0 ) )
            {
            // InternalXtext.g:884:2: ( ( rule__ParenthesizedCondition__Group__0 ) )
            // InternalXtext.g:885:3: ( rule__ParenthesizedCondition__Group__0 )
            {
             before(grammarAccess.getParenthesizedConditionAccess().getGroup()); 
            // InternalXtext.g:886:3: ( rule__ParenthesizedCondition__Group__0 )
            // InternalXtext.g:886:4: rule__ParenthesizedCondition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedCondition"


    // $ANTLR start "entryRuleParameterReference"
    // InternalXtext.g:895:1: entryRuleParameterReference : ruleParameterReference EOF ;
    public final void entryRuleParameterReference() throws RecognitionException {
        try {
            // InternalXtext.g:896:1: ( ruleParameterReference EOF )
            // InternalXtext.g:897:1: ruleParameterReference EOF
            {
             before(grammarAccess.getParameterReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameterReference();

            state._fsp--;

             after(grammarAccess.getParameterReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterReference"


    // $ANTLR start "ruleParameterReference"
    // InternalXtext.g:904:1: ruleParameterReference : ( ( rule__ParameterReference__ParameterAssignment ) ) ;
    public final void ruleParameterReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:908:2: ( ( ( rule__ParameterReference__ParameterAssignment ) ) )
            // InternalXtext.g:909:2: ( ( rule__ParameterReference__ParameterAssignment ) )
            {
            // InternalXtext.g:909:2: ( ( rule__ParameterReference__ParameterAssignment ) )
            // InternalXtext.g:910:3: ( rule__ParameterReference__ParameterAssignment )
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); 
            // InternalXtext.g:911:3: ( rule__ParameterReference__ParameterAssignment )
            // InternalXtext.g:911:4: rule__ParameterReference__ParameterAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParameterReference__ParameterAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterReference"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // InternalXtext.g:920:1: entryRuleTerminalRuleCall : ruleTerminalRuleCall EOF ;
    public final void entryRuleTerminalRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:921:1: ( ruleTerminalRuleCall EOF )
            // InternalXtext.g:922:1: ruleTerminalRuleCall EOF
            {
             before(grammarAccess.getTerminalRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRuleCall();

            state._fsp--;

             after(grammarAccess.getTerminalRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // InternalXtext.g:929:1: ruleTerminalRuleCall : ( ( rule__TerminalRuleCall__RuleAssignment ) ) ;
    public final void ruleTerminalRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:933:2: ( ( ( rule__TerminalRuleCall__RuleAssignment ) ) )
            // InternalXtext.g:934:2: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            {
            // InternalXtext.g:934:2: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            // InternalXtext.g:935:3: ( rule__TerminalRuleCall__RuleAssignment )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 
            // InternalXtext.g:936:3: ( rule__TerminalRuleCall__RuleAssignment )
            // InternalXtext.g:936:4: rule__TerminalRuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRuleCall__RuleAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // InternalXtext.g:945:1: entryRuleRuleID : ruleRuleID EOF ;
    public final void entryRuleRuleID() throws RecognitionException {
        try {
            // InternalXtext.g:946:1: ( ruleRuleID EOF )
            // InternalXtext.g:947:1: ruleRuleID EOF
            {
             before(grammarAccess.getRuleIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getRuleIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // InternalXtext.g:954:1: ruleRuleID : ( ( rule__RuleID__Group__0 ) ) ;
    public final void ruleRuleID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:958:2: ( ( ( rule__RuleID__Group__0 ) ) )
            // InternalXtext.g:959:2: ( ( rule__RuleID__Group__0 ) )
            {
            // InternalXtext.g:959:2: ( ( rule__RuleID__Group__0 ) )
            // InternalXtext.g:960:3: ( rule__RuleID__Group__0 )
            {
             before(grammarAccess.getRuleIDAccess().getGroup()); 
            // InternalXtext.g:961:3: ( rule__RuleID__Group__0 )
            // InternalXtext.g:961:4: rule__RuleID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRuleValidID"
    // InternalXtext.g:970:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // InternalXtext.g:971:1: ( ruleValidID EOF )
            // InternalXtext.g:972:1: ruleValidID EOF
            {
             before(grammarAccess.getValidIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getValidIDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalXtext.g:979:1: ruleValidID : ( ( rule__ValidID__Alternatives ) ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:983:2: ( ( ( rule__ValidID__Alternatives ) ) )
            // InternalXtext.g:984:2: ( ( rule__ValidID__Alternatives ) )
            {
            // InternalXtext.g:984:2: ( ( rule__ValidID__Alternatives ) )
            // InternalXtext.g:985:3: ( rule__ValidID__Alternatives )
            {
             before(grammarAccess.getValidIDAccess().getAlternatives()); 
            // InternalXtext.g:986:3: ( rule__ValidID__Alternatives )
            // InternalXtext.g:986:4: rule__ValidID__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ValidID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValidIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // InternalXtext.g:995:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // InternalXtext.g:996:1: ( rulePredicatedKeyword EOF )
            // InternalXtext.g:997:1: rulePredicatedKeyword EOF
            {
             before(grammarAccess.getPredicatedKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedKeyword();

            state._fsp--;

             after(grammarAccess.getPredicatedKeywordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // InternalXtext.g:1004:1: rulePredicatedKeyword : ( ( rule__PredicatedKeyword__Group__0 ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1008:2: ( ( ( rule__PredicatedKeyword__Group__0 ) ) )
            // InternalXtext.g:1009:2: ( ( rule__PredicatedKeyword__Group__0 ) )
            {
            // InternalXtext.g:1009:2: ( ( rule__PredicatedKeyword__Group__0 ) )
            // InternalXtext.g:1010:3: ( rule__PredicatedKeyword__Group__0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getGroup()); 
            // InternalXtext.g:1011:3: ( rule__PredicatedKeyword__Group__0 )
            // InternalXtext.g:1011:4: rule__PredicatedKeyword__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // InternalXtext.g:1020:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // InternalXtext.g:1021:1: ( rulePredicatedRuleCall EOF )
            // InternalXtext.g:1022:1: rulePredicatedRuleCall EOF
            {
             before(grammarAccess.getPredicatedRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedRuleCall();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // InternalXtext.g:1029:1: rulePredicatedRuleCall : ( ( rule__PredicatedRuleCall__Group__0 ) ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1033:2: ( ( ( rule__PredicatedRuleCall__Group__0 ) ) )
            // InternalXtext.g:1034:2: ( ( rule__PredicatedRuleCall__Group__0 ) )
            {
            // InternalXtext.g:1034:2: ( ( rule__PredicatedRuleCall__Group__0 ) )
            // InternalXtext.g:1035:3: ( rule__PredicatedRuleCall__Group__0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 
            // InternalXtext.g:1036:3: ( rule__PredicatedRuleCall__Group__0 )
            // InternalXtext.g:1036:4: rule__PredicatedRuleCall__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // InternalXtext.g:1045:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalXtext.g:1046:1: ( ruleAssignment EOF )
            // InternalXtext.g:1047:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalXtext.g:1054:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1058:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalXtext.g:1059:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalXtext.g:1059:2: ( ( rule__Assignment__Group__0 ) )
            // InternalXtext.g:1060:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalXtext.g:1061:3: ( rule__Assignment__Group__0 )
            // InternalXtext.g:1061:4: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignableTerminal"
    // InternalXtext.g:1070:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:1071:1: ( ruleAssignableTerminal EOF )
            // InternalXtext.g:1072:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // InternalXtext.g:1079:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1083:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // InternalXtext.g:1084:2: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // InternalXtext.g:1084:2: ( ( rule__AssignableTerminal__Alternatives ) )
            // InternalXtext.g:1085:3: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // InternalXtext.g:1086:3: ( rule__AssignableTerminal__Alternatives )
            // InternalXtext.g:1086:4: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableTerminal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // InternalXtext.g:1095:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // InternalXtext.g:1096:1: ( ruleParenthesizedAssignableElement EOF )
            // InternalXtext.g:1097:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedAssignableElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // InternalXtext.g:1104:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1108:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // InternalXtext.g:1109:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // InternalXtext.g:1109:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // InternalXtext.g:1110:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // InternalXtext.g:1111:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            // InternalXtext.g:1111:4: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // InternalXtext.g:1120:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:1121:1: ( ruleAssignableAlternatives EOF )
            // InternalXtext.g:1122:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableAlternatives();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // InternalXtext.g:1129:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1133:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // InternalXtext.g:1134:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // InternalXtext.g:1134:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            // InternalXtext.g:1135:3: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // InternalXtext.g:1136:3: ( rule__AssignableAlternatives__Group__0 )
            // InternalXtext.g:1136:4: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // InternalXtext.g:1145:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // InternalXtext.g:1146:1: ( ruleCrossReference EOF )
            // InternalXtext.g:1147:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReference();

            state._fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // InternalXtext.g:1154:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1158:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // InternalXtext.g:1159:2: ( ( rule__CrossReference__Group__0 ) )
            {
            // InternalXtext.g:1159:2: ( ( rule__CrossReference__Group__0 ) )
            // InternalXtext.g:1160:3: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // InternalXtext.g:1161:3: ( rule__CrossReference__Group__0 )
            // InternalXtext.g:1161:4: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // InternalXtext.g:1170:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // InternalXtext.g:1171:1: ( ruleCrossReferenceableTerminal EOF )
            // InternalXtext.g:1172:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // InternalXtext.g:1179:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1183:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // InternalXtext.g:1184:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // InternalXtext.g:1184:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // InternalXtext.g:1185:3: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // InternalXtext.g:1186:3: ( rule__CrossReferenceableTerminal__Alternatives )
            // InternalXtext.g:1186:4: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReferenceableTerminal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // InternalXtext.g:1195:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // InternalXtext.g:1196:1: ( ruleParenthesizedElement EOF )
            // InternalXtext.g:1197:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // InternalXtext.g:1204:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1208:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // InternalXtext.g:1209:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // InternalXtext.g:1209:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            // InternalXtext.g:1210:3: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // InternalXtext.g:1211:3: ( rule__ParenthesizedElement__Group__0 )
            // InternalXtext.g:1211:4: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRulePredicatedGroup"
    // InternalXtext.g:1220:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // InternalXtext.g:1221:1: ( rulePredicatedGroup EOF )
            // InternalXtext.g:1222:1: rulePredicatedGroup EOF
            {
             before(grammarAccess.getPredicatedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedGroup();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // InternalXtext.g:1229:1: rulePredicatedGroup : ( ( rule__PredicatedGroup__Group__0 ) ) ;
    public final void rulePredicatedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1233:2: ( ( ( rule__PredicatedGroup__Group__0 ) ) )
            // InternalXtext.g:1234:2: ( ( rule__PredicatedGroup__Group__0 ) )
            {
            // InternalXtext.g:1234:2: ( ( rule__PredicatedGroup__Group__0 ) )
            // InternalXtext.g:1235:3: ( rule__PredicatedGroup__Group__0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getGroup()); 
            // InternalXtext.g:1236:3: ( rule__PredicatedGroup__Group__0 )
            // InternalXtext.g:1236:4: rule__PredicatedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // InternalXtext.g:1245:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // InternalXtext.g:1246:1: ( ruleTerminalRule EOF )
            // InternalXtext.g:1247:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRule();

            state._fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // InternalXtext.g:1254:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1258:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // InternalXtext.g:1259:2: ( ( rule__TerminalRule__Group__0 ) )
            {
            // InternalXtext.g:1259:2: ( ( rule__TerminalRule__Group__0 ) )
            // InternalXtext.g:1260:3: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // InternalXtext.g:1261:3: ( rule__TerminalRule__Group__0 )
            // InternalXtext.g:1261:4: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // InternalXtext.g:1270:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // InternalXtext.g:1271:1: ( ruleTerminalAlternatives EOF )
            // InternalXtext.g:1272:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // InternalXtext.g:1279:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1283:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // InternalXtext.g:1284:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // InternalXtext.g:1284:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            // InternalXtext.g:1285:3: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // InternalXtext.g:1286:3: ( rule__TerminalAlternatives__Group__0 )
            // InternalXtext.g:1286:4: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // InternalXtext.g:1295:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // InternalXtext.g:1296:1: ( ruleTerminalGroup EOF )
            // InternalXtext.g:1297:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // InternalXtext.g:1304:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1308:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // InternalXtext.g:1309:2: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // InternalXtext.g:1309:2: ( ( rule__TerminalGroup__Group__0 ) )
            // InternalXtext.g:1310:3: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // InternalXtext.g:1311:3: ( rule__TerminalGroup__Group__0 )
            // InternalXtext.g:1311:4: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // InternalXtext.g:1320:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // InternalXtext.g:1321:1: ( ruleTerminalToken EOF )
            // InternalXtext.g:1322:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // InternalXtext.g:1329:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1333:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // InternalXtext.g:1334:2: ( ( rule__TerminalToken__Group__0 ) )
            {
            // InternalXtext.g:1334:2: ( ( rule__TerminalToken__Group__0 ) )
            // InternalXtext.g:1335:3: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // InternalXtext.g:1336:3: ( rule__TerminalToken__Group__0 )
            // InternalXtext.g:1336:4: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // InternalXtext.g:1345:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // InternalXtext.g:1346:1: ( ruleTerminalTokenElement EOF )
            // InternalXtext.g:1347:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // InternalXtext.g:1354:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1358:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // InternalXtext.g:1359:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // InternalXtext.g:1359:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            // InternalXtext.g:1360:3: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // InternalXtext.g:1361:3: ( rule__TerminalTokenElement__Alternatives )
            // InternalXtext.g:1361:4: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalTokenElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // InternalXtext.g:1370:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // InternalXtext.g:1371:1: ( ruleParenthesizedTerminalElement EOF )
            // InternalXtext.g:1372:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedTerminalElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // InternalXtext.g:1379:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1383:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // InternalXtext.g:1384:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // InternalXtext.g:1384:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // InternalXtext.g:1385:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // InternalXtext.g:1386:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            // InternalXtext.g:1386:4: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // InternalXtext.g:1395:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // InternalXtext.g:1396:1: ( ruleAbstractNegatedToken EOF )
            // InternalXtext.g:1397:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractNegatedToken();

            state._fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // InternalXtext.g:1404:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1408:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // InternalXtext.g:1409:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // InternalXtext.g:1409:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // InternalXtext.g:1410:3: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // InternalXtext.g:1411:3: ( rule__AbstractNegatedToken__Alternatives )
            // InternalXtext.g:1411:4: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractNegatedToken__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // InternalXtext.g:1420:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // InternalXtext.g:1421:1: ( ruleNegatedToken EOF )
            // InternalXtext.g:1422:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNegatedToken();

            state._fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // InternalXtext.g:1429:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1433:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // InternalXtext.g:1434:2: ( ( rule__NegatedToken__Group__0 ) )
            {
            // InternalXtext.g:1434:2: ( ( rule__NegatedToken__Group__0 ) )
            // InternalXtext.g:1435:3: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // InternalXtext.g:1436:3: ( rule__NegatedToken__Group__0 )
            // InternalXtext.g:1436:4: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegatedTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // InternalXtext.g:1445:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // InternalXtext.g:1446:1: ( ruleUntilToken EOF )
            // InternalXtext.g:1447:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUntilToken();

            state._fsp--;

             after(grammarAccess.getUntilTokenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // InternalXtext.g:1454:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1458:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // InternalXtext.g:1459:2: ( ( rule__UntilToken__Group__0 ) )
            {
            // InternalXtext.g:1459:2: ( ( rule__UntilToken__Group__0 ) )
            // InternalXtext.g:1460:3: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // InternalXtext.g:1461:3: ( rule__UntilToken__Group__0 )
            // InternalXtext.g:1461:4: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUntilTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // InternalXtext.g:1470:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalXtext.g:1471:1: ( ruleWildcard EOF )
            // InternalXtext.g:1472:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWildcard();

            state._fsp--;

             after(grammarAccess.getWildcardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // InternalXtext.g:1479:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1483:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalXtext.g:1484:2: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalXtext.g:1484:2: ( ( rule__Wildcard__Group__0 ) )
            // InternalXtext.g:1485:3: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // InternalXtext.g:1486:3: ( rule__Wildcard__Group__0 )
            // InternalXtext.g:1486:4: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Wildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleEOF"
    // InternalXtext.g:1495:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // InternalXtext.g:1496:1: ( ruleEOF EOF )
            // InternalXtext.g:1497:1: ruleEOF EOF
            {
             before(grammarAccess.getEOFRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEOF();

            state._fsp--;

             after(grammarAccess.getEOFRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // InternalXtext.g:1504:1: ruleEOF : ( ( rule__EOF__Group__0 ) ) ;
    public final void ruleEOF() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1508:2: ( ( ( rule__EOF__Group__0 ) ) )
            // InternalXtext.g:1509:2: ( ( rule__EOF__Group__0 ) )
            {
            // InternalXtext.g:1509:2: ( ( rule__EOF__Group__0 ) )
            // InternalXtext.g:1510:3: ( rule__EOF__Group__0 )
            {
             before(grammarAccess.getEOFAccess().getGroup()); 
            // InternalXtext.g:1511:3: ( rule__EOF__Group__0 )
            // InternalXtext.g:1511:4: rule__EOF__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEOFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // InternalXtext.g:1520:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // InternalXtext.g:1521:1: ( ruleCharacterRange EOF )
            // InternalXtext.g:1522:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCharacterRange();

            state._fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // InternalXtext.g:1529:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1533:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // InternalXtext.g:1534:2: ( ( rule__CharacterRange__Group__0 ) )
            {
            // InternalXtext.g:1534:2: ( ( rule__CharacterRange__Group__0 ) )
            // InternalXtext.g:1535:3: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // InternalXtext.g:1536:3: ( rule__CharacterRange__Group__0 )
            // InternalXtext.g:1536:4: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCharacterRangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // InternalXtext.g:1545:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // InternalXtext.g:1546:1: ( ruleEnumRule EOF )
            // InternalXtext.g:1547:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumRule();

            state._fsp--;

             after(grammarAccess.getEnumRuleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // InternalXtext.g:1554:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1558:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // InternalXtext.g:1559:2: ( ( rule__EnumRule__Group__0 ) )
            {
            // InternalXtext.g:1559:2: ( ( rule__EnumRule__Group__0 ) )
            // InternalXtext.g:1560:3: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // InternalXtext.g:1561:3: ( rule__EnumRule__Group__0 )
            // InternalXtext.g:1561:4: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // InternalXtext.g:1570:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // InternalXtext.g:1571:1: ( ruleEnumLiterals EOF )
            // InternalXtext.g:1572:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // InternalXtext.g:1579:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1583:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // InternalXtext.g:1584:2: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // InternalXtext.g:1584:2: ( ( rule__EnumLiterals__Group__0 ) )
            // InternalXtext.g:1585:3: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // InternalXtext.g:1586:3: ( rule__EnumLiterals__Group__0 )
            // InternalXtext.g:1586:4: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // InternalXtext.g:1595:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // InternalXtext.g:1596:1: ( ruleEnumLiteralDeclaration EOF )
            // InternalXtext.g:1597:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // InternalXtext.g:1604:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1608:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // InternalXtext.g:1609:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // InternalXtext.g:1609:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // InternalXtext.g:1610:3: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // InternalXtext.g:1611:3: ( rule__EnumLiteralDeclaration__Group__0 )
            // InternalXtext.g:1611:4: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumLiteralDeclaration"


    // $ANTLR start "rule__AbstractRule__Alternatives"
    // InternalXtext.g:1619:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1623:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalXtext.g:1624:2: ( ruleParserRule )
                    {
                    // InternalXtext.g:1624:2: ( ruleParserRule )
                    // InternalXtext.g:1625:3: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParserRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1630:2: ( ruleTerminalRule )
                    {
                    // InternalXtext.g:1630:2: ( ruleTerminalRule )
                    // InternalXtext.g:1631:3: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1636:2: ( ruleEnumRule )
                    {
                    // InternalXtext.g:1636:2: ( ruleEnumRule )
                    // InternalXtext.g:1637:3: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEnumRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractRule__Alternatives"


    // $ANTLR start "rule__AbstractMetamodelDeclaration__Alternatives"
    // InternalXtext.g:1646:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1650:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==28) ) {
                alt2=1;
            }
            else if ( (LA2_0==30) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtext.g:1651:2: ( ruleGeneratedMetamodel )
                    {
                    // InternalXtext.g:1651:2: ( ruleGeneratedMetamodel )
                    // InternalXtext.g:1652:3: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGeneratedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1657:2: ( ruleReferencedMetamodel )
                    {
                    // InternalXtext.g:1657:2: ( ruleReferencedMetamodel )
                    // InternalXtext.g:1658:3: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReferencedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractMetamodelDeclaration__Alternatives"


    // $ANTLR start "rule__ParserRule__Alternatives_1"
    // InternalXtext.g:1667:1: rule__ParserRule__Alternatives_1 : ( ( ( rule__ParserRule__Group_1_0__0 ) ) | ( ( rule__ParserRule__Group_1_1__0 ) ) );
    public final void rule__ParserRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1671:1: ( ( ( rule__ParserRule__Group_1_0__0 ) ) | ( ( rule__ParserRule__Group_1_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==54) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID||(LA3_0>=17 && LA3_0<=18)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtext.g:1672:2: ( ( rule__ParserRule__Group_1_0__0 ) )
                    {
                    // InternalXtext.g:1672:2: ( ( rule__ParserRule__Group_1_0__0 ) )
                    // InternalXtext.g:1673:3: ( rule__ParserRule__Group_1_0__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_1_0()); 
                    // InternalXtext.g:1674:3: ( rule__ParserRule__Group_1_0__0 )
                    // InternalXtext.g:1674:4: rule__ParserRule__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1678:2: ( ( rule__ParserRule__Group_1_1__0 ) )
                    {
                    // InternalXtext.g:1678:2: ( ( rule__ParserRule__Group_1_1__0 ) )
                    // InternalXtext.g:1679:3: ( rule__ParserRule__Group_1_1__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_1_1()); 
                    // InternalXtext.g:1680:3: ( rule__ParserRule__Group_1_1__0 )
                    // InternalXtext.g:1680:4: rule__ParserRule__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Alternatives_1"


    // $ANTLR start "rule__ParserRule__Alternatives_1_0_2"
    // InternalXtext.g:1688:1: rule__ParserRule__Alternatives_1_0_2 : ( ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) ) | ( ( rule__ParserRule__Group_1_0_2_1__0 )? ) );
    public final void rule__ParserRule__Alternatives_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1692:1: ( ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) ) | ( ( rule__ParserRule__Group_1_0_2_1__0 )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==32||LA5_0==34||LA5_0==52) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtext.g:1693:2: ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) )
                    {
                    // InternalXtext.g:1693:2: ( ( rule__ParserRule__WildcardAssignment_1_0_2_0 ) )
                    // InternalXtext.g:1694:3: ( rule__ParserRule__WildcardAssignment_1_0_2_0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0()); 
                    // InternalXtext.g:1695:3: ( rule__ParserRule__WildcardAssignment_1_0_2_0 )
                    // InternalXtext.g:1695:4: rule__ParserRule__WildcardAssignment_1_0_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__WildcardAssignment_1_0_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1699:2: ( ( rule__ParserRule__Group_1_0_2_1__0 )? )
                    {
                    // InternalXtext.g:1699:2: ( ( rule__ParserRule__Group_1_0_2_1__0 )? )
                    // InternalXtext.g:1700:3: ( rule__ParserRule__Group_1_0_2_1__0 )?
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1()); 
                    // InternalXtext.g:1701:3: ( rule__ParserRule__Group_1_0_2_1__0 )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==34) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalXtext.g:1701:4: rule__ParserRule__Group_1_0_2_1__0
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            rule__ParserRule__Group_1_0_2_1__0();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Alternatives_1_0_2"


    // $ANTLR start "rule__ConditionalBranch__Alternatives"
    // InternalXtext.g:1709:1: rule__ConditionalBranch__Alternatives : ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) );
    public final void rule__ConditionalBranch__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1713:1: ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||(LA6_0>=RULE_STRING && LA6_0<=RULE_JAVACODESTRING)||(LA6_0>=17 && LA6_0<=18)||LA6_0==23||LA6_0==41||LA6_0==48||LA6_0==55) ) {
                alt6=1;
            }
            else if ( (LA6_0==35) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtext.g:1714:2: ( ruleUnorderedGroup )
                    {
                    // InternalXtext.g:1714:2: ( ruleUnorderedGroup )
                    // InternalXtext.g:1715:3: ruleUnorderedGroup
                    {
                     before(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnorderedGroup();

                    state._fsp--;

                     after(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1720:2: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    {
                    // InternalXtext.g:1720:2: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    // InternalXtext.g:1721:3: ( rule__ConditionalBranch__Group_1__0 )
                    {
                     before(grammarAccess.getConditionalBranchAccess().getGroup_1()); 
                    // InternalXtext.g:1722:3: ( rule__ConditionalBranch__Group_1__0 )
                    // InternalXtext.g:1722:4: rule__ConditionalBranch__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConditionalBranch__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConditionalBranchAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Alternatives"


    // $ANTLR start "rule__AbstractToken__Alternatives"
    // InternalXtext.g:1730:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) | ( ruleJavaAction ) | ( ruleSemanticPredicate ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1734:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) | ( ruleJavaAction ) | ( ruleSemanticPredicate ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
            case 17:
            case 18:
            case 23:
            case 48:
            case 55:
                {
                alt7=1;
                }
                break;
            case 41:
                {
                alt7=2;
                }
                break;
            case RULE_JAVACODESTRING:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==12||LA7_3==40) ) {
                    alt7=4;
                }
                else if ( (LA7_3==EOF||LA7_3==RULE_ID||(LA7_3>=RULE_STRING && LA7_3<=RULE_JAVACODESTRING)||(LA7_3>=17 && LA7_3<=18)||(LA7_3>=23 && LA7_3<=24)||LA7_3==33||(LA7_3>=38 && LA7_3<=39)||LA7_3==41||LA7_3==48||LA7_3==55) ) {
                    alt7=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalXtext.g:1735:2: ( ruleAbstractTokenWithCardinality )
                    {
                    // InternalXtext.g:1735:2: ( ruleAbstractTokenWithCardinality )
                    // InternalXtext.g:1736:3: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1741:2: ( ruleAction )
                    {
                    // InternalXtext.g:1741:2: ( ruleAction )
                    // InternalXtext.g:1742:3: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAction();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1747:2: ( ruleJavaAction )
                    {
                    // InternalXtext.g:1747:2: ( ruleJavaAction )
                    // InternalXtext.g:1748:3: ruleJavaAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getJavaActionParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleJavaAction();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getJavaActionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:1753:2: ( ruleSemanticPredicate )
                    {
                    // InternalXtext.g:1753:2: ( ruleSemanticPredicate )
                    // InternalXtext.g:1754:3: ruleSemanticPredicate
                    {
                     before(grammarAccess.getAbstractTokenAccess().getSemanticPredicateParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSemanticPredicate();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getSemanticPredicateParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractToken__Alternatives"


    // $ANTLR start "rule__SemanticPredicate__Alternatives"
    // InternalXtext.g:1763:1: rule__SemanticPredicate__Alternatives : ( ( ruleDisambiguatingSemanticPredicate ) | ( ruleGatedSemanticPredicate ) );
    public final void rule__SemanticPredicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1767:1: ( ( ruleDisambiguatingSemanticPredicate ) | ( ruleGatedSemanticPredicate ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_JAVACODESTRING) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==40) ) {
                    alt8=2;
                }
                else if ( (LA8_1==12) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalXtext.g:1768:2: ( ruleDisambiguatingSemanticPredicate )
                    {
                    // InternalXtext.g:1768:2: ( ruleDisambiguatingSemanticPredicate )
                    // InternalXtext.g:1769:3: ruleDisambiguatingSemanticPredicate
                    {
                     before(grammarAccess.getSemanticPredicateAccess().getDisambiguatingSemanticPredicateParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDisambiguatingSemanticPredicate();

                    state._fsp--;

                     after(grammarAccess.getSemanticPredicateAccess().getDisambiguatingSemanticPredicateParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1774:2: ( ruleGatedSemanticPredicate )
                    {
                    // InternalXtext.g:1774:2: ( ruleGatedSemanticPredicate )
                    // InternalXtext.g:1775:3: ruleGatedSemanticPredicate
                    {
                     before(grammarAccess.getSemanticPredicateAccess().getGatedSemanticPredicateParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGatedSemanticPredicate();

                    state._fsp--;

                     after(grammarAccess.getSemanticPredicateAccess().getGatedSemanticPredicateParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SemanticPredicate__Alternatives"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Alternatives_0"
    // InternalXtext.g:1784:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1788:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalXtext.g:1789:2: ( ruleAssignment )
                    {
                    // InternalXtext.g:1789:2: ( ruleAssignment )
                    // InternalXtext.g:1790:3: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1795:2: ( ruleAbstractTerminal )
                    {
                    // InternalXtext.g:1795:2: ( ruleAbstractTerminal )
                    // InternalXtext.g:1796:3: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractTerminal();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Alternatives_0"


    // $ANTLR start "rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0"
    // InternalXtext.g:1805:1: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1809:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt10=1;
                }
                break;
            case 13:
                {
                alt10=2;
                }
                break;
            case 14:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalXtext.g:1810:2: ( '?' )
                    {
                    // InternalXtext.g:1810:2: ( '?' )
                    // InternalXtext.g:1811:3: '?'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1816:2: ( '*' )
                    {
                    // InternalXtext.g:1816:2: ( '*' )
                    // InternalXtext.g:1817:3: '*'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1822:2: ( '+' )
                    {
                    // InternalXtext.g:1822:2: ( '+' )
                    // InternalXtext.g:1823:3: '+'
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0"


    // $ANTLR start "rule__Action__OperatorAlternatives_2_2_0"
    // InternalXtext.g:1832:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1836:1: ( ( '=' ) | ( '+=' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            else if ( (LA11_0==16) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtext.g:1837:2: ( '=' )
                    {
                    // InternalXtext.g:1837:2: ( '=' )
                    // InternalXtext.g:1838:3: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1843:2: ( '+=' )
                    {
                    // InternalXtext.g:1843:2: ( '+=' )
                    // InternalXtext.g:1844:3: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,16,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__OperatorAlternatives_2_2_0"


    // $ANTLR start "rule__AbstractTerminal__Alternatives"
    // InternalXtext.g:1853:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1857:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt12=1;
                }
                break;
            case RULE_ID:
            case 17:
            case 18:
                {
                alt12=2;
                }
                break;
            case 23:
                {
                alt12=3;
                }
                break;
            case 55:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt12=4;
                    }
                    break;
                case 23:
                    {
                    alt12=6;
                    }
                    break;
                case RULE_ID:
                case 17:
                case 18:
                    {
                    alt12=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    throw nvae;
                }

                }
                break;
            case 48:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt12=4;
                    }
                    break;
                case 23:
                    {
                    alt12=6;
                    }
                    break;
                case RULE_ID:
                case 17:
                case 18:
                    {
                    alt12=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalXtext.g:1858:2: ( ruleKeyword )
                    {
                    // InternalXtext.g:1858:2: ( ruleKeyword )
                    // InternalXtext.g:1859:3: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1864:2: ( ruleRuleCall )
                    {
                    // InternalXtext.g:1864:2: ( ruleRuleCall )
                    // InternalXtext.g:1865:3: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1870:2: ( ruleParenthesizedElement )
                    {
                    // InternalXtext.g:1870:2: ( ruleParenthesizedElement )
                    // InternalXtext.g:1871:3: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedElement();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:1876:2: ( rulePredicatedKeyword )
                    {
                    // InternalXtext.g:1876:2: ( rulePredicatedKeyword )
                    // InternalXtext.g:1877:3: rulePredicatedKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtext.g:1882:2: ( rulePredicatedRuleCall )
                    {
                    // InternalXtext.g:1882:2: ( rulePredicatedRuleCall )
                    // InternalXtext.g:1883:3: rulePredicatedRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtext.g:1888:2: ( rulePredicatedGroup )
                    {
                    // InternalXtext.g:1888:2: ( rulePredicatedGroup )
                    // InternalXtext.g:1889:3: rulePredicatedGroup
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedGroup();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTerminal__Alternatives"


    // $ANTLR start "rule__LiteralCondition__Alternatives_1"
    // InternalXtext.g:1898:1: rule__LiteralCondition__Alternatives_1 : ( ( ( rule__LiteralCondition__TrueAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__LiteralCondition__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1902:1: ( ( ( rule__LiteralCondition__TrueAssignment_1_0 ) ) | ( 'false' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            else if ( (LA13_0==17) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtext.g:1903:2: ( ( rule__LiteralCondition__TrueAssignment_1_0 ) )
                    {
                    // InternalXtext.g:1903:2: ( ( rule__LiteralCondition__TrueAssignment_1_0 ) )
                    // InternalXtext.g:1904:3: ( rule__LiteralCondition__TrueAssignment_1_0 )
                    {
                     before(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); 
                    // InternalXtext.g:1905:3: ( rule__LiteralCondition__TrueAssignment_1_0 )
                    // InternalXtext.g:1905:4: rule__LiteralCondition__TrueAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__LiteralCondition__TrueAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1909:2: ( 'false' )
                    {
                    // InternalXtext.g:1909:2: ( 'false' )
                    // InternalXtext.g:1910:3: 'false'
                    {
                     before(grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1()); 
                    match(input,17,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Alternatives_1"


    // $ANTLR start "rule__Negation__Alternatives"
    // InternalXtext.g:1919:1: rule__Negation__Alternatives : ( ( ruleAtom ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1923:1: ( ( ruleAtom ) | ( ( rule__Negation__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||(LA14_0>=17 && LA14_0<=18)||LA14_0==23) ) {
                alt14=1;
            }
            else if ( (LA14_0==44) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalXtext.g:1924:2: ( ruleAtom )
                    {
                    // InternalXtext.g:1924:2: ( ruleAtom )
                    // InternalXtext.g:1925:3: ruleAtom
                    {
                     before(grammarAccess.getNegationAccess().getAtomParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAtom();

                    state._fsp--;

                     after(grammarAccess.getNegationAccess().getAtomParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1930:2: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // InternalXtext.g:1930:2: ( ( rule__Negation__Group_1__0 ) )
                    // InternalXtext.g:1931:3: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // InternalXtext.g:1932:3: ( rule__Negation__Group_1__0 )
                    // InternalXtext.g:1932:4: rule__Negation__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Negation__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNegationAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Alternatives"


    // $ANTLR start "rule__Atom__Alternatives"
    // InternalXtext.g:1940:1: rule__Atom__Alternatives : ( ( ruleParameterReference ) | ( ruleParenthesizedCondition ) | ( ruleLiteralCondition ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1944:1: ( ( ruleParameterReference ) | ( ruleParenthesizedCondition ) | ( ruleLiteralCondition ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt15=1;
                }
                break;
            case 23:
                {
                alt15=2;
                }
                break;
            case 17:
            case 18:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalXtext.g:1945:2: ( ruleParameterReference )
                    {
                    // InternalXtext.g:1945:2: ( ruleParameterReference )
                    // InternalXtext.g:1946:3: ruleParameterReference
                    {
                     before(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParameterReference();

                    state._fsp--;

                     after(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1951:2: ( ruleParenthesizedCondition )
                    {
                    // InternalXtext.g:1951:2: ( ruleParenthesizedCondition )
                    // InternalXtext.g:1952:3: ruleParenthesizedCondition
                    {
                     before(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedCondition();

                    state._fsp--;

                     after(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1957:2: ( ruleLiteralCondition )
                    {
                    // InternalXtext.g:1957:2: ( ruleLiteralCondition )
                    // InternalXtext.g:1958:3: ruleLiteralCondition
                    {
                     before(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLiteralCondition();

                    state._fsp--;

                     after(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Alternatives"


    // $ANTLR start "rule__ValidID__Alternatives"
    // InternalXtext.g:1967:1: rule__ValidID__Alternatives : ( ( RULE_ID ) | ( 'true' ) | ( 'false' ) );
    public final void rule__ValidID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1971:1: ( ( RULE_ID ) | ( 'true' ) | ( 'false' ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt16=1;
                }
                break;
            case 18:
                {
                alt16=2;
                }
                break;
            case 17:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalXtext.g:1972:2: ( RULE_ID )
                    {
                    // InternalXtext.g:1972:2: ( RULE_ID )
                    // InternalXtext.g:1973:3: RULE_ID
                    {
                     before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:1978:2: ( 'true' )
                    {
                    // InternalXtext.g:1978:2: ( 'true' )
                    // InternalXtext.g:1979:3: 'true'
                    {
                     before(grammarAccess.getValidIDAccess().getTrueKeyword_1()); 
                    match(input,18,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getTrueKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:1984:2: ( 'false' )
                    {
                    // InternalXtext.g:1984:2: ( 'false' )
                    // InternalXtext.g:1985:3: 'false'
                    {
                     before(grammarAccess.getValidIDAccess().getFalseKeyword_2()); 
                    match(input,17,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getValidIDAccess().getFalseKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValidID__Alternatives"


    // $ANTLR start "rule__PredicatedKeyword__Alternatives_0"
    // InternalXtext.g:1994:1: rule__PredicatedKeyword__Alternatives_0 : ( ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedKeyword__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:1998:1: ( ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==55) ) {
                alt17=1;
            }
            else if ( (LA17_0==48) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtext.g:1999:2: ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:1999:2: ( ( rule__PredicatedKeyword__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2000:3: ( rule__PredicatedKeyword__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2001:3: ( rule__PredicatedKeyword__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2001:4: rule__PredicatedKeyword__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedKeyword__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2005:2: ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2005:2: ( ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2006:3: ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2007:3: ( rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2007:4: rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Alternatives_0"


    // $ANTLR start "rule__PredicatedRuleCall__Alternatives_0"
    // InternalXtext.g:2015:1: rule__PredicatedRuleCall__Alternatives_0 : ( ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedRuleCall__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2019:1: ( ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==55) ) {
                alt18=1;
            }
            else if ( (LA18_0==48) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtext.g:2020:2: ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2020:2: ( ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2021:3: ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2022:3: ( rule__PredicatedRuleCall__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2022:4: rule__PredicatedRuleCall__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedRuleCall__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2026:2: ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2026:2: ( ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2027:3: ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2028:3: ( rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2028:4: rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Alternatives_0"


    // $ANTLR start "rule__Assignment__Alternatives_0"
    // InternalXtext.g:2036:1: rule__Assignment__Alternatives_0 : ( ( ( rule__Assignment__PredicatedAssignment_0_0 ) ) | ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__Assignment__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2040:1: ( ( ( rule__Assignment__PredicatedAssignment_0_0 ) ) | ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==55) ) {
                alt19=1;
            }
            else if ( (LA19_0==48) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalXtext.g:2041:2: ( ( rule__Assignment__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2041:2: ( ( rule__Assignment__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2042:3: ( rule__Assignment__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2043:3: ( rule__Assignment__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2043:4: rule__Assignment__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Assignment__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2047:2: ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2047:2: ( ( rule__Assignment__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2048:3: ( rule__Assignment__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2049:3: ( rule__Assignment__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2049:4: rule__Assignment__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Assignment__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Alternatives_0"


    // $ANTLR start "rule__Assignment__OperatorAlternatives_2_0"
    // InternalXtext.g:2057:1: rule__Assignment__OperatorAlternatives_2_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2061:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt20=1;
                }
                break;
            case 15:
                {
                alt20=2;
                }
                break;
            case 19:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalXtext.g:2062:2: ( '+=' )
                    {
                    // InternalXtext.g:2062:2: ( '+=' )
                    // InternalXtext.g:2063:3: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 
                    match(input,16,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2068:2: ( '=' )
                    {
                    // InternalXtext.g:2068:2: ( '=' )
                    // InternalXtext.g:2069:3: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2074:2: ( '?=' )
                    {
                    // InternalXtext.g:2074:2: ( '?=' )
                    // InternalXtext.g:2075:3: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); 
                    match(input,19,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__OperatorAlternatives_2_0"


    // $ANTLR start "rule__AssignableTerminal__Alternatives"
    // InternalXtext.g:2084:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2088:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt21=1;
                }
                break;
            case RULE_ID:
            case 17:
            case 18:
                {
                alt21=2;
                }
                break;
            case 23:
                {
                alt21=3;
                }
                break;
            case 45:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalXtext.g:2089:2: ( ruleKeyword )
                    {
                    // InternalXtext.g:2089:2: ( ruleKeyword )
                    // InternalXtext.g:2090:3: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2095:2: ( ruleRuleCall )
                    {
                    // InternalXtext.g:2095:2: ( ruleRuleCall )
                    // InternalXtext.g:2096:3: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2101:2: ( ruleParenthesizedAssignableElement )
                    {
                    // InternalXtext.g:2101:2: ( ruleParenthesizedAssignableElement )
                    // InternalXtext.g:2102:3: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:2107:2: ( ruleCrossReference )
                    {
                    // InternalXtext.g:2107:2: ( ruleCrossReference )
                    // InternalXtext.g:2108:3: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCrossReference();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableTerminal__Alternatives"


    // $ANTLR start "rule__CrossReferenceableTerminal__Alternatives"
    // InternalXtext.g:2117:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2121:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_STRING) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ID||(LA22_0>=17 && LA22_0<=18)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtext.g:2122:2: ( ruleKeyword )
                    {
                    // InternalXtext.g:2122:2: ( ruleKeyword )
                    // InternalXtext.g:2123:3: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2128:2: ( ruleRuleCall )
                    {
                    // InternalXtext.g:2128:2: ( ruleRuleCall )
                    // InternalXtext.g:2129:3: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReferenceableTerminal__Alternatives"


    // $ANTLR start "rule__PredicatedGroup__Alternatives_0"
    // InternalXtext.g:2138:1: rule__PredicatedGroup__Alternatives_0 : ( ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) ) );
    public final void rule__PredicatedGroup__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2142:1: ( ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) ) | ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==55) ) {
                alt23=1;
            }
            else if ( (LA23_0==48) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalXtext.g:2143:2: ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) )
                    {
                    // InternalXtext.g:2143:2: ( ( rule__PredicatedGroup__PredicatedAssignment_0_0 ) )
                    // InternalXtext.g:2144:3: ( rule__PredicatedGroup__PredicatedAssignment_0_0 )
                    {
                     before(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); 
                    // InternalXtext.g:2145:3: ( rule__PredicatedGroup__PredicatedAssignment_0_0 )
                    // InternalXtext.g:2145:4: rule__PredicatedGroup__PredicatedAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedGroup__PredicatedAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2149:2: ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) )
                    {
                    // InternalXtext.g:2149:2: ( ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 ) )
                    // InternalXtext.g:2150:3: ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 )
                    {
                     before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); 
                    // InternalXtext.g:2151:3: ( rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 )
                    // InternalXtext.g:2151:4: rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Alternatives_0"


    // $ANTLR start "rule__TerminalRule__Alternatives_2"
    // InternalXtext.g:2159:1: rule__TerminalRule__Alternatives_2 : ( ( ( rule__TerminalRule__Group_2_0__0 ) ) | ( ( rule__TerminalRule__Group_2_1__0 ) ) );
    public final void rule__TerminalRule__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2163:1: ( ( ( rule__TerminalRule__Group_2_0__0 ) ) | ( ( rule__TerminalRule__Group_2_1__0 ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==54) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_ID||(LA24_0>=17 && LA24_0<=18)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtext.g:2164:2: ( ( rule__TerminalRule__Group_2_0__0 ) )
                    {
                    // InternalXtext.g:2164:2: ( ( rule__TerminalRule__Group_2_0__0 ) )
                    // InternalXtext.g:2165:3: ( rule__TerminalRule__Group_2_0__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_2_0()); 
                    // InternalXtext.g:2166:3: ( rule__TerminalRule__Group_2_0__0 )
                    // InternalXtext.g:2166:4: rule__TerminalRule__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2170:2: ( ( rule__TerminalRule__Group_2_1__0 ) )
                    {
                    // InternalXtext.g:2170:2: ( ( rule__TerminalRule__Group_2_1__0 ) )
                    // InternalXtext.g:2171:3: ( rule__TerminalRule__Group_2_1__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_2_1()); 
                    // InternalXtext.g:2172:3: ( rule__TerminalRule__Group_2_1__0 )
                    // InternalXtext.g:2172:4: rule__TerminalRule__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Alternatives_2"


    // $ANTLR start "rule__TerminalToken__CardinalityAlternatives_1_0"
    // InternalXtext.g:2180:1: rule__TerminalToken__CardinalityAlternatives_1_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__TerminalToken__CardinalityAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2184:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt25=1;
                }
                break;
            case 13:
                {
                alt25=2;
                }
                break;
            case 14:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalXtext.g:2185:2: ( '?' )
                    {
                    // InternalXtext.g:2185:2: ( '?' )
                    // InternalXtext.g:2186:3: '?'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2191:2: ( '*' )
                    {
                    // InternalXtext.g:2191:2: ( '*' )
                    // InternalXtext.g:2192:3: '*'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2197:2: ( '+' )
                    {
                    // InternalXtext.g:2197:2: ( '+' )
                    // InternalXtext.g:2198:3: '+'
                    {
                     before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__CardinalityAlternatives_1_0"


    // $ANTLR start "rule__TerminalTokenElement__Alternatives"
    // InternalXtext.g:2207:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2211:1: ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) )
            int alt26=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt26=1;
                }
                break;
            case RULE_ID:
            case 17:
            case 18:
                {
                alt26=2;
                }
                break;
            case 23:
                {
                alt26=3;
                }
                break;
            case 44:
            case 48:
                {
                alt26=4;
                }
                break;
            case 27:
                {
                alt26=5;
                }
                break;
            case 49:
                {
                alt26=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalXtext.g:2212:2: ( ruleCharacterRange )
                    {
                    // InternalXtext.g:2212:2: ( ruleCharacterRange )
                    // InternalXtext.g:2213:3: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCharacterRange();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2218:2: ( ruleTerminalRuleCall )
                    {
                    // InternalXtext.g:2218:2: ( ruleTerminalRuleCall )
                    // InternalXtext.g:2219:3: ruleTerminalRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRuleCall();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:2224:2: ( ruleParenthesizedTerminalElement )
                    {
                    // InternalXtext.g:2224:2: ( ruleParenthesizedTerminalElement )
                    // InternalXtext.g:2225:3: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtext.g:2230:2: ( ruleAbstractNegatedToken )
                    {
                    // InternalXtext.g:2230:2: ( ruleAbstractNegatedToken )
                    // InternalXtext.g:2231:3: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtext.g:2236:2: ( ruleWildcard )
                    {
                    // InternalXtext.g:2236:2: ( ruleWildcard )
                    // InternalXtext.g:2237:3: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWildcard();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtext.g:2242:2: ( ruleEOF )
                    {
                    // InternalXtext.g:2242:2: ( ruleEOF )
                    // InternalXtext.g:2243:3: ruleEOF
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEOF();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalTokenElement__Alternatives"


    // $ANTLR start "rule__AbstractNegatedToken__Alternatives"
    // InternalXtext.g:2252:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2256:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            else if ( (LA27_0==48) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalXtext.g:2257:2: ( ruleNegatedToken )
                    {
                    // InternalXtext.g:2257:2: ( ruleNegatedToken )
                    // InternalXtext.g:2258:3: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2263:2: ( ruleUntilToken )
                    {
                    // InternalXtext.g:2263:2: ( ruleUntilToken )
                    // InternalXtext.g:2264:3: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUntilToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractNegatedToken__Alternatives"


    // $ANTLR start "rule__Grammar__Group__0"
    // InternalXtext.g:2273:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2277:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // InternalXtext.g:2278:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__0"


    // $ANTLR start "rule__Grammar__Group__0__Impl"
    // InternalXtext.g:2285:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2289:1: ( ( 'grammar' ) )
            // InternalXtext.g:2290:1: ( 'grammar' )
            {
            // InternalXtext.g:2290:1: ( 'grammar' )
            // InternalXtext.g:2291:2: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__0__Impl"


    // $ANTLR start "rule__Grammar__Group__1"
    // InternalXtext.g:2300:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2304:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // InternalXtext.g:2305:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__1"


    // $ANTLR start "rule__Grammar__Group__1__Impl"
    // InternalXtext.g:2312:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2316:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // InternalXtext.g:2317:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // InternalXtext.g:2317:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // InternalXtext.g:2318:2: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // InternalXtext.g:2319:2: ( rule__Grammar__NameAssignment_1 )
            // InternalXtext.g:2319:3: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__1__Impl"


    // $ANTLR start "rule__Grammar__Group__2"
    // InternalXtext.g:2327:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2331:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // InternalXtext.g:2332:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__2"


    // $ANTLR start "rule__Grammar__Group__2__Impl"
    // InternalXtext.g:2339:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2343:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // InternalXtext.g:2344:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // InternalXtext.g:2344:1: ( ( rule__Grammar__Group_2__0 )? )
            // InternalXtext.g:2345:2: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // InternalXtext.g:2346:2: ( rule__Grammar__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==21) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXtext.g:2346:3: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__2__Impl"


    // $ANTLR start "rule__Grammar__Group__3"
    // InternalXtext.g:2354:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2358:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // InternalXtext.g:2359:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__3"


    // $ANTLR start "rule__Grammar__Group__3__Impl"
    // InternalXtext.g:2366:1: rule__Grammar__Group__3__Impl : ( ( rule__Grammar__Group_3__0 )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2370:1: ( ( ( rule__Grammar__Group_3__0 )? ) )
            // InternalXtext.g:2371:1: ( ( rule__Grammar__Group_3__0 )? )
            {
            // InternalXtext.g:2371:1: ( ( rule__Grammar__Group_3__0 )? )
            // InternalXtext.g:2372:2: ( rule__Grammar__Group_3__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3()); 
            // InternalXtext.g:2373:2: ( rule__Grammar__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==52) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtext.g:2373:3: rule__Grammar__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__3__Impl"


    // $ANTLR start "rule__Grammar__Group__4"
    // InternalXtext.g:2381:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2385:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // InternalXtext.g:2386:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__4"


    // $ANTLR start "rule__Grammar__Group__4__Impl"
    // InternalXtext.g:2393:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2397:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // InternalXtext.g:2398:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // InternalXtext.g:2398:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // InternalXtext.g:2399:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // InternalXtext.g:2400:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==28||LA30_0==30) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXtext.g:2400:3: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Grammar__MetamodelDeclarationsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__4__Impl"


    // $ANTLR start "rule__Grammar__Group__5"
    // InternalXtext.g:2408:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl rule__Grammar__Group__6 ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2412:1: ( rule__Grammar__Group__5__Impl rule__Grammar__Group__6 )
            // InternalXtext.g:2413:2: rule__Grammar__Group__5__Impl rule__Grammar__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Grammar__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__5"


    // $ANTLR start "rule__Grammar__Group__5__Impl"
    // InternalXtext.g:2420:1: rule__Grammar__Group__5__Impl : ( ( rule__Grammar__UnorderedGroup_5 ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2424:1: ( ( ( rule__Grammar__UnorderedGroup_5 ) ) )
            // InternalXtext.g:2425:1: ( ( rule__Grammar__UnorderedGroup_5 ) )
            {
            // InternalXtext.g:2425:1: ( ( rule__Grammar__UnorderedGroup_5 ) )
            // InternalXtext.g:2426:2: ( rule__Grammar__UnorderedGroup_5 )
            {
             before(grammarAccess.getGrammarAccess().getUnorderedGroup_5()); 
            // InternalXtext.g:2427:2: ( rule__Grammar__UnorderedGroup_5 )
            // InternalXtext.g:2427:3: rule__Grammar__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__UnorderedGroup_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUnorderedGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__5__Impl"


    // $ANTLR start "rule__Grammar__Group__6"
    // InternalXtext.g:2435:1: rule__Grammar__Group__6 : rule__Grammar__Group__6__Impl ;
    public final void rule__Grammar__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2439:1: ( rule__Grammar__Group__6__Impl )
            // InternalXtext.g:2440:2: rule__Grammar__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__6"


    // $ANTLR start "rule__Grammar__Group__6__Impl"
    // InternalXtext.g:2446:1: rule__Grammar__Group__6__Impl : ( ( ( rule__Grammar__RulesAssignment_6 ) ) ( ( rule__Grammar__RulesAssignment_6 )* ) ) ;
    public final void rule__Grammar__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2450:1: ( ( ( ( rule__Grammar__RulesAssignment_6 ) ) ( ( rule__Grammar__RulesAssignment_6 )* ) ) )
            // InternalXtext.g:2451:1: ( ( ( rule__Grammar__RulesAssignment_6 ) ) ( ( rule__Grammar__RulesAssignment_6 )* ) )
            {
            // InternalXtext.g:2451:1: ( ( ( rule__Grammar__RulesAssignment_6 ) ) ( ( rule__Grammar__RulesAssignment_6 )* ) )
            // InternalXtext.g:2452:2: ( ( rule__Grammar__RulesAssignment_6 ) ) ( ( rule__Grammar__RulesAssignment_6 )* )
            {
            // InternalXtext.g:2452:2: ( ( rule__Grammar__RulesAssignment_6 ) )
            // InternalXtext.g:2453:3: ( rule__Grammar__RulesAssignment_6 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_6()); 
            // InternalXtext.g:2454:3: ( rule__Grammar__RulesAssignment_6 )
            // InternalXtext.g:2454:4: rule__Grammar__RulesAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Grammar__RulesAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_6()); 

            }

            // InternalXtext.g:2457:2: ( ( rule__Grammar__RulesAssignment_6 )* )
            // InternalXtext.g:2458:3: ( rule__Grammar__RulesAssignment_6 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_6()); 
            // InternalXtext.g:2459:3: ( rule__Grammar__RulesAssignment_6 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||(LA31_0>=17 && LA31_0<=18)||LA31_0==31||LA31_0==47||LA31_0==51||LA31_0==54) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalXtext.g:2459:4: rule__Grammar__RulesAssignment_6
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Grammar__RulesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getRulesAssignment_6()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__6__Impl"


    // $ANTLR start "rule__Grammar__Group_2__0"
    // InternalXtext.g:2469:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2473:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // InternalXtext.g:2474:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__0"


    // $ANTLR start "rule__Grammar__Group_2__0__Impl"
    // InternalXtext.g:2481:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2485:1: ( ( 'with' ) )
            // InternalXtext.g:2486:1: ( 'with' )
            {
            // InternalXtext.g:2486:1: ( 'with' )
            // InternalXtext.g:2487:2: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_2__1"
    // InternalXtext.g:2496:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2500:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // InternalXtext.g:2501:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Grammar__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__1"


    // $ANTLR start "rule__Grammar__Group_2__1__Impl"
    // InternalXtext.g:2508:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2512:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // InternalXtext.g:2513:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // InternalXtext.g:2513:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // InternalXtext.g:2514:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // InternalXtext.g:2515:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // InternalXtext.g:2515:3: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__UsedGrammarsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_2__2"
    // InternalXtext.g:2523:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2527:1: ( rule__Grammar__Group_2__2__Impl )
            // InternalXtext.g:2528:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__2"


    // $ANTLR start "rule__Grammar__Group_2__2__Impl"
    // InternalXtext.g:2534:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2538:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // InternalXtext.g:2539:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // InternalXtext.g:2539:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // InternalXtext.g:2540:2: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // InternalXtext.g:2541:2: ( rule__Grammar__Group_2_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==22) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalXtext.g:2541:3: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__Grammar__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__2__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__0"
    // InternalXtext.g:2550:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2554:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // InternalXtext.g:2555:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__0"


    // $ANTLR start "rule__Grammar__Group_2_2__0__Impl"
    // InternalXtext.g:2562:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2566:1: ( ( ',' ) )
            // InternalXtext.g:2567:1: ( ',' )
            {
            // InternalXtext.g:2567:1: ( ',' )
            // InternalXtext.g:2568:2: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__1"
    // InternalXtext.g:2577:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2581:1: ( rule__Grammar__Group_2_2__1__Impl )
            // InternalXtext.g:2582:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__1"


    // $ANTLR start "rule__Grammar__Group_2_2__1__Impl"
    // InternalXtext.g:2588:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2592:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // InternalXtext.g:2593:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // InternalXtext.g:2593:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // InternalXtext.g:2594:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // InternalXtext.g:2595:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // InternalXtext.g:2595:3: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__UsedGrammarsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3__0"
    // InternalXtext.g:2604:1: rule__Grammar__Group_3__0 : rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 ;
    public final void rule__Grammar__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2608:1: ( rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1 )
            // InternalXtext.g:2609:2: rule__Grammar__Group_3__0__Impl rule__Grammar__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Grammar__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__0"


    // $ANTLR start "rule__Grammar__Group_3__0__Impl"
    // InternalXtext.g:2616:1: rule__Grammar__Group_3__0__Impl : ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) ;
    public final void rule__Grammar__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2620:1: ( ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) ) )
            // InternalXtext.g:2621:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            {
            // InternalXtext.g:2621:1: ( ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 ) )
            // InternalXtext.g:2622:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 
            // InternalXtext.g:2623:2: ( rule__Grammar__DefinesHiddenTokensAssignment_3_0 )
            // InternalXtext.g:2623:3: rule__Grammar__DefinesHiddenTokensAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__DefinesHiddenTokensAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__0__Impl"


    // $ANTLR start "rule__Grammar__Group_3__1"
    // InternalXtext.g:2631:1: rule__Grammar__Group_3__1 : rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 ;
    public final void rule__Grammar__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2635:1: ( rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2 )
            // InternalXtext.g:2636:2: rule__Grammar__Group_3__1__Impl rule__Grammar__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Grammar__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__1"


    // $ANTLR start "rule__Grammar__Group_3__1__Impl"
    // InternalXtext.g:2643:1: rule__Grammar__Group_3__1__Impl : ( '(' ) ;
    public final void rule__Grammar__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2647:1: ( ( '(' ) )
            // InternalXtext.g:2648:1: ( '(' )
            {
            // InternalXtext.g:2648:1: ( '(' )
            // InternalXtext.g:2649:2: '('
            {
             before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3__2"
    // InternalXtext.g:2658:1: rule__Grammar__Group_3__2 : rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 ;
    public final void rule__Grammar__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2662:1: ( rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3 )
            // InternalXtext.g:2663:2: rule__Grammar__Group_3__2__Impl rule__Grammar__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Grammar__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__2"


    // $ANTLR start "rule__Grammar__Group_3__2__Impl"
    // InternalXtext.g:2670:1: rule__Grammar__Group_3__2__Impl : ( ( rule__Grammar__Group_3_2__0 )? ) ;
    public final void rule__Grammar__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2674:1: ( ( ( rule__Grammar__Group_3_2__0 )? ) )
            // InternalXtext.g:2675:1: ( ( rule__Grammar__Group_3_2__0 )? )
            {
            // InternalXtext.g:2675:1: ( ( rule__Grammar__Group_3_2__0 )? )
            // InternalXtext.g:2676:2: ( rule__Grammar__Group_3_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2()); 
            // InternalXtext.g:2677:2: ( rule__Grammar__Group_3_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID||(LA33_0>=17 && LA33_0<=18)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXtext.g:2677:3: rule__Grammar__Group_3_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__Group_3_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__2__Impl"


    // $ANTLR start "rule__Grammar__Group_3__3"
    // InternalXtext.g:2685:1: rule__Grammar__Group_3__3 : rule__Grammar__Group_3__3__Impl ;
    public final void rule__Grammar__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2689:1: ( rule__Grammar__Group_3__3__Impl )
            // InternalXtext.g:2690:2: rule__Grammar__Group_3__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__3"


    // $ANTLR start "rule__Grammar__Group_3__3__Impl"
    // InternalXtext.g:2696:1: rule__Grammar__Group_3__3__Impl : ( ')' ) ;
    public final void rule__Grammar__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2700:1: ( ( ')' ) )
            // InternalXtext.g:2701:1: ( ')' )
            {
            // InternalXtext.g:2701:1: ( ')' )
            // InternalXtext.g:2702:2: ')'
            {
             before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3__3__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2__0"
    // InternalXtext.g:2712:1: rule__Grammar__Group_3_2__0 : rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 ;
    public final void rule__Grammar__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2716:1: ( rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1 )
            // InternalXtext.g:2717:2: rule__Grammar__Group_3_2__0__Impl rule__Grammar__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Grammar__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2__0"


    // $ANTLR start "rule__Grammar__Group_3_2__0__Impl"
    // InternalXtext.g:2724:1: rule__Grammar__Group_3_2__0__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) ;
    public final void rule__Grammar__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2728:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) ) )
            // InternalXtext.g:2729:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            {
            // InternalXtext.g:2729:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_0 ) )
            // InternalXtext.g:2730:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 
            // InternalXtext.g:2731:2: ( rule__Grammar__HiddenTokensAssignment_3_2_0 )
            // InternalXtext.g:2731:3: rule__Grammar__HiddenTokensAssignment_3_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__HiddenTokensAssignment_3_2_0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2__1"
    // InternalXtext.g:2739:1: rule__Grammar__Group_3_2__1 : rule__Grammar__Group_3_2__1__Impl ;
    public final void rule__Grammar__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2743:1: ( rule__Grammar__Group_3_2__1__Impl )
            // InternalXtext.g:2744:2: rule__Grammar__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2__1"


    // $ANTLR start "rule__Grammar__Group_3_2__1__Impl"
    // InternalXtext.g:2750:1: rule__Grammar__Group_3_2__1__Impl : ( ( rule__Grammar__Group_3_2_1__0 )* ) ;
    public final void rule__Grammar__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2754:1: ( ( ( rule__Grammar__Group_3_2_1__0 )* ) )
            // InternalXtext.g:2755:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            {
            // InternalXtext.g:2755:1: ( ( rule__Grammar__Group_3_2_1__0 )* )
            // InternalXtext.g:2756:2: ( rule__Grammar__Group_3_2_1__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 
            // InternalXtext.g:2757:2: ( rule__Grammar__Group_3_2_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==22) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalXtext.g:2757:3: rule__Grammar__Group_3_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__Grammar__Group_3_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getGroup_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2_1__0"
    // InternalXtext.g:2766:1: rule__Grammar__Group_3_2_1__0 : rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 ;
    public final void rule__Grammar__Group_3_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2770:1: ( rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1 )
            // InternalXtext.g:2771:2: rule__Grammar__Group_3_2_1__0__Impl rule__Grammar__Group_3_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_3_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2_1__0"


    // $ANTLR start "rule__Grammar__Group_3_2_1__0__Impl"
    // InternalXtext.g:2778:1: rule__Grammar__Group_3_2_1__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_3_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2782:1: ( ( ',' ) )
            // InternalXtext.g:2783:1: ( ',' )
            {
            // InternalXtext.g:2783:1: ( ',' )
            // InternalXtext.g:2784:2: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2_1__0__Impl"


    // $ANTLR start "rule__Grammar__Group_3_2_1__1"
    // InternalXtext.g:2793:1: rule__Grammar__Group_3_2_1__1 : rule__Grammar__Group_3_2_1__1__Impl ;
    public final void rule__Grammar__Group_3_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2797:1: ( rule__Grammar__Group_3_2_1__1__Impl )
            // InternalXtext.g:2798:2: rule__Grammar__Group_3_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_3_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2_1__1"


    // $ANTLR start "rule__Grammar__Group_3_2_1__1__Impl"
    // InternalXtext.g:2804:1: rule__Grammar__Group_3_2_1__1__Impl : ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) ;
    public final void rule__Grammar__Group_3_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2808:1: ( ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) ) )
            // InternalXtext.g:2809:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            {
            // InternalXtext.g:2809:1: ( ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 ) )
            // InternalXtext.g:2810:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 
            // InternalXtext.g:2811:2: ( rule__Grammar__HiddenTokensAssignment_3_2_1_1 )
            // InternalXtext.g:2811:3: rule__Grammar__HiddenTokensAssignment_3_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__HiddenTokensAssignment_3_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_3_2_1__1__Impl"


    // $ANTLR start "rule__Grammar__Group_5_0__0"
    // InternalXtext.g:2820:1: rule__Grammar__Group_5_0__0 : rule__Grammar__Group_5_0__0__Impl rule__Grammar__Group_5_0__1 ;
    public final void rule__Grammar__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2824:1: ( rule__Grammar__Group_5_0__0__Impl rule__Grammar__Group_5_0__1 )
            // InternalXtext.g:2825:2: rule__Grammar__Group_5_0__0__Impl rule__Grammar__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Grammar__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_5_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_5_0__0"


    // $ANTLR start "rule__Grammar__Group_5_0__0__Impl"
    // InternalXtext.g:2832:1: rule__Grammar__Group_5_0__0__Impl : ( 'tokenLimit' ) ;
    public final void rule__Grammar__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2836:1: ( ( 'tokenLimit' ) )
            // InternalXtext.g:2837:1: ( 'tokenLimit' )
            {
            // InternalXtext.g:2837:1: ( 'tokenLimit' )
            // InternalXtext.g:2838:2: 'tokenLimit'
            {
             before(grammarAccess.getGrammarAccess().getTokenLimitKeyword_5_0_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getTokenLimitKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_5_0__0__Impl"


    // $ANTLR start "rule__Grammar__Group_5_0__1"
    // InternalXtext.g:2847:1: rule__Grammar__Group_5_0__1 : rule__Grammar__Group_5_0__1__Impl ;
    public final void rule__Grammar__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2851:1: ( rule__Grammar__Group_5_0__1__Impl )
            // InternalXtext.g:2852:2: rule__Grammar__Group_5_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_5_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_5_0__1"


    // $ANTLR start "rule__Grammar__Group_5_0__1__Impl"
    // InternalXtext.g:2858:1: rule__Grammar__Group_5_0__1__Impl : ( ( rule__Grammar__TokenLimitAssignment_5_0_1 ) ) ;
    public final void rule__Grammar__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2862:1: ( ( ( rule__Grammar__TokenLimitAssignment_5_0_1 ) ) )
            // InternalXtext.g:2863:1: ( ( rule__Grammar__TokenLimitAssignment_5_0_1 ) )
            {
            // InternalXtext.g:2863:1: ( ( rule__Grammar__TokenLimitAssignment_5_0_1 ) )
            // InternalXtext.g:2864:2: ( rule__Grammar__TokenLimitAssignment_5_0_1 )
            {
             before(grammarAccess.getGrammarAccess().getTokenLimitAssignment_5_0_1()); 
            // InternalXtext.g:2865:2: ( rule__Grammar__TokenLimitAssignment_5_0_1 )
            // InternalXtext.g:2865:3: rule__Grammar__TokenLimitAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__TokenLimitAssignment_5_0_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getTokenLimitAssignment_5_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_5_0__1__Impl"


    // $ANTLR start "rule__InitBlock__Group__0"
    // InternalXtext.g:2874:1: rule__InitBlock__Group__0 : rule__InitBlock__Group__0__Impl rule__InitBlock__Group__1 ;
    public final void rule__InitBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2878:1: ( rule__InitBlock__Group__0__Impl rule__InitBlock__Group__1 )
            // InternalXtext.g:2879:2: rule__InitBlock__Group__0__Impl rule__InitBlock__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__InitBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__InitBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InitBlock__Group__0"


    // $ANTLR start "rule__InitBlock__Group__0__Impl"
    // InternalXtext.g:2886:1: rule__InitBlock__Group__0__Impl : ( 'setup' ) ;
    public final void rule__InitBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2890:1: ( ( 'setup' ) )
            // InternalXtext.g:2891:1: ( 'setup' )
            {
            // InternalXtext.g:2891:1: ( 'setup' )
            // InternalXtext.g:2892:2: 'setup'
            {
             before(grammarAccess.getInitBlockAccess().getSetupKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getInitBlockAccess().getSetupKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InitBlock__Group__0__Impl"


    // $ANTLR start "rule__InitBlock__Group__1"
    // InternalXtext.g:2901:1: rule__InitBlock__Group__1 : rule__InitBlock__Group__1__Impl ;
    public final void rule__InitBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2905:1: ( rule__InitBlock__Group__1__Impl )
            // InternalXtext.g:2906:2: rule__InitBlock__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__InitBlock__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InitBlock__Group__1"


    // $ANTLR start "rule__InitBlock__Group__1__Impl"
    // InternalXtext.g:2912:1: rule__InitBlock__Group__1__Impl : ( ( rule__InitBlock__CodeAssignment_1 ) ) ;
    public final void rule__InitBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2916:1: ( ( ( rule__InitBlock__CodeAssignment_1 ) ) )
            // InternalXtext.g:2917:1: ( ( rule__InitBlock__CodeAssignment_1 ) )
            {
            // InternalXtext.g:2917:1: ( ( rule__InitBlock__CodeAssignment_1 ) )
            // InternalXtext.g:2918:2: ( rule__InitBlock__CodeAssignment_1 )
            {
             before(grammarAccess.getInitBlockAccess().getCodeAssignment_1()); 
            // InternalXtext.g:2919:2: ( rule__InitBlock__CodeAssignment_1 )
            // InternalXtext.g:2919:3: rule__InitBlock__CodeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__InitBlock__CodeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInitBlockAccess().getCodeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InitBlock__Group__1__Impl"


    // $ANTLR start "rule__GrammarID__Group__0"
    // InternalXtext.g:2928:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2932:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // InternalXtext.g:2933:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__GrammarID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__0"


    // $ANTLR start "rule__GrammarID__Group__0__Impl"
    // InternalXtext.g:2940:1: rule__GrammarID__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2944:1: ( ( ruleValidID ) )
            // InternalXtext.g:2945:1: ( ruleValidID )
            {
            // InternalXtext.g:2945:1: ( ruleValidID )
            // InternalXtext.g:2946:2: ruleValidID
            {
             before(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__0__Impl"


    // $ANTLR start "rule__GrammarID__Group__1"
    // InternalXtext.g:2955:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2959:1: ( rule__GrammarID__Group__1__Impl )
            // InternalXtext.g:2960:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__1"


    // $ANTLR start "rule__GrammarID__Group__1__Impl"
    // InternalXtext.g:2966:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2970:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // InternalXtext.g:2971:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // InternalXtext.g:2971:1: ( ( rule__GrammarID__Group_1__0 )* )
            // InternalXtext.g:2972:2: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // InternalXtext.g:2973:2: ( rule__GrammarID__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==27) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalXtext.g:2973:3: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    rule__GrammarID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getGrammarIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__1__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__0"
    // InternalXtext.g:2982:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2986:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // InternalXtext.g:2987:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GrammarID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__0"


    // $ANTLR start "rule__GrammarID__Group_1__0__Impl"
    // InternalXtext.g:2994:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:2998:1: ( ( '.' ) )
            // InternalXtext.g:2999:1: ( '.' )
            {
            // InternalXtext.g:2999:1: ( '.' )
            // InternalXtext.g:3000:2: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__0__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__1"
    // InternalXtext.g:3009:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3013:1: ( rule__GrammarID__Group_1__1__Impl )
            // InternalXtext.g:3014:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__1"


    // $ANTLR start "rule__GrammarID__Group_1__1__Impl"
    // InternalXtext.g:3020:1: rule__GrammarID__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3024:1: ( ( ruleValidID ) )
            // InternalXtext.g:3025:1: ( ruleValidID )
            {
            // InternalXtext.g:3025:1: ( ruleValidID )
            // InternalXtext.g:3026:2: ruleValidID
            {
             before(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__1__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__0"
    // InternalXtext.g:3036:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3040:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // InternalXtext.g:3041:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GeneratedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__0"


    // $ANTLR start "rule__GeneratedMetamodel__Group__0__Impl"
    // InternalXtext.g:3048:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3052:1: ( ( 'generate' ) )
            // InternalXtext.g:3053:1: ( 'generate' )
            {
            // InternalXtext.g:3053:1: ( 'generate' )
            // InternalXtext.g:3054:2: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__0__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__1"
    // InternalXtext.g:3063:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3067:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // InternalXtext.g:3068:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__GeneratedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__1"


    // $ANTLR start "rule__GeneratedMetamodel__Group__1__Impl"
    // InternalXtext.g:3075:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3079:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // InternalXtext.g:3080:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // InternalXtext.g:3080:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // InternalXtext.g:3081:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // InternalXtext.g:3082:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // InternalXtext.g:3082:3: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__1__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__2"
    // InternalXtext.g:3090:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3094:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // InternalXtext.g:3095:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__GeneratedMetamodel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__2"


    // $ANTLR start "rule__GeneratedMetamodel__Group__2__Impl"
    // InternalXtext.g:3102:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3106:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // InternalXtext.g:3107:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // InternalXtext.g:3107:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // InternalXtext.g:3108:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // InternalXtext.g:3109:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // InternalXtext.g:3109:3: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__EPackageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__2__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__3"
    // InternalXtext.g:3117:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3121:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // InternalXtext.g:3122:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__3"


    // $ANTLR start "rule__GeneratedMetamodel__Group__3__Impl"
    // InternalXtext.g:3128:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3132:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // InternalXtext.g:3133:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // InternalXtext.g:3133:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // InternalXtext.g:3134:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // InternalXtext.g:3135:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==29) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXtext.g:3135:3: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__GeneratedMetamodel__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__3__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__0"
    // InternalXtext.g:3144:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3148:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // InternalXtext.g:3149:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GeneratedMetamodel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__0"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__0__Impl"
    // InternalXtext.g:3156:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3160:1: ( ( 'as' ) )
            // InternalXtext.g:3161:1: ( 'as' )
            {
            // InternalXtext.g:3161:1: ( 'as' )
            // InternalXtext.g:3162:2: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__0__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__1"
    // InternalXtext.g:3171:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3175:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // InternalXtext.g:3176:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__1"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__1__Impl"
    // InternalXtext.g:3182:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3186:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // InternalXtext.g:3187:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // InternalXtext.g:3187:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // InternalXtext.g:3188:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // InternalXtext.g:3189:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // InternalXtext.g:3189:3: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__AliasAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__1__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__0"
    // InternalXtext.g:3198:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3202:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // InternalXtext.g:3203:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ReferencedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__0"


    // $ANTLR start "rule__ReferencedMetamodel__Group__0__Impl"
    // InternalXtext.g:3210:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3214:1: ( ( 'import' ) )
            // InternalXtext.g:3215:1: ( 'import' )
            {
            // InternalXtext.g:3215:1: ( 'import' )
            // InternalXtext.g:3216:2: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__0__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__1"
    // InternalXtext.g:3225:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3229:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // InternalXtext.g:3230:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__ReferencedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__1"


    // $ANTLR start "rule__ReferencedMetamodel__Group__1__Impl"
    // InternalXtext.g:3237:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3241:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // InternalXtext.g:3242:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // InternalXtext.g:3242:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // InternalXtext.g:3243:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // InternalXtext.g:3244:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // InternalXtext.g:3244:3: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__EPackageAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__1__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__2"
    // InternalXtext.g:3252:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3256:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // InternalXtext.g:3257:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__2"


    // $ANTLR start "rule__ReferencedMetamodel__Group__2__Impl"
    // InternalXtext.g:3263:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3267:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // InternalXtext.g:3268:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // InternalXtext.g:3268:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // InternalXtext.g:3269:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // InternalXtext.g:3270:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==29) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXtext.g:3270:3: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ReferencedMetamodel__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__2__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__0"
    // InternalXtext.g:3279:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3283:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // InternalXtext.g:3284:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ReferencedMetamodel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__0"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__0__Impl"
    // InternalXtext.g:3291:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3295:1: ( ( 'as' ) )
            // InternalXtext.g:3296:1: ( 'as' )
            {
            // InternalXtext.g:3296:1: ( 'as' )
            // InternalXtext.g:3297:2: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__0__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__1"
    // InternalXtext.g:3306:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3310:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // InternalXtext.g:3311:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__1"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__1__Impl"
    // InternalXtext.g:3317:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3321:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // InternalXtext.g:3322:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // InternalXtext.g:3322:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // InternalXtext.g:3323:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // InternalXtext.g:3324:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // InternalXtext.g:3324:3: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__AliasAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__1__Impl"


    // $ANTLR start "rule__Annotation__Group__0"
    // InternalXtext.g:3333:1: rule__Annotation__Group__0 : rule__Annotation__Group__0__Impl rule__Annotation__Group__1 ;
    public final void rule__Annotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3337:1: ( rule__Annotation__Group__0__Impl rule__Annotation__Group__1 )
            // InternalXtext.g:3338:2: rule__Annotation__Group__0__Impl rule__Annotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Annotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__0"


    // $ANTLR start "rule__Annotation__Group__0__Impl"
    // InternalXtext.g:3345:1: rule__Annotation__Group__0__Impl : ( '@' ) ;
    public final void rule__Annotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3349:1: ( ( '@' ) )
            // InternalXtext.g:3350:1: ( '@' )
            {
            // InternalXtext.g:3350:1: ( '@' )
            // InternalXtext.g:3351:2: '@'
            {
             before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__0__Impl"


    // $ANTLR start "rule__Annotation__Group__1"
    // InternalXtext.g:3360:1: rule__Annotation__Group__1 : rule__Annotation__Group__1__Impl ;
    public final void rule__Annotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3364:1: ( rule__Annotation__Group__1__Impl )
            // InternalXtext.g:3365:2: rule__Annotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__1"


    // $ANTLR start "rule__Annotation__Group__1__Impl"
    // InternalXtext.g:3371:1: rule__Annotation__Group__1__Impl : ( ( rule__Annotation__NameAssignment_1 ) ) ;
    public final void rule__Annotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3375:1: ( ( ( rule__Annotation__NameAssignment_1 ) ) )
            // InternalXtext.g:3376:1: ( ( rule__Annotation__NameAssignment_1 ) )
            {
            // InternalXtext.g:3376:1: ( ( rule__Annotation__NameAssignment_1 ) )
            // InternalXtext.g:3377:2: ( rule__Annotation__NameAssignment_1 )
            {
             before(grammarAccess.getAnnotationAccess().getNameAssignment_1()); 
            // InternalXtext.g:3378:2: ( rule__Annotation__NameAssignment_1 )
            // InternalXtext.g:3378:3: rule__Annotation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Annotation__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__Group__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__0"
    // InternalXtext.g:3387:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3391:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // InternalXtext.g:3392:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__ParserRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__0"


    // $ANTLR start "rule__ParserRule__Group__0__Impl"
    // InternalXtext.g:3399:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__AnnotationsAssignment_0 )* ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3403:1: ( ( ( rule__ParserRule__AnnotationsAssignment_0 )* ) )
            // InternalXtext.g:3404:1: ( ( rule__ParserRule__AnnotationsAssignment_0 )* )
            {
            // InternalXtext.g:3404:1: ( ( rule__ParserRule__AnnotationsAssignment_0 )* )
            // InternalXtext.g:3405:2: ( rule__ParserRule__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0()); 
            // InternalXtext.g:3406:2: ( rule__ParserRule__AnnotationsAssignment_0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==31) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalXtext.g:3406:3: rule__ParserRule__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__ParserRule__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__0__Impl"


    // $ANTLR start "rule__ParserRule__Group__1"
    // InternalXtext.g:3414:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3418:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // InternalXtext.g:3419:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__ParserRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__1"


    // $ANTLR start "rule__ParserRule__Group__1__Impl"
    // InternalXtext.g:3426:1: rule__ParserRule__Group__1__Impl : ( ( rule__ParserRule__Alternatives_1 ) ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3430:1: ( ( ( rule__ParserRule__Alternatives_1 ) ) )
            // InternalXtext.g:3431:1: ( ( rule__ParserRule__Alternatives_1 ) )
            {
            // InternalXtext.g:3431:1: ( ( rule__ParserRule__Alternatives_1 ) )
            // InternalXtext.g:3432:2: ( rule__ParserRule__Alternatives_1 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_1()); 
            // InternalXtext.g:3433:2: ( rule__ParserRule__Alternatives_1 )
            // InternalXtext.g:3433:3: rule__ParserRule__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__2"
    // InternalXtext.g:3441:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3445:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // InternalXtext.g:3446:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__ParserRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__2"


    // $ANTLR start "rule__ParserRule__Group__2__Impl"
    // InternalXtext.g:3453:1: rule__ParserRule__Group__2__Impl : ( ( rule__ParserRule__Group_2__0 )? ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3457:1: ( ( ( rule__ParserRule__Group_2__0 )? ) )
            // InternalXtext.g:3458:1: ( ( rule__ParserRule__Group_2__0 )? )
            {
            // InternalXtext.g:3458:1: ( ( rule__ParserRule__Group_2__0 )? )
            // InternalXtext.g:3459:2: ( rule__ParserRule__Group_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2()); 
            // InternalXtext.g:3460:2: ( rule__ParserRule__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==52) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalXtext.g:3460:3: rule__ParserRule__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__2__Impl"


    // $ANTLR start "rule__ParserRule__Group__3"
    // InternalXtext.g:3468:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3472:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // InternalXtext.g:3473:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__ParserRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__3"


    // $ANTLR start "rule__ParserRule__Group__3__Impl"
    // InternalXtext.g:3480:1: rule__ParserRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3484:1: ( ( ':' ) )
            // InternalXtext.g:3485:1: ( ':' )
            {
            // InternalXtext.g:3485:1: ( ':' )
            // InternalXtext.g:3486:2: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__3__Impl"


    // $ANTLR start "rule__ParserRule__Group__4"
    // InternalXtext.g:3495:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3499:1: ( rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5 )
            // InternalXtext.g:3500:2: rule__ParserRule__Group__4__Impl rule__ParserRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__ParserRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__4"


    // $ANTLR start "rule__ParserRule__Group__4__Impl"
    // InternalXtext.g:3507:1: rule__ParserRule__Group__4__Impl : ( ( rule__ParserRule__AlternativesAssignment_4 ) ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3511:1: ( ( ( rule__ParserRule__AlternativesAssignment_4 ) ) )
            // InternalXtext.g:3512:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            {
            // InternalXtext.g:3512:1: ( ( rule__ParserRule__AlternativesAssignment_4 ) )
            // InternalXtext.g:3513:2: ( rule__ParserRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtext.g:3514:2: ( rule__ParserRule__AlternativesAssignment_4 )
            // InternalXtext.g:3514:3: rule__ParserRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__AlternativesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__4__Impl"


    // $ANTLR start "rule__ParserRule__Group__5"
    // InternalXtext.g:3522:1: rule__ParserRule__Group__5 : rule__ParserRule__Group__5__Impl ;
    public final void rule__ParserRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3526:1: ( rule__ParserRule__Group__5__Impl )
            // InternalXtext.g:3527:2: rule__ParserRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__5"


    // $ANTLR start "rule__ParserRule__Group__5__Impl"
    // InternalXtext.g:3533:1: rule__ParserRule__Group__5__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3537:1: ( ( ';' ) )
            // InternalXtext.g:3538:1: ( ';' )
            {
            // InternalXtext.g:3538:1: ( ';' )
            // InternalXtext.g:3539:2: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__5__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0__0"
    // InternalXtext.g:3549:1: rule__ParserRule__Group_1_0__0 : rule__ParserRule__Group_1_0__0__Impl rule__ParserRule__Group_1_0__1 ;
    public final void rule__ParserRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3553:1: ( rule__ParserRule__Group_1_0__0__Impl rule__ParserRule__Group_1_0__1 )
            // InternalXtext.g:3554:2: rule__ParserRule__Group_1_0__0__Impl rule__ParserRule__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__ParserRule__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__0"


    // $ANTLR start "rule__ParserRule__Group_1_0__0__Impl"
    // InternalXtext.g:3561:1: rule__ParserRule__Group_1_0__0__Impl : ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) ) ;
    public final void rule__ParserRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3565:1: ( ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) ) )
            // InternalXtext.g:3566:1: ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) )
            {
            // InternalXtext.g:3566:1: ( ( rule__ParserRule__FragmentAssignment_1_0_0 ) )
            // InternalXtext.g:3567:2: ( rule__ParserRule__FragmentAssignment_1_0_0 )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0()); 
            // InternalXtext.g:3568:2: ( rule__ParserRule__FragmentAssignment_1_0_0 )
            // InternalXtext.g:3568:3: rule__ParserRule__FragmentAssignment_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__FragmentAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0__1"
    // InternalXtext.g:3576:1: rule__ParserRule__Group_1_0__1 : rule__ParserRule__Group_1_0__1__Impl rule__ParserRule__Group_1_0__2 ;
    public final void rule__ParserRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3580:1: ( rule__ParserRule__Group_1_0__1__Impl rule__ParserRule__Group_1_0__2 )
            // InternalXtext.g:3581:2: rule__ParserRule__Group_1_0__1__Impl rule__ParserRule__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__ParserRule__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__1"


    // $ANTLR start "rule__ParserRule__Group_1_0__1__Impl"
    // InternalXtext.g:3588:1: rule__ParserRule__Group_1_0__1__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3592:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtext.g:3593:1: ( ruleRuleNameAndParams )
            {
            // InternalXtext.g:3593:1: ( ruleRuleNameAndParams )
            // InternalXtext.g:3594:2: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0__2"
    // InternalXtext.g:3603:1: rule__ParserRule__Group_1_0__2 : rule__ParserRule__Group_1_0__2__Impl ;
    public final void rule__ParserRule__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3607:1: ( rule__ParserRule__Group_1_0__2__Impl )
            // InternalXtext.g:3608:2: rule__ParserRule__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__2"


    // $ANTLR start "rule__ParserRule__Group_1_0__2__Impl"
    // InternalXtext.g:3614:1: rule__ParserRule__Group_1_0__2__Impl : ( ( rule__ParserRule__Alternatives_1_0_2 ) ) ;
    public final void rule__ParserRule__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3618:1: ( ( ( rule__ParserRule__Alternatives_1_0_2 ) ) )
            // InternalXtext.g:3619:1: ( ( rule__ParserRule__Alternatives_1_0_2 ) )
            {
            // InternalXtext.g:3619:1: ( ( rule__ParserRule__Alternatives_1_0_2 ) )
            // InternalXtext.g:3620:2: ( rule__ParserRule__Alternatives_1_0_2 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2()); 
            // InternalXtext.g:3621:2: ( rule__ParserRule__Alternatives_1_0_2 )
            // InternalXtext.g:3621:3: rule__ParserRule__Alternatives_1_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__0"
    // InternalXtext.g:3630:1: rule__ParserRule__Group_1_0_2_1__0 : rule__ParserRule__Group_1_0_2_1__0__Impl rule__ParserRule__Group_1_0_2_1__1 ;
    public final void rule__ParserRule__Group_1_0_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3634:1: ( rule__ParserRule__Group_1_0_2_1__0__Impl rule__ParserRule__Group_1_0_2_1__1 )
            // InternalXtext.g:3635:2: rule__ParserRule__Group_1_0_2_1__0__Impl rule__ParserRule__Group_1_0_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__ParserRule__Group_1_0_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__0__Impl"
    // InternalXtext.g:3642:1: rule__ParserRule__Group_1_0_2_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1_0_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3646:1: ( ( 'returns' ) )
            // InternalXtext.g:3647:1: ( 'returns' )
            {
            // InternalXtext.g:3647:1: ( 'returns' )
            // InternalXtext.g:3648:2: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__1"
    // InternalXtext.g:3657:1: rule__ParserRule__Group_1_0_2_1__1 : rule__ParserRule__Group_1_0_2_1__1__Impl ;
    public final void rule__ParserRule__Group_1_0_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3661:1: ( rule__ParserRule__Group_1_0_2_1__1__Impl )
            // InternalXtext.g:3662:2: rule__ParserRule__Group_1_0_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_0_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_0_2_1__1__Impl"
    // InternalXtext.g:3668:1: rule__ParserRule__Group_1_0_2_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_1_0_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3672:1: ( ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) ) )
            // InternalXtext.g:3673:1: ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) )
            {
            // InternalXtext.g:3673:1: ( ( rule__ParserRule__TypeAssignment_1_0_2_1_1 ) )
            // InternalXtext.g:3674:2: ( rule__ParserRule__TypeAssignment_1_0_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1()); 
            // InternalXtext.g:3675:2: ( rule__ParserRule__TypeAssignment_1_0_2_1_1 )
            // InternalXtext.g:3675:3: rule__ParserRule__TypeAssignment_1_0_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__TypeAssignment_1_0_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_0_2_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1__0"
    // InternalXtext.g:3684:1: rule__ParserRule__Group_1_1__0 : rule__ParserRule__Group_1_1__0__Impl rule__ParserRule__Group_1_1__1 ;
    public final void rule__ParserRule__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3688:1: ( rule__ParserRule__Group_1_1__0__Impl rule__ParserRule__Group_1_1__1 )
            // InternalXtext.g:3689:2: rule__ParserRule__Group_1_1__0__Impl rule__ParserRule__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__ParserRule__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_1__0__Impl"
    // InternalXtext.g:3696:1: rule__ParserRule__Group_1_1__0__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3700:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtext.g:3701:1: ( ruleRuleNameAndParams )
            {
            // InternalXtext.g:3701:1: ( ruleRuleNameAndParams )
            // InternalXtext.g:3702:2: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1__1"
    // InternalXtext.g:3711:1: rule__ParserRule__Group_1_1__1 : rule__ParserRule__Group_1_1__1__Impl ;
    public final void rule__ParserRule__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3715:1: ( rule__ParserRule__Group_1_1__1__Impl )
            // InternalXtext.g:3716:2: rule__ParserRule__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_1__1__Impl"
    // InternalXtext.g:3722:1: rule__ParserRule__Group_1_1__1__Impl : ( ( rule__ParserRule__Group_1_1_1__0 )? ) ;
    public final void rule__ParserRule__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3726:1: ( ( ( rule__ParserRule__Group_1_1_1__0 )? ) )
            // InternalXtext.g:3727:1: ( ( rule__ParserRule__Group_1_1_1__0 )? )
            {
            // InternalXtext.g:3727:1: ( ( rule__ParserRule__Group_1_1_1__0 )? )
            // InternalXtext.g:3728:2: ( rule__ParserRule__Group_1_1_1__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_1_1_1()); 
            // InternalXtext.g:3729:2: ( rule__ParserRule__Group_1_1_1__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==34) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXtext.g:3729:3: rule__ParserRule__Group_1_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__0"
    // InternalXtext.g:3738:1: rule__ParserRule__Group_1_1_1__0 : rule__ParserRule__Group_1_1_1__0__Impl rule__ParserRule__Group_1_1_1__1 ;
    public final void rule__ParserRule__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3742:1: ( rule__ParserRule__Group_1_1_1__0__Impl rule__ParserRule__Group_1_1_1__1 )
            // InternalXtext.g:3743:2: rule__ParserRule__Group_1_1_1__0__Impl rule__ParserRule__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__ParserRule__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__0"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__0__Impl"
    // InternalXtext.g:3750:1: rule__ParserRule__Group_1_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__ParserRule__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3754:1: ( ( 'returns' ) )
            // InternalXtext.g:3755:1: ( 'returns' )
            {
            // InternalXtext.g:3755:1: ( 'returns' )
            // InternalXtext.g:3756:2: 'returns'
            {
             before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__1"
    // InternalXtext.g:3765:1: rule__ParserRule__Group_1_1_1__1 : rule__ParserRule__Group_1_1_1__1__Impl ;
    public final void rule__ParserRule__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3769:1: ( rule__ParserRule__Group_1_1_1__1__Impl )
            // InternalXtext.g:3770:2: rule__ParserRule__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__1"


    // $ANTLR start "rule__ParserRule__Group_1_1_1__1__Impl"
    // InternalXtext.g:3776:1: rule__ParserRule__Group_1_1_1__1__Impl : ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) ) ;
    public final void rule__ParserRule__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3780:1: ( ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) ) )
            // InternalXtext.g:3781:1: ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) )
            {
            // InternalXtext.g:3781:1: ( ( rule__ParserRule__TypeAssignment_1_1_1_1 ) )
            // InternalXtext.g:3782:2: ( rule__ParserRule__TypeAssignment_1_1_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1()); 
            // InternalXtext.g:3783:2: ( rule__ParserRule__TypeAssignment_1_1_1_1 )
            // InternalXtext.g:3783:3: rule__ParserRule__TypeAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__TypeAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__0"
    // InternalXtext.g:3792:1: rule__ParserRule__Group_2__0 : rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 ;
    public final void rule__ParserRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3796:1: ( rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1 )
            // InternalXtext.g:3797:2: rule__ParserRule__Group_2__0__Impl rule__ParserRule__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ParserRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__0"


    // $ANTLR start "rule__ParserRule__Group_2__0__Impl"
    // InternalXtext.g:3804:1: rule__ParserRule__Group_2__0__Impl : ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) ;
    public final void rule__ParserRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3808:1: ( ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) ) )
            // InternalXtext.g:3809:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            {
            // InternalXtext.g:3809:1: ( ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 ) )
            // InternalXtext.g:3810:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 
            // InternalXtext.g:3811:2: ( rule__ParserRule__DefinesHiddenTokensAssignment_2_0 )
            // InternalXtext.g:3811:3: rule__ParserRule__DefinesHiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__DefinesHiddenTokensAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__1"
    // InternalXtext.g:3819:1: rule__ParserRule__Group_2__1 : rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 ;
    public final void rule__ParserRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3823:1: ( rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2 )
            // InternalXtext.g:3824:2: rule__ParserRule__Group_2__1__Impl rule__ParserRule__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ParserRule__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__1"


    // $ANTLR start "rule__ParserRule__Group_2__1__Impl"
    // InternalXtext.g:3831:1: rule__ParserRule__Group_2__1__Impl : ( '(' ) ;
    public final void rule__ParserRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3835:1: ( ( '(' ) )
            // InternalXtext.g:3836:1: ( '(' )
            {
            // InternalXtext.g:3836:1: ( '(' )
            // InternalXtext.g:3837:2: '('
            {
             before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__2"
    // InternalXtext.g:3846:1: rule__ParserRule__Group_2__2 : rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 ;
    public final void rule__ParserRule__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3850:1: ( rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3 )
            // InternalXtext.g:3851:2: rule__ParserRule__Group_2__2__Impl rule__ParserRule__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ParserRule__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__2"


    // $ANTLR start "rule__ParserRule__Group_2__2__Impl"
    // InternalXtext.g:3858:1: rule__ParserRule__Group_2__2__Impl : ( ( rule__ParserRule__Group_2_2__0 )? ) ;
    public final void rule__ParserRule__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3862:1: ( ( ( rule__ParserRule__Group_2_2__0 )? ) )
            // InternalXtext.g:3863:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            {
            // InternalXtext.g:3863:1: ( ( rule__ParserRule__Group_2_2__0 )? )
            // InternalXtext.g:3864:2: ( rule__ParserRule__Group_2_2__0 )?
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2()); 
            // InternalXtext.g:3865:2: ( rule__ParserRule__Group_2_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||(LA41_0>=17 && LA41_0<=18)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXtext.g:3865:3: rule__ParserRule__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_2__3"
    // InternalXtext.g:3873:1: rule__ParserRule__Group_2__3 : rule__ParserRule__Group_2__3__Impl ;
    public final void rule__ParserRule__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3877:1: ( rule__ParserRule__Group_2__3__Impl )
            // InternalXtext.g:3878:2: rule__ParserRule__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__3"


    // $ANTLR start "rule__ParserRule__Group_2__3__Impl"
    // InternalXtext.g:3884:1: rule__ParserRule__Group_2__3__Impl : ( ')' ) ;
    public final void rule__ParserRule__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3888:1: ( ( ')' ) )
            // InternalXtext.g:3889:1: ( ')' )
            {
            // InternalXtext.g:3889:1: ( ')' )
            // InternalXtext.g:3890:2: ')'
            {
             before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2__3__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2__0"
    // InternalXtext.g:3900:1: rule__ParserRule__Group_2_2__0 : rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 ;
    public final void rule__ParserRule__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3904:1: ( rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1 )
            // InternalXtext.g:3905:2: rule__ParserRule__Group_2_2__0__Impl rule__ParserRule__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__ParserRule__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2__0"


    // $ANTLR start "rule__ParserRule__Group_2_2__0__Impl"
    // InternalXtext.g:3912:1: rule__ParserRule__Group_2_2__0__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) ;
    public final void rule__ParserRule__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3916:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) ) )
            // InternalXtext.g:3917:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            {
            // InternalXtext.g:3917:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_0 ) )
            // InternalXtext.g:3918:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 
            // InternalXtext.g:3919:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_0 )
            // InternalXtext.g:3919:3: rule__ParserRule__HiddenTokensAssignment_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__HiddenTokensAssignment_2_2_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2__1"
    // InternalXtext.g:3927:1: rule__ParserRule__Group_2_2__1 : rule__ParserRule__Group_2_2__1__Impl ;
    public final void rule__ParserRule__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3931:1: ( rule__ParserRule__Group_2_2__1__Impl )
            // InternalXtext.g:3932:2: rule__ParserRule__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2__1"


    // $ANTLR start "rule__ParserRule__Group_2_2__1__Impl"
    // InternalXtext.g:3938:1: rule__ParserRule__Group_2_2__1__Impl : ( ( rule__ParserRule__Group_2_2_1__0 )* ) ;
    public final void rule__ParserRule__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3942:1: ( ( ( rule__ParserRule__Group_2_2_1__0 )* ) )
            // InternalXtext.g:3943:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            {
            // InternalXtext.g:3943:1: ( ( rule__ParserRule__Group_2_2_1__0 )* )
            // InternalXtext.g:3944:2: ( rule__ParserRule__Group_2_2_1__0 )*
            {
             before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 
            // InternalXtext.g:3945:2: ( rule__ParserRule__Group_2_2_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==22) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalXtext.g:3945:3: rule__ParserRule__Group_2_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__ParserRule__Group_2_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__0"
    // InternalXtext.g:3954:1: rule__ParserRule__Group_2_2_1__0 : rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 ;
    public final void rule__ParserRule__Group_2_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3958:1: ( rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1 )
            // InternalXtext.g:3959:2: rule__ParserRule__Group_2_2_1__0__Impl rule__ParserRule__Group_2_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ParserRule__Group_2_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2_1__0"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__0__Impl"
    // InternalXtext.g:3966:1: rule__ParserRule__Group_2_2_1__0__Impl : ( ',' ) ;
    public final void rule__ParserRule__Group_2_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3970:1: ( ( ',' ) )
            // InternalXtext.g:3971:1: ( ',' )
            {
            // InternalXtext.g:3971:1: ( ',' )
            // InternalXtext.g:3972:2: ','
            {
             before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__1"
    // InternalXtext.g:3981:1: rule__ParserRule__Group_2_2_1__1 : rule__ParserRule__Group_2_2_1__1__Impl ;
    public final void rule__ParserRule__Group_2_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3985:1: ( rule__ParserRule__Group_2_2_1__1__Impl )
            // InternalXtext.g:3986:2: rule__ParserRule__Group_2_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_2_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2_1__1"


    // $ANTLR start "rule__ParserRule__Group_2_2_1__1__Impl"
    // InternalXtext.g:3992:1: rule__ParserRule__Group_2_2_1__1__Impl : ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) ;
    public final void rule__ParserRule__Group_2_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:3996:1: ( ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) ) )
            // InternalXtext.g:3997:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            {
            // InternalXtext.g:3997:1: ( ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 ) )
            // InternalXtext.g:3998:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 
            // InternalXtext.g:3999:2: ( rule__ParserRule__HiddenTokensAssignment_2_2_1_1 )
            // InternalXtext.g:3999:3: rule__ParserRule__HiddenTokensAssignment_2_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__HiddenTokensAssignment_2_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_2_2_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group__0"
    // InternalXtext.g:4008:1: rule__RuleNameAndParams__Group__0 : rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 ;
    public final void rule__RuleNameAndParams__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4012:1: ( rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 )
            // InternalXtext.g:4013:2: rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__RuleNameAndParams__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__0"


    // $ANTLR start "rule__RuleNameAndParams__Group__0__Impl"
    // InternalXtext.g:4020:1: rule__RuleNameAndParams__Group__0__Impl : ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) ;
    public final void rule__RuleNameAndParams__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4024:1: ( ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) )
            // InternalXtext.g:4025:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            {
            // InternalXtext.g:4025:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            // InternalXtext.g:4026:2: ( rule__RuleNameAndParams__NameAssignment_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 
            // InternalXtext.g:4027:2: ( rule__RuleNameAndParams__NameAssignment_0 )
            // InternalXtext.g:4027:3: rule__RuleNameAndParams__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group__1"
    // InternalXtext.g:4035:1: rule__RuleNameAndParams__Group__1 : rule__RuleNameAndParams__Group__1__Impl ;
    public final void rule__RuleNameAndParams__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4039:1: ( rule__RuleNameAndParams__Group__1__Impl )
            // InternalXtext.g:4040:2: rule__RuleNameAndParams__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__1"


    // $ANTLR start "rule__RuleNameAndParams__Group__1__Impl"
    // InternalXtext.g:4046:1: rule__RuleNameAndParams__Group__1__Impl : ( ( rule__RuleNameAndParams__Group_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4050:1: ( ( ( rule__RuleNameAndParams__Group_1__0 )? ) )
            // InternalXtext.g:4051:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            {
            // InternalXtext.g:4051:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            // InternalXtext.g:4052:2: ( rule__RuleNameAndParams__Group_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 
            // InternalXtext.g:4053:2: ( rule__RuleNameAndParams__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==35) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXtext.g:4053:3: rule__RuleNameAndParams__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleNameAndParams__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__0"
    // InternalXtext.g:4062:1: rule__RuleNameAndParams__Group_1__0 : rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 ;
    public final void rule__RuleNameAndParams__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4066:1: ( rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 )
            // InternalXtext.g:4067:2: rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__RuleNameAndParams__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__0__Impl"
    // InternalXtext.g:4074:1: rule__RuleNameAndParams__Group_1__0__Impl : ( '<' ) ;
    public final void rule__RuleNameAndParams__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4078:1: ( ( '<' ) )
            // InternalXtext.g:4079:1: ( '<' )
            {
            // InternalXtext.g:4079:1: ( '<' )
            // InternalXtext.g:4080:2: '<'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__1"
    // InternalXtext.g:4089:1: rule__RuleNameAndParams__Group_1__1 : rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 ;
    public final void rule__RuleNameAndParams__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4093:1: ( rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 )
            // InternalXtext.g:4094:2: rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__RuleNameAndParams__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__1__Impl"
    // InternalXtext.g:4101:1: rule__RuleNameAndParams__Group_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4105:1: ( ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) )
            // InternalXtext.g:4106:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            {
            // InternalXtext.g:4106:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            // InternalXtext.g:4107:2: ( rule__RuleNameAndParams__Group_1_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 
            // InternalXtext.g:4108:2: ( rule__RuleNameAndParams__Group_1_1__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalXtext.g:4108:3: rule__RuleNameAndParams__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleNameAndParams__Group_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__2"
    // InternalXtext.g:4116:1: rule__RuleNameAndParams__Group_1__2 : rule__RuleNameAndParams__Group_1__2__Impl ;
    public final void rule__RuleNameAndParams__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4120:1: ( rule__RuleNameAndParams__Group_1__2__Impl )
            // InternalXtext.g:4121:2: rule__RuleNameAndParams__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__2"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__2__Impl"
    // InternalXtext.g:4127:1: rule__RuleNameAndParams__Group_1__2__Impl : ( '>' ) ;
    public final void rule__RuleNameAndParams__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4131:1: ( ( '>' ) )
            // InternalXtext.g:4132:1: ( '>' )
            {
            // InternalXtext.g:4132:1: ( '>' )
            // InternalXtext.g:4133:2: '>'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); 
            match(input,36,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__2__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__0"
    // InternalXtext.g:4143:1: rule__RuleNameAndParams__Group_1_1__0 : rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4147:1: ( rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 )
            // InternalXtext.g:4148:2: rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__RuleNameAndParams__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__0__Impl"
    // InternalXtext.g:4155:1: rule__RuleNameAndParams__Group_1_1__0__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4159:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) )
            // InternalXtext.g:4160:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            {
            // InternalXtext.g:4160:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            // InternalXtext.g:4161:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 
            // InternalXtext.g:4162:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            // InternalXtext.g:4162:3: rule__RuleNameAndParams__ParametersAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__ParametersAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__1"
    // InternalXtext.g:4170:1: rule__RuleNameAndParams__Group_1_1__1 : rule__RuleNameAndParams__Group_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4174:1: ( rule__RuleNameAndParams__Group_1_1__1__Impl )
            // InternalXtext.g:4175:2: rule__RuleNameAndParams__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__1__Impl"
    // InternalXtext.g:4181:1: rule__RuleNameAndParams__Group_1_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) ;
    public final void rule__RuleNameAndParams__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4185:1: ( ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) )
            // InternalXtext.g:4186:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            {
            // InternalXtext.g:4186:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            // InternalXtext.g:4187:2: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 
            // InternalXtext.g:4188:2: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==22) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalXtext.g:4188:3: rule__RuleNameAndParams__Group_1_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__RuleNameAndParams__Group_1_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__0"
    // InternalXtext.g:4197:1: rule__RuleNameAndParams__Group_1_1_1__0 : rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4201:1: ( rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 )
            // InternalXtext.g:4202:2: rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__RuleNameAndParams__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__0__Impl"
    // InternalXtext.g:4209:1: rule__RuleNameAndParams__Group_1_1_1__0__Impl : ( ',' ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4213:1: ( ( ',' ) )
            // InternalXtext.g:4214:1: ( ',' )
            {
            // InternalXtext.g:4214:1: ( ',' )
            // InternalXtext.g:4215:2: ','
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__1"
    // InternalXtext.g:4224:1: rule__RuleNameAndParams__Group_1_1_1__1 : rule__RuleNameAndParams__Group_1_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4228:1: ( rule__RuleNameAndParams__Group_1_1_1__1__Impl )
            // InternalXtext.g:4229:2: rule__RuleNameAndParams__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__1__Impl"
    // InternalXtext.g:4235:1: rule__RuleNameAndParams__Group_1_1_1__1__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4239:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) )
            // InternalXtext.g:4240:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            {
            // InternalXtext.g:4240:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            // InternalXtext.g:4241:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 
            // InternalXtext.g:4242:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            // InternalXtext.g:4242:3: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__ParametersAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__TypeRef__Group__0"
    // InternalXtext.g:4251:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4255:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalXtext.g:4256:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__TypeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__0"


    // $ANTLR start "rule__TypeRef__Group__0__Impl"
    // InternalXtext.g:4263:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4267:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // InternalXtext.g:4268:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // InternalXtext.g:4268:1: ( ( rule__TypeRef__Group_0__0 )? )
            // InternalXtext.g:4269:2: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // InternalXtext.g:4270:2: ( rule__TypeRef__Group_0__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==37) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalXtext.g:4270:3: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TypeRef__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__0__Impl"


    // $ANTLR start "rule__TypeRef__Group__1"
    // InternalXtext.g:4278:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4282:1: ( rule__TypeRef__Group__1__Impl )
            // InternalXtext.g:4283:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__1"


    // $ANTLR start "rule__TypeRef__Group__1__Impl"
    // InternalXtext.g:4289:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4293:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // InternalXtext.g:4294:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // InternalXtext.g:4294:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // InternalXtext.g:4295:2: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // InternalXtext.g:4296:2: ( rule__TypeRef__ClassifierAssignment_1 )
            // InternalXtext.g:4296:3: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__ClassifierAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__1__Impl"


    // $ANTLR start "rule__TypeRef__Group_0__0"
    // InternalXtext.g:4305:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4309:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // InternalXtext.g:4310:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__TypeRef__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__0"


    // $ANTLR start "rule__TypeRef__Group_0__0__Impl"
    // InternalXtext.g:4317:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4321:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // InternalXtext.g:4322:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // InternalXtext.g:4322:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // InternalXtext.g:4323:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // InternalXtext.g:4324:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // InternalXtext.g:4324:3: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__MetamodelAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__0__Impl"


    // $ANTLR start "rule__TypeRef__Group_0__1"
    // InternalXtext.g:4332:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4336:1: ( rule__TypeRef__Group_0__1__Impl )
            // InternalXtext.g:4337:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__1"


    // $ANTLR start "rule__TypeRef__Group_0__1__Impl"
    // InternalXtext.g:4343:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4347:1: ( ( '::' ) )
            // InternalXtext.g:4348:1: ( '::' )
            {
            // InternalXtext.g:4348:1: ( '::' )
            // InternalXtext.g:4349:2: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,37,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__1__Impl"


    // $ANTLR start "rule__Alternatives__Group__0"
    // InternalXtext.g:4359:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4363:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // InternalXtext.g:4364:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Alternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__0"


    // $ANTLR start "rule__Alternatives__Group__0__Impl"
    // InternalXtext.g:4371:1: rule__Alternatives__Group__0__Impl : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4375:1: ( ( ruleConditionalBranch ) )
            // InternalXtext.g:4376:1: ( ruleConditionalBranch )
            {
            // InternalXtext.g:4376:1: ( ruleConditionalBranch )
            // InternalXtext.g:4377:2: ruleConditionalBranch
            {
             before(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__0__Impl"


    // $ANTLR start "rule__Alternatives__Group__1"
    // InternalXtext.g:4386:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4390:1: ( rule__Alternatives__Group__1__Impl )
            // InternalXtext.g:4391:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__1"


    // $ANTLR start "rule__Alternatives__Group__1__Impl"
    // InternalXtext.g:4397:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4401:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // InternalXtext.g:4402:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // InternalXtext.g:4402:1: ( ( rule__Alternatives__Group_1__0 )? )
            // InternalXtext.g:4403:2: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:4404:2: ( rule__Alternatives__Group_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==38) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXtext.g:4404:3: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Alternatives__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativesAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__0"
    // InternalXtext.g:4413:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4417:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // InternalXtext.g:4418:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Alternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__0"


    // $ANTLR start "rule__Alternatives__Group_1__0__Impl"
    // InternalXtext.g:4425:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4429:1: ( ( () ) )
            // InternalXtext.g:4430:1: ( () )
            {
            // InternalXtext.g:4430:1: ( () )
            // InternalXtext.g:4431:2: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:4432:2: ()
            // InternalXtext.g:4432:3: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__1"
    // InternalXtext.g:4440:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4444:1: ( rule__Alternatives__Group_1__1__Impl )
            // InternalXtext.g:4445:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__1"


    // $ANTLR start "rule__Alternatives__Group_1__1__Impl"
    // InternalXtext.g:4451:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4455:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:4456:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:4456:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:4457:2: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:4457:2: ( ( rule__Alternatives__Group_1_1__0 ) )
            // InternalXtext.g:4458:3: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:4459:3: ( rule__Alternatives__Group_1_1__0 )
            // InternalXtext.g:4459:4: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:4462:2: ( ( rule__Alternatives__Group_1_1__0 )* )
            // InternalXtext.g:4463:3: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:4464:3: ( rule__Alternatives__Group_1_1__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==38) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalXtext.g:4464:4: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__Alternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__0"
    // InternalXtext.g:4474:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4478:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // InternalXtext.g:4479:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__Alternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__0"


    // $ANTLR start "rule__Alternatives__Group_1_1__0__Impl"
    // InternalXtext.g:4486:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4490:1: ( ( '|' ) )
            // InternalXtext.g:4491:1: ( '|' )
            {
            // InternalXtext.g:4491:1: ( '|' )
            // InternalXtext.g:4492:2: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__1"
    // InternalXtext.g:4501:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4505:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // InternalXtext.g:4506:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__1"


    // $ANTLR start "rule__Alternatives__Group_1_1__1__Impl"
    // InternalXtext.g:4512:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4516:1: ( ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:4517:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:4517:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:4518:2: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:4519:2: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:4519:3: rule__Alternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__0"
    // InternalXtext.g:4528:1: rule__ConditionalBranch__Group_1__0 : rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 ;
    public final void rule__ConditionalBranch__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4532:1: ( rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 )
            // InternalXtext.g:4533:2: rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__ConditionalBranch__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__0"


    // $ANTLR start "rule__ConditionalBranch__Group_1__0__Impl"
    // InternalXtext.g:4540:1: rule__ConditionalBranch__Group_1__0__Impl : ( () ) ;
    public final void rule__ConditionalBranch__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4544:1: ( ( () ) )
            // InternalXtext.g:4545:1: ( () )
            {
            // InternalXtext.g:4545:1: ( () )
            // InternalXtext.g:4546:2: ()
            {
             before(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); 
            // InternalXtext.g:4547:2: ()
            // InternalXtext.g:4547:3: 
            {
            }

             after(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__0__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__1"
    // InternalXtext.g:4555:1: rule__ConditionalBranch__Group_1__1 : rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 ;
    public final void rule__ConditionalBranch__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4559:1: ( rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 )
            // InternalXtext.g:4560:2: rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__ConditionalBranch__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__1"


    // $ANTLR start "rule__ConditionalBranch__Group_1__1__Impl"
    // InternalXtext.g:4567:1: rule__ConditionalBranch__Group_1__1__Impl : ( '<' ) ;
    public final void rule__ConditionalBranch__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4571:1: ( ( '<' ) )
            // InternalXtext.g:4572:1: ( '<' )
            {
            // InternalXtext.g:4572:1: ( '<' )
            // InternalXtext.g:4573:2: '<'
            {
             before(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); 
            match(input,35,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__1__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__2"
    // InternalXtext.g:4582:1: rule__ConditionalBranch__Group_1__2 : rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 ;
    public final void rule__ConditionalBranch__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4586:1: ( rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 )
            // InternalXtext.g:4587:2: rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_32);
            rule__ConditionalBranch__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__2"


    // $ANTLR start "rule__ConditionalBranch__Group_1__2__Impl"
    // InternalXtext.g:4594:1: rule__ConditionalBranch__Group_1__2__Impl : ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) ) ;
    public final void rule__ConditionalBranch__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4598:1: ( ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) ) )
            // InternalXtext.g:4599:1: ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) )
            {
            // InternalXtext.g:4599:1: ( ( rule__ConditionalBranch__GuardConditionAssignment_1_2 ) )
            // InternalXtext.g:4600:2: ( rule__ConditionalBranch__GuardConditionAssignment_1_2 )
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); 
            // InternalXtext.g:4601:2: ( rule__ConditionalBranch__GuardConditionAssignment_1_2 )
            // InternalXtext.g:4601:3: rule__ConditionalBranch__GuardConditionAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__GuardConditionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__2__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__3"
    // InternalXtext.g:4609:1: rule__ConditionalBranch__Group_1__3 : rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 ;
    public final void rule__ConditionalBranch__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4613:1: ( rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 )
            // InternalXtext.g:4614:2: rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__ConditionalBranch__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__3"


    // $ANTLR start "rule__ConditionalBranch__Group_1__3__Impl"
    // InternalXtext.g:4621:1: rule__ConditionalBranch__Group_1__3__Impl : ( '>' ) ;
    public final void rule__ConditionalBranch__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4625:1: ( ( '>' ) )
            // InternalXtext.g:4626:1: ( '>' )
            {
            // InternalXtext.g:4626:1: ( '>' )
            // InternalXtext.g:4627:2: '>'
            {
             before(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,36,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__3__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__4"
    // InternalXtext.g:4636:1: rule__ConditionalBranch__Group_1__4 : rule__ConditionalBranch__Group_1__4__Impl ;
    public final void rule__ConditionalBranch__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4640:1: ( rule__ConditionalBranch__Group_1__4__Impl )
            // InternalXtext.g:4641:2: rule__ConditionalBranch__Group_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__4"


    // $ANTLR start "rule__ConditionalBranch__Group_1__4__Impl"
    // InternalXtext.g:4647:1: rule__ConditionalBranch__Group_1__4__Impl : ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) ) ;
    public final void rule__ConditionalBranch__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4651:1: ( ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) ) )
            // InternalXtext.g:4652:1: ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) )
            {
            // InternalXtext.g:4652:1: ( ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* ) )
            // InternalXtext.g:4653:2: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) ) ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* )
            {
            // InternalXtext.g:4653:2: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 ) )
            // InternalXtext.g:4654:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 
            // InternalXtext.g:4655:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )
            // InternalXtext.g:4655:4: rule__ConditionalBranch__ElementsAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_34);
            rule__ConditionalBranch__ElementsAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 

            }

            // InternalXtext.g:4658:2: ( ( rule__ConditionalBranch__ElementsAssignment_1_4 )* )
            // InternalXtext.g:4659:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )*
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 
            // InternalXtext.g:4660:3: ( rule__ConditionalBranch__ElementsAssignment_1_4 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID||(LA49_0>=RULE_STRING && LA49_0<=RULE_JAVACODESTRING)||(LA49_0>=17 && LA49_0<=18)||LA49_0==23||LA49_0==41||LA49_0==48||LA49_0==55) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalXtext.g:4660:4: rule__ConditionalBranch__ElementsAssignment_1_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_34);
            	    rule__ConditionalBranch__ElementsAssignment_1_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__4__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__0"
    // InternalXtext.g:4670:1: rule__UnorderedGroup__Group__0 : rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4674:1: ( rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 )
            // InternalXtext.g:4675:2: rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_35);
            rule__UnorderedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__0"


    // $ANTLR start "rule__UnorderedGroup__Group__0__Impl"
    // InternalXtext.g:4682:1: rule__UnorderedGroup__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4686:1: ( ( ruleGroup ) )
            // InternalXtext.g:4687:1: ( ruleGroup )
            {
            // InternalXtext.g:4687:1: ( ruleGroup )
            // InternalXtext.g:4688:2: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__1"
    // InternalXtext.g:4697:1: rule__UnorderedGroup__Group__1 : rule__UnorderedGroup__Group__1__Impl ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4701:1: ( rule__UnorderedGroup__Group__1__Impl )
            // InternalXtext.g:4702:2: rule__UnorderedGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__1"


    // $ANTLR start "rule__UnorderedGroup__Group__1__Impl"
    // InternalXtext.g:4708:1: rule__UnorderedGroup__Group__1__Impl : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4712:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // InternalXtext.g:4713:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // InternalXtext.g:4713:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // InternalXtext.g:4714:2: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // InternalXtext.g:4715:2: ( rule__UnorderedGroup__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==39) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXtext.g:4715:3: rule__UnorderedGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedGroup__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1__0"
    // InternalXtext.g:4724:1: rule__UnorderedGroup__Group_1__0 : rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4728:1: ( rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 )
            // InternalXtext.g:4729:2: rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_35);
            rule__UnorderedGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__0"


    // $ANTLR start "rule__UnorderedGroup__Group_1__0__Impl"
    // InternalXtext.g:4736:1: rule__UnorderedGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__UnorderedGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4740:1: ( ( () ) )
            // InternalXtext.g:4741:1: ( () )
            {
            // InternalXtext.g:4741:1: ( () )
            // InternalXtext.g:4742:2: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // InternalXtext.g:4743:2: ()
            // InternalXtext.g:4743:3: 
            {
            }

             after(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1__1"
    // InternalXtext.g:4751:1: rule__UnorderedGroup__Group_1__1 : rule__UnorderedGroup__Group_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4755:1: ( rule__UnorderedGroup__Group_1__1__Impl )
            // InternalXtext.g:4756:2: rule__UnorderedGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__1"


    // $ANTLR start "rule__UnorderedGroup__Group_1__1__Impl"
    // InternalXtext.g:4762:1: rule__UnorderedGroup__Group_1__1__Impl : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4766:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // InternalXtext.g:4767:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:4767:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // InternalXtext.g:4768:2: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // InternalXtext.g:4768:2: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // InternalXtext.g:4769:3: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtext.g:4770:3: ( rule__UnorderedGroup__Group_1_1__0 )
            // InternalXtext.g:4770:4: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_36);
            rule__UnorderedGroup__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:4773:2: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // InternalXtext.g:4774:3: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtext.g:4775:3: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==39) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalXtext.g:4775:4: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_36);
            	    rule__UnorderedGroup__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__0"
    // InternalXtext.g:4785:1: rule__UnorderedGroup__Group_1_1__0 : rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4789:1: ( rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 )
            // InternalXtext.g:4790:2: rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__UnorderedGroup__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__0"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__0__Impl"
    // InternalXtext.g:4797:1: rule__UnorderedGroup__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__UnorderedGroup__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4801:1: ( ( '&' ) )
            // InternalXtext.g:4802:1: ( '&' )
            {
            // InternalXtext.g:4802:1: ( '&' )
            // InternalXtext.g:4803:2: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,39,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__1"
    // InternalXtext.g:4812:1: rule__UnorderedGroup__Group_1_1__1 : rule__UnorderedGroup__Group_1_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4816:1: ( rule__UnorderedGroup__Group_1_1__1__Impl )
            // InternalXtext.g:4817:2: rule__UnorderedGroup__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__1"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__1__Impl"
    // InternalXtext.g:4823:1: rule__UnorderedGroup__Group_1_1__1__Impl : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4827:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:4828:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:4828:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:4829:2: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:4830:2: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // InternalXtext.g:4830:3: rule__UnorderedGroup__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // InternalXtext.g:4839:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4843:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalXtext.g:4844:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0"


    // $ANTLR start "rule__Group__Group__0__Impl"
    // InternalXtext.g:4851:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4855:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:4856:1: ( ruleAbstractToken )
            {
            // InternalXtext.g:4856:1: ( ruleAbstractToken )
            // InternalXtext.g:4857:2: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0__Impl"


    // $ANTLR start "rule__Group__Group__1"
    // InternalXtext.g:4866:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4870:1: ( rule__Group__Group__1__Impl )
            // InternalXtext.g:4871:2: rule__Group__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1"


    // $ANTLR start "rule__Group__Group__1__Impl"
    // InternalXtext.g:4877:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4881:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // InternalXtext.g:4882:1: ( ( rule__Group__Group_1__0 )? )
            {
            // InternalXtext.g:4882:1: ( ( rule__Group__Group_1__0 )? )
            // InternalXtext.g:4883:2: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // InternalXtext.g:4884:2: ( rule__Group__Group_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID||(LA52_0>=RULE_STRING && LA52_0<=RULE_JAVACODESTRING)||(LA52_0>=17 && LA52_0<=18)||LA52_0==23||LA52_0==41||LA52_0==48||LA52_0==55) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalXtext.g:4884:3: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Group__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1__Impl"


    // $ANTLR start "rule__Group__Group_1__0"
    // InternalXtext.g:4893:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4897:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // InternalXtext.g:4898:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__Group__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__0"


    // $ANTLR start "rule__Group__Group_1__0__Impl"
    // InternalXtext.g:4905:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4909:1: ( ( () ) )
            // InternalXtext.g:4910:1: ( () )
            {
            // InternalXtext.g:4910:1: ( () )
            // InternalXtext.g:4911:2: ()
            {
             before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtext.g:4912:2: ()
            // InternalXtext.g:4912:3: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__0__Impl"


    // $ANTLR start "rule__Group__Group_1__1"
    // InternalXtext.g:4920:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4924:1: ( rule__Group__Group_1__1__Impl )
            // InternalXtext.g:4925:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__1"


    // $ANTLR start "rule__Group__Group_1__1__Impl"
    // InternalXtext.g:4931:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4935:1: ( ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) )
            // InternalXtext.g:4936:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtext.g:4936:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            // InternalXtext.g:4937:2: ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* )
            {
            // InternalXtext.g:4937:2: ( ( rule__Group__ElementsAssignment_1_1 ) )
            // InternalXtext.g:4938:3: ( rule__Group__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:4939:3: ( rule__Group__ElementsAssignment_1_1 )
            // InternalXtext.g:4939:4: rule__Group__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_34);
            rule__Group__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtext.g:4942:2: ( ( rule__Group__ElementsAssignment_1_1 )* )
            // InternalXtext.g:4943:3: ( rule__Group__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:4944:3: ( rule__Group__ElementsAssignment_1_1 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID||(LA53_0>=RULE_STRING && LA53_0<=RULE_JAVACODESTRING)||(LA53_0>=17 && LA53_0<=18)||LA53_0==23||LA53_0==41||LA53_0==48||LA53_0==55) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalXtext.g:4944:4: rule__Group__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_34);
            	    rule__Group__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__1__Impl"


    // $ANTLR start "rule__GatedSemanticPredicate__Group__0"
    // InternalXtext.g:4954:1: rule__GatedSemanticPredicate__Group__0 : rule__GatedSemanticPredicate__Group__0__Impl rule__GatedSemanticPredicate__Group__1 ;
    public final void rule__GatedSemanticPredicate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4958:1: ( rule__GatedSemanticPredicate__Group__0__Impl rule__GatedSemanticPredicate__Group__1 )
            // InternalXtext.g:4959:2: rule__GatedSemanticPredicate__Group__0__Impl rule__GatedSemanticPredicate__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__GatedSemanticPredicate__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GatedSemanticPredicate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GatedSemanticPredicate__Group__0"


    // $ANTLR start "rule__GatedSemanticPredicate__Group__0__Impl"
    // InternalXtext.g:4966:1: rule__GatedSemanticPredicate__Group__0__Impl : ( ( rule__GatedSemanticPredicate__CodeAssignment_0 ) ) ;
    public final void rule__GatedSemanticPredicate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4970:1: ( ( ( rule__GatedSemanticPredicate__CodeAssignment_0 ) ) )
            // InternalXtext.g:4971:1: ( ( rule__GatedSemanticPredicate__CodeAssignment_0 ) )
            {
            // InternalXtext.g:4971:1: ( ( rule__GatedSemanticPredicate__CodeAssignment_0 ) )
            // InternalXtext.g:4972:2: ( rule__GatedSemanticPredicate__CodeAssignment_0 )
            {
             before(grammarAccess.getGatedSemanticPredicateAccess().getCodeAssignment_0()); 
            // InternalXtext.g:4973:2: ( rule__GatedSemanticPredicate__CodeAssignment_0 )
            // InternalXtext.g:4973:3: rule__GatedSemanticPredicate__CodeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GatedSemanticPredicate__CodeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getGatedSemanticPredicateAccess().getCodeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GatedSemanticPredicate__Group__0__Impl"


    // $ANTLR start "rule__GatedSemanticPredicate__Group__1"
    // InternalXtext.g:4981:1: rule__GatedSemanticPredicate__Group__1 : rule__GatedSemanticPredicate__Group__1__Impl ;
    public final void rule__GatedSemanticPredicate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4985:1: ( rule__GatedSemanticPredicate__Group__1__Impl )
            // InternalXtext.g:4986:2: rule__GatedSemanticPredicate__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GatedSemanticPredicate__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GatedSemanticPredicate__Group__1"


    // $ANTLR start "rule__GatedSemanticPredicate__Group__1__Impl"
    // InternalXtext.g:4992:1: rule__GatedSemanticPredicate__Group__1__Impl : ( '?=>' ) ;
    public final void rule__GatedSemanticPredicate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:4996:1: ( ( '?=>' ) )
            // InternalXtext.g:4997:1: ( '?=>' )
            {
            // InternalXtext.g:4997:1: ( '?=>' )
            // InternalXtext.g:4998:2: '?=>'
            {
             before(grammarAccess.getGatedSemanticPredicateAccess().getQuestionMarkEqualsSignGreaterThanSignKeyword_1()); 
            match(input,40,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGatedSemanticPredicateAccess().getQuestionMarkEqualsSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GatedSemanticPredicate__Group__1__Impl"


    // $ANTLR start "rule__DisambiguatingSemanticPredicate__Group__0"
    // InternalXtext.g:5008:1: rule__DisambiguatingSemanticPredicate__Group__0 : rule__DisambiguatingSemanticPredicate__Group__0__Impl rule__DisambiguatingSemanticPredicate__Group__1 ;
    public final void rule__DisambiguatingSemanticPredicate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5012:1: ( rule__DisambiguatingSemanticPredicate__Group__0__Impl rule__DisambiguatingSemanticPredicate__Group__1 )
            // InternalXtext.g:5013:2: rule__DisambiguatingSemanticPredicate__Group__0__Impl rule__DisambiguatingSemanticPredicate__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_38);
            rule__DisambiguatingSemanticPredicate__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__DisambiguatingSemanticPredicate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DisambiguatingSemanticPredicate__Group__0"


    // $ANTLR start "rule__DisambiguatingSemanticPredicate__Group__0__Impl"
    // InternalXtext.g:5020:1: rule__DisambiguatingSemanticPredicate__Group__0__Impl : ( ( rule__DisambiguatingSemanticPredicate__CodeAssignment_0 ) ) ;
    public final void rule__DisambiguatingSemanticPredicate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5024:1: ( ( ( rule__DisambiguatingSemanticPredicate__CodeAssignment_0 ) ) )
            // InternalXtext.g:5025:1: ( ( rule__DisambiguatingSemanticPredicate__CodeAssignment_0 ) )
            {
            // InternalXtext.g:5025:1: ( ( rule__DisambiguatingSemanticPredicate__CodeAssignment_0 ) )
            // InternalXtext.g:5026:2: ( rule__DisambiguatingSemanticPredicate__CodeAssignment_0 )
            {
             before(grammarAccess.getDisambiguatingSemanticPredicateAccess().getCodeAssignment_0()); 
            // InternalXtext.g:5027:2: ( rule__DisambiguatingSemanticPredicate__CodeAssignment_0 )
            // InternalXtext.g:5027:3: rule__DisambiguatingSemanticPredicate__CodeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DisambiguatingSemanticPredicate__CodeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDisambiguatingSemanticPredicateAccess().getCodeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DisambiguatingSemanticPredicate__Group__0__Impl"


    // $ANTLR start "rule__DisambiguatingSemanticPredicate__Group__1"
    // InternalXtext.g:5035:1: rule__DisambiguatingSemanticPredicate__Group__1 : rule__DisambiguatingSemanticPredicate__Group__1__Impl ;
    public final void rule__DisambiguatingSemanticPredicate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5039:1: ( rule__DisambiguatingSemanticPredicate__Group__1__Impl )
            // InternalXtext.g:5040:2: rule__DisambiguatingSemanticPredicate__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__DisambiguatingSemanticPredicate__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DisambiguatingSemanticPredicate__Group__1"


    // $ANTLR start "rule__DisambiguatingSemanticPredicate__Group__1__Impl"
    // InternalXtext.g:5046:1: rule__DisambiguatingSemanticPredicate__Group__1__Impl : ( '?' ) ;
    public final void rule__DisambiguatingSemanticPredicate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5050:1: ( ( '?' ) )
            // InternalXtext.g:5051:1: ( '?' )
            {
            // InternalXtext.g:5051:1: ( '?' )
            // InternalXtext.g:5052:2: '?'
            {
             before(grammarAccess.getDisambiguatingSemanticPredicateAccess().getQuestionMarkKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDisambiguatingSemanticPredicateAccess().getQuestionMarkKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DisambiguatingSemanticPredicate__Group__1__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0"
    // InternalXtext.g:5062:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5066:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // InternalXtext.g:5067:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_39);
            rule__AbstractTokenWithCardinality__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__0"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0__Impl"
    // InternalXtext.g:5074:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5078:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // InternalXtext.g:5079:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // InternalXtext.g:5079:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // InternalXtext.g:5080:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // InternalXtext.g:5081:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // InternalXtext.g:5081:3: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__0__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__1"
    // InternalXtext.g:5089:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5093:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // InternalXtext.g:5094:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__1"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__1__Impl"
    // InternalXtext.g:5100:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5104:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? ) )
            // InternalXtext.g:5105:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            {
            // InternalXtext.g:5105:1: ( ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )? )
            // InternalXtext.g:5106:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 
            // InternalXtext.g:5107:2: ( rule__AbstractTokenWithCardinality__CardinalityAssignment_1 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=12 && LA54_0<=14)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXtext.g:5107:3: rule__AbstractTokenWithCardinality__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AbstractTokenWithCardinality__CardinalityAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // InternalXtext.g:5116:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5120:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXtext.g:5121:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // InternalXtext.g:5128:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5132:1: ( ( '{' ) )
            // InternalXtext.g:5133:1: ( '{' )
            {
            // InternalXtext.g:5133:1: ( '{' )
            // InternalXtext.g:5134:2: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,41,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // InternalXtext.g:5143:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5147:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalXtext.g:5148:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // InternalXtext.g:5155:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5159:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // InternalXtext.g:5160:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // InternalXtext.g:5160:1: ( ( rule__Action__TypeAssignment_1 ) )
            // InternalXtext.g:5161:2: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // InternalXtext.g:5162:2: ( rule__Action__TypeAssignment_1 )
            // InternalXtext.g:5162:3: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__2"
    // InternalXtext.g:5170:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5174:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalXtext.g:5175:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2"


    // $ANTLR start "rule__Action__Group__2__Impl"
    // InternalXtext.g:5182:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5186:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalXtext.g:5187:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalXtext.g:5187:1: ( ( rule__Action__Group_2__0 )? )
            // InternalXtext.g:5188:2: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalXtext.g:5189:2: ( rule__Action__Group_2__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==27) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalXtext.g:5189:3: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Action__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2__Impl"


    // $ANTLR start "rule__Action__Group__3"
    // InternalXtext.g:5197:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5201:1: ( rule__Action__Group__3__Impl )
            // InternalXtext.g:5202:2: rule__Action__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3"


    // $ANTLR start "rule__Action__Group__3__Impl"
    // InternalXtext.g:5208:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5212:1: ( ( '}' ) )
            // InternalXtext.g:5213:1: ( '}' )
            {
            // InternalXtext.g:5213:1: ( '}' )
            // InternalXtext.g:5214:2: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,42,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3__Impl"


    // $ANTLR start "rule__Action__Group_2__0"
    // InternalXtext.g:5224:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5228:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalXtext.g:5229:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Action__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__0"


    // $ANTLR start "rule__Action__Group_2__0__Impl"
    // InternalXtext.g:5236:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5240:1: ( ( '.' ) )
            // InternalXtext.g:5241:1: ( '.' )
            {
            // InternalXtext.g:5241:1: ( '.' )
            // InternalXtext.g:5242:2: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__0__Impl"


    // $ANTLR start "rule__Action__Group_2__1"
    // InternalXtext.g:5251:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5255:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // InternalXtext.g:5256:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_41);
            rule__Action__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__1"


    // $ANTLR start "rule__Action__Group_2__1__Impl"
    // InternalXtext.g:5263:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5267:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // InternalXtext.g:5268:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // InternalXtext.g:5268:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // InternalXtext.g:5269:2: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // InternalXtext.g:5270:2: ( rule__Action__FeatureAssignment_2_1 )
            // InternalXtext.g:5270:3: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__FeatureAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__1__Impl"


    // $ANTLR start "rule__Action__Group_2__2"
    // InternalXtext.g:5278:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5282:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // InternalXtext.g:5283:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_42);
            rule__Action__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__2"


    // $ANTLR start "rule__Action__Group_2__2__Impl"
    // InternalXtext.g:5290:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5294:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // InternalXtext.g:5295:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // InternalXtext.g:5295:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // InternalXtext.g:5296:2: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // InternalXtext.g:5297:2: ( rule__Action__OperatorAssignment_2_2 )
            // InternalXtext.g:5297:3: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__OperatorAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__2__Impl"


    // $ANTLR start "rule__Action__Group_2__3"
    // InternalXtext.g:5305:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5309:1: ( rule__Action__Group_2__3__Impl )
            // InternalXtext.g:5310:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__3"


    // $ANTLR start "rule__Action__Group_2__3__Impl"
    // InternalXtext.g:5316:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5320:1: ( ( 'current' ) )
            // InternalXtext.g:5321:1: ( 'current' )
            {
            // InternalXtext.g:5321:1: ( 'current' )
            // InternalXtext.g:5322:2: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__3__Impl"


    // $ANTLR start "rule__RuleCall__Group__0"
    // InternalXtext.g:5332:1: rule__RuleCall__Group__0 : rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 ;
    public final void rule__RuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5336:1: ( rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 )
            // InternalXtext.g:5337:2: rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__RuleCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__0"


    // $ANTLR start "rule__RuleCall__Group__0__Impl"
    // InternalXtext.g:5344:1: rule__RuleCall__Group__0__Impl : ( ( rule__RuleCall__RuleAssignment_0 ) ) ;
    public final void rule__RuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5348:1: ( ( ( rule__RuleCall__RuleAssignment_0 ) ) )
            // InternalXtext.g:5349:1: ( ( rule__RuleCall__RuleAssignment_0 ) )
            {
            // InternalXtext.g:5349:1: ( ( rule__RuleCall__RuleAssignment_0 ) )
            // InternalXtext.g:5350:2: ( rule__RuleCall__RuleAssignment_0 )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); 
            // InternalXtext.g:5351:2: ( rule__RuleCall__RuleAssignment_0 )
            // InternalXtext.g:5351:3: rule__RuleCall__RuleAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__RuleAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__0__Impl"


    // $ANTLR start "rule__RuleCall__Group__1"
    // InternalXtext.g:5359:1: rule__RuleCall__Group__1 : rule__RuleCall__Group__1__Impl ;
    public final void rule__RuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5363:1: ( rule__RuleCall__Group__1__Impl )
            // InternalXtext.g:5364:2: rule__RuleCall__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__1"


    // $ANTLR start "rule__RuleCall__Group__1__Impl"
    // InternalXtext.g:5370:1: rule__RuleCall__Group__1__Impl : ( ( rule__RuleCall__Group_1__0 )? ) ;
    public final void rule__RuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5374:1: ( ( ( rule__RuleCall__Group_1__0 )? ) )
            // InternalXtext.g:5375:1: ( ( rule__RuleCall__Group_1__0 )? )
            {
            // InternalXtext.g:5375:1: ( ( rule__RuleCall__Group_1__0 )? )
            // InternalXtext.g:5376:2: ( rule__RuleCall__Group_1__0 )?
            {
             before(grammarAccess.getRuleCallAccess().getGroup_1()); 
            // InternalXtext.g:5377:2: ( rule__RuleCall__Group_1__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==35) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalXtext.g:5377:3: rule__RuleCall__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleCall__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleCallAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__1__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__0"
    // InternalXtext.g:5386:1: rule__RuleCall__Group_1__0 : rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1 ;
    public final void rule__RuleCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5390:1: ( rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1 )
            // InternalXtext.g:5391:2: rule__RuleCall__Group_1__0__Impl rule__RuleCall__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__RuleCall__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__0"


    // $ANTLR start "rule__RuleCall__Group_1__0__Impl"
    // InternalXtext.g:5398:1: rule__RuleCall__Group_1__0__Impl : ( '<' ) ;
    public final void rule__RuleCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5402:1: ( ( '<' ) )
            // InternalXtext.g:5403:1: ( '<' )
            {
            // InternalXtext.g:5403:1: ( '<' )
            // InternalXtext.g:5404:2: '<'
            {
             before(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__0__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__1"
    // InternalXtext.g:5413:1: rule__RuleCall__Group_1__1 : rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2 ;
    public final void rule__RuleCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5417:1: ( rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2 )
            // InternalXtext.g:5418:2: rule__RuleCall__Group_1__1__Impl rule__RuleCall__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__RuleCall__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__1"


    // $ANTLR start "rule__RuleCall__Group_1__1__Impl"
    // InternalXtext.g:5425:1: rule__RuleCall__Group_1__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__RuleCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5429:1: ( ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) ) )
            // InternalXtext.g:5430:1: ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) )
            {
            // InternalXtext.g:5430:1: ( ( rule__RuleCall__ArgumentsAssignment_1_1 ) )
            // InternalXtext.g:5431:2: ( rule__RuleCall__ArgumentsAssignment_1_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); 
            // InternalXtext.g:5432:2: ( rule__RuleCall__ArgumentsAssignment_1_1 )
            // InternalXtext.g:5432:3: rule__RuleCall__ArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__ArgumentsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__1__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__2"
    // InternalXtext.g:5440:1: rule__RuleCall__Group_1__2 : rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3 ;
    public final void rule__RuleCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5444:1: ( rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3 )
            // InternalXtext.g:5445:2: rule__RuleCall__Group_1__2__Impl rule__RuleCall__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__RuleCall__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__2"


    // $ANTLR start "rule__RuleCall__Group_1__2__Impl"
    // InternalXtext.g:5452:1: rule__RuleCall__Group_1__2__Impl : ( ( rule__RuleCall__Group_1_2__0 )* ) ;
    public final void rule__RuleCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5456:1: ( ( ( rule__RuleCall__Group_1_2__0 )* ) )
            // InternalXtext.g:5457:1: ( ( rule__RuleCall__Group_1_2__0 )* )
            {
            // InternalXtext.g:5457:1: ( ( rule__RuleCall__Group_1_2__0 )* )
            // InternalXtext.g:5458:2: ( rule__RuleCall__Group_1_2__0 )*
            {
             before(grammarAccess.getRuleCallAccess().getGroup_1_2()); 
            // InternalXtext.g:5459:2: ( rule__RuleCall__Group_1_2__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==22) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalXtext.g:5459:3: rule__RuleCall__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__RuleCall__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getRuleCallAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__2__Impl"


    // $ANTLR start "rule__RuleCall__Group_1__3"
    // InternalXtext.g:5467:1: rule__RuleCall__Group_1__3 : rule__RuleCall__Group_1__3__Impl ;
    public final void rule__RuleCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5471:1: ( rule__RuleCall__Group_1__3__Impl )
            // InternalXtext.g:5472:2: rule__RuleCall__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__3"


    // $ANTLR start "rule__RuleCall__Group_1__3__Impl"
    // InternalXtext.g:5478:1: rule__RuleCall__Group_1__3__Impl : ( '>' ) ;
    public final void rule__RuleCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5482:1: ( ( '>' ) )
            // InternalXtext.g:5483:1: ( '>' )
            {
            // InternalXtext.g:5483:1: ( '>' )
            // InternalXtext.g:5484:2: '>'
            {
             before(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,36,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1__3__Impl"


    // $ANTLR start "rule__RuleCall__Group_1_2__0"
    // InternalXtext.g:5494:1: rule__RuleCall__Group_1_2__0 : rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1 ;
    public final void rule__RuleCall__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5498:1: ( rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1 )
            // InternalXtext.g:5499:2: rule__RuleCall__Group_1_2__0__Impl rule__RuleCall__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__RuleCall__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1_2__0"


    // $ANTLR start "rule__RuleCall__Group_1_2__0__Impl"
    // InternalXtext.g:5506:1: rule__RuleCall__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__RuleCall__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5510:1: ( ( ',' ) )
            // InternalXtext.g:5511:1: ( ',' )
            {
            // InternalXtext.g:5511:1: ( ',' )
            // InternalXtext.g:5512:2: ','
            {
             before(grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1_2__0__Impl"


    // $ANTLR start "rule__RuleCall__Group_1_2__1"
    // InternalXtext.g:5521:1: rule__RuleCall__Group_1_2__1 : rule__RuleCall__Group_1_2__1__Impl ;
    public final void rule__RuleCall__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5525:1: ( rule__RuleCall__Group_1_2__1__Impl )
            // InternalXtext.g:5526:2: rule__RuleCall__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1_2__1"


    // $ANTLR start "rule__RuleCall__Group_1_2__1__Impl"
    // InternalXtext.g:5532:1: rule__RuleCall__Group_1_2__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__RuleCall__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5536:1: ( ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) ) )
            // InternalXtext.g:5537:1: ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) )
            {
            // InternalXtext.g:5537:1: ( ( rule__RuleCall__ArgumentsAssignment_1_2_1 ) )
            // InternalXtext.g:5538:2: ( rule__RuleCall__ArgumentsAssignment_1_2_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); 
            // InternalXtext.g:5539:2: ( rule__RuleCall__ArgumentsAssignment_1_2_1 )
            // InternalXtext.g:5539:3: rule__RuleCall__ArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__ArgumentsAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_1_2__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group__0"
    // InternalXtext.g:5548:1: rule__NamedArgument__Group__0 : rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 ;
    public final void rule__NamedArgument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5552:1: ( rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 )
            // InternalXtext.g:5553:2: rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__NamedArgument__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__0"


    // $ANTLR start "rule__NamedArgument__Group__0__Impl"
    // InternalXtext.g:5560:1: rule__NamedArgument__Group__0__Impl : ( ( rule__NamedArgument__Group_0__0 )? ) ;
    public final void rule__NamedArgument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5564:1: ( ( ( rule__NamedArgument__Group_0__0 )? ) )
            // InternalXtext.g:5565:1: ( ( rule__NamedArgument__Group_0__0 )? )
            {
            // InternalXtext.g:5565:1: ( ( rule__NamedArgument__Group_0__0 )? )
            // InternalXtext.g:5566:2: ( rule__NamedArgument__Group_0__0 )?
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup_0()); 
            // InternalXtext.g:5567:2: ( rule__NamedArgument__Group_0__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==15) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // InternalXtext.g:5567:3: rule__NamedArgument__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__NamedArgument__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNamedArgumentAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group__1"
    // InternalXtext.g:5575:1: rule__NamedArgument__Group__1 : rule__NamedArgument__Group__1__Impl ;
    public final void rule__NamedArgument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5579:1: ( rule__NamedArgument__Group__1__Impl )
            // InternalXtext.g:5580:2: rule__NamedArgument__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__1"


    // $ANTLR start "rule__NamedArgument__Group__1__Impl"
    // InternalXtext.g:5586:1: rule__NamedArgument__Group__1__Impl : ( ( rule__NamedArgument__ValueAssignment_1 ) ) ;
    public final void rule__NamedArgument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5590:1: ( ( ( rule__NamedArgument__ValueAssignment_1 ) ) )
            // InternalXtext.g:5591:1: ( ( rule__NamedArgument__ValueAssignment_1 ) )
            {
            // InternalXtext.g:5591:1: ( ( rule__NamedArgument__ValueAssignment_1 ) )
            // InternalXtext.g:5592:2: ( rule__NamedArgument__ValueAssignment_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); 
            // InternalXtext.g:5593:2: ( rule__NamedArgument__ValueAssignment_1 )
            // InternalXtext.g:5593:3: rule__NamedArgument__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group_0__0"
    // InternalXtext.g:5602:1: rule__NamedArgument__Group_0__0 : rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 ;
    public final void rule__NamedArgument__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5606:1: ( rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1 )
            // InternalXtext.g:5607:2: rule__NamedArgument__Group_0__0__Impl rule__NamedArgument__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__NamedArgument__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__0"


    // $ANTLR start "rule__NamedArgument__Group_0__0__Impl"
    // InternalXtext.g:5614:1: rule__NamedArgument__Group_0__0__Impl : ( ( rule__NamedArgument__ParameterAssignment_0_0 ) ) ;
    public final void rule__NamedArgument__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5618:1: ( ( ( rule__NamedArgument__ParameterAssignment_0_0 ) ) )
            // InternalXtext.g:5619:1: ( ( rule__NamedArgument__ParameterAssignment_0_0 ) )
            {
            // InternalXtext.g:5619:1: ( ( rule__NamedArgument__ParameterAssignment_0_0 ) )
            // InternalXtext.g:5620:2: ( rule__NamedArgument__ParameterAssignment_0_0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); 
            // InternalXtext.g:5621:2: ( rule__NamedArgument__ParameterAssignment_0_0 )
            // InternalXtext.g:5621:3: rule__NamedArgument__ParameterAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ParameterAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group_0__1"
    // InternalXtext.g:5629:1: rule__NamedArgument__Group_0__1 : rule__NamedArgument__Group_0__1__Impl ;
    public final void rule__NamedArgument__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5633:1: ( rule__NamedArgument__Group_0__1__Impl )
            // InternalXtext.g:5634:2: rule__NamedArgument__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__1"


    // $ANTLR start "rule__NamedArgument__Group_0__1__Impl"
    // InternalXtext.g:5640:1: rule__NamedArgument__Group_0__1__Impl : ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) ) ;
    public final void rule__NamedArgument__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5644:1: ( ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) ) )
            // InternalXtext.g:5645:1: ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) )
            {
            // InternalXtext.g:5645:1: ( ( rule__NamedArgument__CalledByNameAssignment_0_1 ) )
            // InternalXtext.g:5646:2: ( rule__NamedArgument__CalledByNameAssignment_0_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); 
            // InternalXtext.g:5647:2: ( rule__NamedArgument__CalledByNameAssignment_0_1 )
            // InternalXtext.g:5647:3: rule__NamedArgument__CalledByNameAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__CalledByNameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_0__1__Impl"


    // $ANTLR start "rule__LiteralCondition__Group__0"
    // InternalXtext.g:5656:1: rule__LiteralCondition__Group__0 : rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1 ;
    public final void rule__LiteralCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5660:1: ( rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1 )
            // InternalXtext.g:5661:2: rule__LiteralCondition__Group__0__Impl rule__LiteralCondition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_45);
            rule__LiteralCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Group__0"


    // $ANTLR start "rule__LiteralCondition__Group__0__Impl"
    // InternalXtext.g:5668:1: rule__LiteralCondition__Group__0__Impl : ( () ) ;
    public final void rule__LiteralCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5672:1: ( ( () ) )
            // InternalXtext.g:5673:1: ( () )
            {
            // InternalXtext.g:5673:1: ( () )
            // InternalXtext.g:5674:2: ()
            {
             before(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); 
            // InternalXtext.g:5675:2: ()
            // InternalXtext.g:5675:3: 
            {
            }

             after(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Group__0__Impl"


    // $ANTLR start "rule__LiteralCondition__Group__1"
    // InternalXtext.g:5683:1: rule__LiteralCondition__Group__1 : rule__LiteralCondition__Group__1__Impl ;
    public final void rule__LiteralCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5687:1: ( rule__LiteralCondition__Group__1__Impl )
            // InternalXtext.g:5688:2: rule__LiteralCondition__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Group__1"


    // $ANTLR start "rule__LiteralCondition__Group__1__Impl"
    // InternalXtext.g:5694:1: rule__LiteralCondition__Group__1__Impl : ( ( rule__LiteralCondition__Alternatives_1 ) ) ;
    public final void rule__LiteralCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5698:1: ( ( ( rule__LiteralCondition__Alternatives_1 ) ) )
            // InternalXtext.g:5699:1: ( ( rule__LiteralCondition__Alternatives_1 ) )
            {
            // InternalXtext.g:5699:1: ( ( rule__LiteralCondition__Alternatives_1 ) )
            // InternalXtext.g:5700:2: ( rule__LiteralCondition__Alternatives_1 )
            {
             before(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); 
            // InternalXtext.g:5701:2: ( rule__LiteralCondition__Alternatives_1 )
            // InternalXtext.g:5701:3: rule__LiteralCondition__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralCondition__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group__0"
    // InternalXtext.g:5710:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5714:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // InternalXtext.g:5715:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0"


    // $ANTLR start "rule__Disjunction__Group__0__Impl"
    // InternalXtext.g:5722:1: rule__Disjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5726:1: ( ( ruleConjunction ) )
            // InternalXtext.g:5727:1: ( ruleConjunction )
            {
            // InternalXtext.g:5727:1: ( ruleConjunction )
            // InternalXtext.g:5728:2: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0__Impl"


    // $ANTLR start "rule__Disjunction__Group__1"
    // InternalXtext.g:5737:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5741:1: ( rule__Disjunction__Group__1__Impl )
            // InternalXtext.g:5742:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1"


    // $ANTLR start "rule__Disjunction__Group__1__Impl"
    // InternalXtext.g:5748:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5752:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // InternalXtext.g:5753:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // InternalXtext.g:5753:1: ( ( rule__Disjunction__Group_1__0 )* )
            // InternalXtext.g:5754:2: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // InternalXtext.g:5755:2: ( rule__Disjunction__Group_1__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==38) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalXtext.g:5755:3: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getDisjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__0"
    // InternalXtext.g:5764:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5768:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // InternalXtext.g:5769:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0"


    // $ANTLR start "rule__Disjunction__Group_1__0__Impl"
    // InternalXtext.g:5776:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5780:1: ( ( () ) )
            // InternalXtext.g:5781:1: ( () )
            {
            // InternalXtext.g:5781:1: ( () )
            // InternalXtext.g:5782:2: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 
            // InternalXtext.g:5783:2: ()
            // InternalXtext.g:5783:3: 
            {
            }

             after(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__1"
    // InternalXtext.g:5791:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5795:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // InternalXtext.g:5796:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1"


    // $ANTLR start "rule__Disjunction__Group_1__1__Impl"
    // InternalXtext.g:5803:1: rule__Disjunction__Group_1__1__Impl : ( '|' ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5807:1: ( ( '|' ) )
            // InternalXtext.g:5808:1: ( '|' )
            {
            // InternalXtext.g:5808:1: ( '|' )
            // InternalXtext.g:5809:2: '|'
            {
             before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__2"
    // InternalXtext.g:5818:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5822:1: ( rule__Disjunction__Group_1__2__Impl )
            // InternalXtext.g:5823:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2"


    // $ANTLR start "rule__Disjunction__Group_1__2__Impl"
    // InternalXtext.g:5829:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5833:1: ( ( ( rule__Disjunction__RightAssignment_1_2 ) ) )
            // InternalXtext.g:5834:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:5834:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            // InternalXtext.g:5835:2: ( rule__Disjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:5836:2: ( rule__Disjunction__RightAssignment_1_2 )
            // InternalXtext.g:5836:3: rule__Disjunction__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Disjunction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Conjunction__Group__0"
    // InternalXtext.g:5845:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5849:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // InternalXtext.g:5850:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_35);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0"


    // $ANTLR start "rule__Conjunction__Group__0__Impl"
    // InternalXtext.g:5857:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5861:1: ( ( ruleNegation ) )
            // InternalXtext.g:5862:1: ( ruleNegation )
            {
            // InternalXtext.g:5862:1: ( ruleNegation )
            // InternalXtext.g:5863:2: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0__Impl"


    // $ANTLR start "rule__Conjunction__Group__1"
    // InternalXtext.g:5872:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5876:1: ( rule__Conjunction__Group__1__Impl )
            // InternalXtext.g:5877:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1"


    // $ANTLR start "rule__Conjunction__Group__1__Impl"
    // InternalXtext.g:5883:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5887:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // InternalXtext.g:5888:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // InternalXtext.g:5888:1: ( ( rule__Conjunction__Group_1__0 )* )
            // InternalXtext.g:5889:2: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // InternalXtext.g:5890:2: ( rule__Conjunction__Group_1__0 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==39) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalXtext.g:5890:3: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_36);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

             after(grammarAccess.getConjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__0"
    // InternalXtext.g:5899:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5903:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // InternalXtext.g:5904:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_35);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0"


    // $ANTLR start "rule__Conjunction__Group_1__0__Impl"
    // InternalXtext.g:5911:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5915:1: ( ( () ) )
            // InternalXtext.g:5916:1: ( () )
            {
            // InternalXtext.g:5916:1: ( () )
            // InternalXtext.g:5917:2: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 
            // InternalXtext.g:5918:2: ()
            // InternalXtext.g:5918:3: 
            {
            }

             after(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__1"
    // InternalXtext.g:5926:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5930:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // InternalXtext.g:5931:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1"


    // $ANTLR start "rule__Conjunction__Group_1__1__Impl"
    // InternalXtext.g:5938:1: rule__Conjunction__Group_1__1__Impl : ( '&' ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5942:1: ( ( '&' ) )
            // InternalXtext.g:5943:1: ( '&' )
            {
            // InternalXtext.g:5943:1: ( '&' )
            // InternalXtext.g:5944:2: '&'
            {
             before(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 
            match(input,39,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__2"
    // InternalXtext.g:5953:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5957:1: ( rule__Conjunction__Group_1__2__Impl )
            // InternalXtext.g:5958:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2"


    // $ANTLR start "rule__Conjunction__Group_1__2__Impl"
    // InternalXtext.g:5964:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5968:1: ( ( ( rule__Conjunction__RightAssignment_1_2 ) ) )
            // InternalXtext.g:5969:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:5969:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            // InternalXtext.g:5970:2: ( rule__Conjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:5971:2: ( rule__Conjunction__RightAssignment_1_2 )
            // InternalXtext.g:5971:3: rule__Conjunction__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Conjunction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Negation__Group_1__0"
    // InternalXtext.g:5980:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5984:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // InternalXtext.g:5985:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0"


    // $ANTLR start "rule__Negation__Group_1__0__Impl"
    // InternalXtext.g:5992:1: rule__Negation__Group_1__0__Impl : ( () ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:5996:1: ( ( () ) )
            // InternalXtext.g:5997:1: ( () )
            {
            // InternalXtext.g:5997:1: ( () )
            // InternalXtext.g:5998:2: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_0()); 
            // InternalXtext.g:5999:2: ()
            // InternalXtext.g:5999:3: 
            {
            }

             after(grammarAccess.getNegationAccess().getNegationAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0__Impl"


    // $ANTLR start "rule__Negation__Group_1__1"
    // InternalXtext.g:6007:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6011:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // InternalXtext.g:6012:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1"


    // $ANTLR start "rule__Negation__Group_1__1__Impl"
    // InternalXtext.g:6019:1: rule__Negation__Group_1__1__Impl : ( '!' ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6023:1: ( ( '!' ) )
            // InternalXtext.g:6024:1: ( '!' )
            {
            // InternalXtext.g:6024:1: ( '!' )
            // InternalXtext.g:6025:2: '!'
            {
             before(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); 
            match(input,44,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1__Impl"


    // $ANTLR start "rule__Negation__Group_1__2"
    // InternalXtext.g:6034:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6038:1: ( rule__Negation__Group_1__2__Impl )
            // InternalXtext.g:6039:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2"


    // $ANTLR start "rule__Negation__Group_1__2__Impl"
    // InternalXtext.g:6045:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ValueAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6049:1: ( ( ( rule__Negation__ValueAssignment_1_2 ) ) )
            // InternalXtext.g:6050:1: ( ( rule__Negation__ValueAssignment_1_2 ) )
            {
            // InternalXtext.g:6050:1: ( ( rule__Negation__ValueAssignment_1_2 ) )
            // InternalXtext.g:6051:2: ( rule__Negation__ValueAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getValueAssignment_1_2()); 
            // InternalXtext.g:6052:2: ( rule__Negation__ValueAssignment_1_2 )
            // InternalXtext.g:6052:3: rule__Negation__ValueAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Negation__ValueAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getValueAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2__Impl"


    // $ANTLR start "rule__ParenthesizedCondition__Group__0"
    // InternalXtext.g:6061:1: rule__ParenthesizedCondition__Group__0 : rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1 ;
    public final void rule__ParenthesizedCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6065:1: ( rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1 )
            // InternalXtext.g:6066:2: rule__ParenthesizedCondition__Group__0__Impl rule__ParenthesizedCondition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__ParenthesizedCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__0"


    // $ANTLR start "rule__ParenthesizedCondition__Group__0__Impl"
    // InternalXtext.g:6073:1: rule__ParenthesizedCondition__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6077:1: ( ( '(' ) )
            // InternalXtext.g:6078:1: ( '(' )
            {
            // InternalXtext.g:6078:1: ( '(' )
            // InternalXtext.g:6079:2: '('
            {
             before(grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedCondition__Group__1"
    // InternalXtext.g:6088:1: rule__ParenthesizedCondition__Group__1 : rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2 ;
    public final void rule__ParenthesizedCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6092:1: ( rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2 )
            // InternalXtext.g:6093:2: rule__ParenthesizedCondition__Group__1__Impl rule__ParenthesizedCondition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__ParenthesizedCondition__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__1"


    // $ANTLR start "rule__ParenthesizedCondition__Group__1__Impl"
    // InternalXtext.g:6100:1: rule__ParenthesizedCondition__Group__1__Impl : ( ruleDisjunction ) ;
    public final void rule__ParenthesizedCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6104:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:6105:1: ( ruleDisjunction )
            {
            // InternalXtext.g:6105:1: ( ruleDisjunction )
            // InternalXtext.g:6106:2: ruleDisjunction
            {
             before(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedCondition__Group__2"
    // InternalXtext.g:6115:1: rule__ParenthesizedCondition__Group__2 : rule__ParenthesizedCondition__Group__2__Impl ;
    public final void rule__ParenthesizedCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6119:1: ( rule__ParenthesizedCondition__Group__2__Impl )
            // InternalXtext.g:6120:2: rule__ParenthesizedCondition__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedCondition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__2"


    // $ANTLR start "rule__ParenthesizedCondition__Group__2__Impl"
    // InternalXtext.g:6126:1: rule__ParenthesizedCondition__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6130:1: ( ( ')' ) )
            // InternalXtext.g:6131:1: ( ')' )
            {
            // InternalXtext.g:6131:1: ( ')' )
            // InternalXtext.g:6132:2: ')'
            {
             before(grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedCondition__Group__2__Impl"


    // $ANTLR start "rule__RuleID__Group__0"
    // InternalXtext.g:6142:1: rule__RuleID__Group__0 : rule__RuleID__Group__0__Impl rule__RuleID__Group__1 ;
    public final void rule__RuleID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6146:1: ( rule__RuleID__Group__0__Impl rule__RuleID__Group__1 )
            // InternalXtext.g:6147:2: rule__RuleID__Group__0__Impl rule__RuleID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__RuleID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__0"


    // $ANTLR start "rule__RuleID__Group__0__Impl"
    // InternalXtext.g:6154:1: rule__RuleID__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__RuleID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6158:1: ( ( ruleValidID ) )
            // InternalXtext.g:6159:1: ( ruleValidID )
            {
            // InternalXtext.g:6159:1: ( ruleValidID )
            // InternalXtext.g:6160:2: ruleValidID
            {
             before(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__0__Impl"


    // $ANTLR start "rule__RuleID__Group__1"
    // InternalXtext.g:6169:1: rule__RuleID__Group__1 : rule__RuleID__Group__1__Impl ;
    public final void rule__RuleID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6173:1: ( rule__RuleID__Group__1__Impl )
            // InternalXtext.g:6174:2: rule__RuleID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__1"


    // $ANTLR start "rule__RuleID__Group__1__Impl"
    // InternalXtext.g:6180:1: rule__RuleID__Group__1__Impl : ( ( rule__RuleID__Group_1__0 )* ) ;
    public final void rule__RuleID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6184:1: ( ( ( rule__RuleID__Group_1__0 )* ) )
            // InternalXtext.g:6185:1: ( ( rule__RuleID__Group_1__0 )* )
            {
            // InternalXtext.g:6185:1: ( ( rule__RuleID__Group_1__0 )* )
            // InternalXtext.g:6186:2: ( rule__RuleID__Group_1__0 )*
            {
             before(grammarAccess.getRuleIDAccess().getGroup_1()); 
            // InternalXtext.g:6187:2: ( rule__RuleID__Group_1__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==37) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalXtext.g:6187:3: rule__RuleID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_47);
            	    rule__RuleID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getRuleIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__1__Impl"


    // $ANTLR start "rule__RuleID__Group_1__0"
    // InternalXtext.g:6196:1: rule__RuleID__Group_1__0 : rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 ;
    public final void rule__RuleID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6200:1: ( rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 )
            // InternalXtext.g:6201:2: rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RuleID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__0"


    // $ANTLR start "rule__RuleID__Group_1__0__Impl"
    // InternalXtext.g:6208:1: rule__RuleID__Group_1__0__Impl : ( '::' ) ;
    public final void rule__RuleID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6212:1: ( ( '::' ) )
            // InternalXtext.g:6213:1: ( '::' )
            {
            // InternalXtext.g:6213:1: ( '::' )
            // InternalXtext.g:6214:2: '::'
            {
             before(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 
            match(input,37,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__0__Impl"


    // $ANTLR start "rule__RuleID__Group_1__1"
    // InternalXtext.g:6223:1: rule__RuleID__Group_1__1 : rule__RuleID__Group_1__1__Impl ;
    public final void rule__RuleID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6227:1: ( rule__RuleID__Group_1__1__Impl )
            // InternalXtext.g:6228:2: rule__RuleID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__1"


    // $ANTLR start "rule__RuleID__Group_1__1__Impl"
    // InternalXtext.g:6234:1: rule__RuleID__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__RuleID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6238:1: ( ( ruleValidID ) )
            // InternalXtext.g:6239:1: ( ruleValidID )
            {
            // InternalXtext.g:6239:1: ( ruleValidID )
            // InternalXtext.g:6240:2: ruleValidID
            {
             before(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__1__Impl"


    // $ANTLR start "rule__PredicatedKeyword__Group__0"
    // InternalXtext.g:6250:1: rule__PredicatedKeyword__Group__0 : rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 ;
    public final void rule__PredicatedKeyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6254:1: ( rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 )
            // InternalXtext.g:6255:2: rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__PredicatedKeyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__0"


    // $ANTLR start "rule__PredicatedKeyword__Group__0__Impl"
    // InternalXtext.g:6262:1: rule__PredicatedKeyword__Group__0__Impl : ( ( rule__PredicatedKeyword__Alternatives_0 ) ) ;
    public final void rule__PredicatedKeyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6266:1: ( ( ( rule__PredicatedKeyword__Alternatives_0 ) ) )
            // InternalXtext.g:6267:1: ( ( rule__PredicatedKeyword__Alternatives_0 ) )
            {
            // InternalXtext.g:6267:1: ( ( rule__PredicatedKeyword__Alternatives_0 ) )
            // InternalXtext.g:6268:2: ( rule__PredicatedKeyword__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); 
            // InternalXtext.g:6269:2: ( rule__PredicatedKeyword__Alternatives_0 )
            // InternalXtext.g:6269:3: rule__PredicatedKeyword__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__0__Impl"


    // $ANTLR start "rule__PredicatedKeyword__Group__1"
    // InternalXtext.g:6277:1: rule__PredicatedKeyword__Group__1 : rule__PredicatedKeyword__Group__1__Impl ;
    public final void rule__PredicatedKeyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6281:1: ( rule__PredicatedKeyword__Group__1__Impl )
            // InternalXtext.g:6282:2: rule__PredicatedKeyword__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__1"


    // $ANTLR start "rule__PredicatedKeyword__Group__1__Impl"
    // InternalXtext.g:6288:1: rule__PredicatedKeyword__Group__1__Impl : ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) ;
    public final void rule__PredicatedKeyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6292:1: ( ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) )
            // InternalXtext.g:6293:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            {
            // InternalXtext.g:6293:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            // InternalXtext.g:6294:2: ( rule__PredicatedKeyword__ValueAssignment_1 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 
            // InternalXtext.g:6295:2: ( rule__PredicatedKeyword__ValueAssignment_1 )
            // InternalXtext.g:6295:3: rule__PredicatedKeyword__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__0"
    // InternalXtext.g:6304:1: rule__PredicatedRuleCall__Group__0 : rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 ;
    public final void rule__PredicatedRuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6308:1: ( rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 )
            // InternalXtext.g:6309:2: rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PredicatedRuleCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group__0__Impl"
    // InternalXtext.g:6316:1: rule__PredicatedRuleCall__Group__0__Impl : ( ( rule__PredicatedRuleCall__Alternatives_0 ) ) ;
    public final void rule__PredicatedRuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6320:1: ( ( ( rule__PredicatedRuleCall__Alternatives_0 ) ) )
            // InternalXtext.g:6321:1: ( ( rule__PredicatedRuleCall__Alternatives_0 ) )
            {
            // InternalXtext.g:6321:1: ( ( rule__PredicatedRuleCall__Alternatives_0 ) )
            // InternalXtext.g:6322:2: ( rule__PredicatedRuleCall__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); 
            // InternalXtext.g:6323:2: ( rule__PredicatedRuleCall__Alternatives_0 )
            // InternalXtext.g:6323:3: rule__PredicatedRuleCall__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__1"
    // InternalXtext.g:6331:1: rule__PredicatedRuleCall__Group__1 : rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2 ;
    public final void rule__PredicatedRuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6335:1: ( rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2 )
            // InternalXtext.g:6336:2: rule__PredicatedRuleCall__Group__1__Impl rule__PredicatedRuleCall__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__PredicatedRuleCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group__1__Impl"
    // InternalXtext.g:6343:1: rule__PredicatedRuleCall__Group__1__Impl : ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6347:1: ( ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) )
            // InternalXtext.g:6348:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            {
            // InternalXtext.g:6348:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            // InternalXtext.g:6349:2: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 
            // InternalXtext.g:6350:2: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            // InternalXtext.g:6350:3: rule__PredicatedRuleCall__RuleAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__RuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__2"
    // InternalXtext.g:6358:1: rule__PredicatedRuleCall__Group__2 : rule__PredicatedRuleCall__Group__2__Impl ;
    public final void rule__PredicatedRuleCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6362:1: ( rule__PredicatedRuleCall__Group__2__Impl )
            // InternalXtext.g:6363:2: rule__PredicatedRuleCall__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__2"


    // $ANTLR start "rule__PredicatedRuleCall__Group__2__Impl"
    // InternalXtext.g:6369:1: rule__PredicatedRuleCall__Group__2__Impl : ( ( rule__PredicatedRuleCall__Group_2__0 )? ) ;
    public final void rule__PredicatedRuleCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6373:1: ( ( ( rule__PredicatedRuleCall__Group_2__0 )? ) )
            // InternalXtext.g:6374:1: ( ( rule__PredicatedRuleCall__Group_2__0 )? )
            {
            // InternalXtext.g:6374:1: ( ( rule__PredicatedRuleCall__Group_2__0 )? )
            // InternalXtext.g:6375:2: ( rule__PredicatedRuleCall__Group_2__0 )?
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); 
            // InternalXtext.g:6376:2: ( rule__PredicatedRuleCall__Group_2__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==35) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalXtext.g:6376:3: rule__PredicatedRuleCall__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__PredicatedRuleCall__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__2__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__0"
    // InternalXtext.g:6385:1: rule__PredicatedRuleCall__Group_2__0 : rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1 ;
    public final void rule__PredicatedRuleCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6389:1: ( rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1 )
            // InternalXtext.g:6390:2: rule__PredicatedRuleCall__Group_2__0__Impl rule__PredicatedRuleCall__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__PredicatedRuleCall__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__0__Impl"
    // InternalXtext.g:6397:1: rule__PredicatedRuleCall__Group_2__0__Impl : ( '<' ) ;
    public final void rule__PredicatedRuleCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6401:1: ( ( '<' ) )
            // InternalXtext.g:6402:1: ( '<' )
            {
            // InternalXtext.g:6402:1: ( '<' )
            // InternalXtext.g:6403:2: '<'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__1"
    // InternalXtext.g:6412:1: rule__PredicatedRuleCall__Group_2__1 : rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2 ;
    public final void rule__PredicatedRuleCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6416:1: ( rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2 )
            // InternalXtext.g:6417:2: rule__PredicatedRuleCall__Group_2__1__Impl rule__PredicatedRuleCall__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__PredicatedRuleCall__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__1__Impl"
    // InternalXtext.g:6424:1: rule__PredicatedRuleCall__Group_2__1__Impl : ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6428:1: ( ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) ) )
            // InternalXtext.g:6429:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) )
            {
            // InternalXtext.g:6429:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 ) )
            // InternalXtext.g:6430:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); 
            // InternalXtext.g:6431:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_1 )
            // InternalXtext.g:6431:3: rule__PredicatedRuleCall__ArgumentsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__ArgumentsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__2"
    // InternalXtext.g:6439:1: rule__PredicatedRuleCall__Group_2__2 : rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3 ;
    public final void rule__PredicatedRuleCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6443:1: ( rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3 )
            // InternalXtext.g:6444:2: rule__PredicatedRuleCall__Group_2__2__Impl rule__PredicatedRuleCall__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__PredicatedRuleCall__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__2"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__2__Impl"
    // InternalXtext.g:6451:1: rule__PredicatedRuleCall__Group_2__2__Impl : ( ( rule__PredicatedRuleCall__Group_2_2__0 )* ) ;
    public final void rule__PredicatedRuleCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6455:1: ( ( ( rule__PredicatedRuleCall__Group_2_2__0 )* ) )
            // InternalXtext.g:6456:1: ( ( rule__PredicatedRuleCall__Group_2_2__0 )* )
            {
            // InternalXtext.g:6456:1: ( ( rule__PredicatedRuleCall__Group_2_2__0 )* )
            // InternalXtext.g:6457:2: ( rule__PredicatedRuleCall__Group_2_2__0 )*
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); 
            // InternalXtext.g:6458:2: ( rule__PredicatedRuleCall__Group_2_2__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==22) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalXtext.g:6458:3: rule__PredicatedRuleCall__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__PredicatedRuleCall__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__2__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__3"
    // InternalXtext.g:6466:1: rule__PredicatedRuleCall__Group_2__3 : rule__PredicatedRuleCall__Group_2__3__Impl ;
    public final void rule__PredicatedRuleCall__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6470:1: ( rule__PredicatedRuleCall__Group_2__3__Impl )
            // InternalXtext.g:6471:2: rule__PredicatedRuleCall__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__3"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2__3__Impl"
    // InternalXtext.g:6477:1: rule__PredicatedRuleCall__Group_2__3__Impl : ( '>' ) ;
    public final void rule__PredicatedRuleCall__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6481:1: ( ( '>' ) )
            // InternalXtext.g:6482:1: ( '>' )
            {
            // InternalXtext.g:6482:1: ( '>' )
            // InternalXtext.g:6483:2: '>'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,36,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2__3__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__0"
    // InternalXtext.g:6493:1: rule__PredicatedRuleCall__Group_2_2__0 : rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1 ;
    public final void rule__PredicatedRuleCall__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6497:1: ( rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1 )
            // InternalXtext.g:6498:2: rule__PredicatedRuleCall__Group_2_2__0__Impl rule__PredicatedRuleCall__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__PredicatedRuleCall__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__0__Impl"
    // InternalXtext.g:6505:1: rule__PredicatedRuleCall__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__PredicatedRuleCall__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6509:1: ( ( ',' ) )
            // InternalXtext.g:6510:1: ( ',' )
            {
            // InternalXtext.g:6510:1: ( ',' )
            // InternalXtext.g:6511:2: ','
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__1"
    // InternalXtext.g:6520:1: rule__PredicatedRuleCall__Group_2_2__1 : rule__PredicatedRuleCall__Group_2_2__1__Impl ;
    public final void rule__PredicatedRuleCall__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6524:1: ( rule__PredicatedRuleCall__Group_2_2__1__Impl )
            // InternalXtext.g:6525:2: rule__PredicatedRuleCall__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group_2_2__1__Impl"
    // InternalXtext.g:6531:1: rule__PredicatedRuleCall__Group_2_2__1__Impl : ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6535:1: ( ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) ) )
            // InternalXtext.g:6536:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) )
            {
            // InternalXtext.g:6536:1: ( ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 ) )
            // InternalXtext.g:6537:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); 
            // InternalXtext.g:6538:2: ( rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 )
            // InternalXtext.g:6538:3: rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group_2_2__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalXtext.g:6547:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6551:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalXtext.g:6552:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalXtext.g:6559:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__Alternatives_0 )? ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6563:1: ( ( ( rule__Assignment__Alternatives_0 )? ) )
            // InternalXtext.g:6564:1: ( ( rule__Assignment__Alternatives_0 )? )
            {
            // InternalXtext.g:6564:1: ( ( rule__Assignment__Alternatives_0 )? )
            // InternalXtext.g:6565:2: ( rule__Assignment__Alternatives_0 )?
            {
             before(grammarAccess.getAssignmentAccess().getAlternatives_0()); 
            // InternalXtext.g:6566:2: ( rule__Assignment__Alternatives_0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==48||LA64_0==55) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalXtext.g:6566:3: rule__Assignment__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Assignment__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignmentAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalXtext.g:6574:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6578:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalXtext.g:6579:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_49);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalXtext.g:6586:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__FeatureAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6590:1: ( ( ( rule__Assignment__FeatureAssignment_1 ) ) )
            // InternalXtext.g:6591:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            {
            // InternalXtext.g:6591:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            // InternalXtext.g:6592:2: ( rule__Assignment__FeatureAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 
            // InternalXtext.g:6593:2: ( rule__Assignment__FeatureAssignment_1 )
            // InternalXtext.g:6593:3: rule__Assignment__FeatureAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__FeatureAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // InternalXtext.g:6601:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl rule__Assignment__Group__3 ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6605:1: ( rule__Assignment__Group__2__Impl rule__Assignment__Group__3 )
            // InternalXtext.g:6606:2: rule__Assignment__Group__2__Impl rule__Assignment__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__Assignment__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // InternalXtext.g:6613:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__OperatorAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6617:1: ( ( ( rule__Assignment__OperatorAssignment_2 ) ) )
            // InternalXtext.g:6618:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            {
            // InternalXtext.g:6618:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            // InternalXtext.g:6619:2: ( rule__Assignment__OperatorAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 
            // InternalXtext.g:6620:2: ( rule__Assignment__OperatorAssignment_2 )
            // InternalXtext.g:6620:3: rule__Assignment__OperatorAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__OperatorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__Assignment__Group__3"
    // InternalXtext.g:6628:1: rule__Assignment__Group__3 : rule__Assignment__Group__3__Impl ;
    public final void rule__Assignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6632:1: ( rule__Assignment__Group__3__Impl )
            // InternalXtext.g:6633:2: rule__Assignment__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3"


    // $ANTLR start "rule__Assignment__Group__3__Impl"
    // InternalXtext.g:6639:1: rule__Assignment__Group__3__Impl : ( ( rule__Assignment__TerminalAssignment_3 ) ) ;
    public final void rule__Assignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6643:1: ( ( ( rule__Assignment__TerminalAssignment_3 ) ) )
            // InternalXtext.g:6644:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            {
            // InternalXtext.g:6644:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            // InternalXtext.g:6645:2: ( rule__Assignment__TerminalAssignment_3 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 
            // InternalXtext.g:6646:2: ( rule__Assignment__TerminalAssignment_3 )
            // InternalXtext.g:6646:3: rule__Assignment__TerminalAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__TerminalAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0"
    // InternalXtext.g:6655:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6659:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // InternalXtext.g:6660:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__ParenthesizedAssignableElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__0"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0__Impl"
    // InternalXtext.g:6667:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6671:1: ( ( '(' ) )
            // InternalXtext.g:6672:1: ( '(' )
            {
            // InternalXtext.g:6672:1: ( '(' )
            // InternalXtext.g:6673:2: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__1"
    // InternalXtext.g:6682:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6686:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // InternalXtext.g:6687:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__ParenthesizedAssignableElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__1"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__1__Impl"
    // InternalXtext.g:6694:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6698:1: ( ( ruleAssignableAlternatives ) )
            // InternalXtext.g:6699:1: ( ruleAssignableAlternatives )
            {
            // InternalXtext.g:6699:1: ( ruleAssignableAlternatives )
            // InternalXtext.g:6700:2: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableAlternatives();

            state._fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__2"
    // InternalXtext.g:6709:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6713:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // InternalXtext.g:6714:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__2"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__2__Impl"
    // InternalXtext.g:6720:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6724:1: ( ( ')' ) )
            // InternalXtext.g:6725:1: ( ')' )
            {
            // InternalXtext.g:6725:1: ( ')' )
            // InternalXtext.g:6726:2: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__2__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group__0"
    // InternalXtext.g:6736:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6740:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // InternalXtext.g:6741:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__AssignableAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__0"


    // $ANTLR start "rule__AssignableAlternatives__Group__0__Impl"
    // InternalXtext.g:6748:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6752:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:6753:1: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:6753:1: ( ruleAssignableTerminal )
            // InternalXtext.g:6754:2: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group__1"
    // InternalXtext.g:6763:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6767:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // InternalXtext.g:6768:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__1"


    // $ANTLR start "rule__AssignableAlternatives__Group__1__Impl"
    // InternalXtext.g:6774:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6778:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // InternalXtext.g:6779:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // InternalXtext.g:6779:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // InternalXtext.g:6780:2: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:6781:2: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==38) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalXtext.g:6781:3: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AssignableAlternatives__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__0"
    // InternalXtext.g:6790:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6794:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // InternalXtext.g:6795:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__AssignableAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__0__Impl"
    // InternalXtext.g:6802:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6806:1: ( ( () ) )
            // InternalXtext.g:6807:1: ( () )
            {
            // InternalXtext.g:6807:1: ( () )
            // InternalXtext.g:6808:2: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:6809:2: ()
            // InternalXtext.g:6809:3: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1"
    // InternalXtext.g:6817:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6821:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // InternalXtext.g:6822:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1__Impl"
    // InternalXtext.g:6828:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6832:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:6833:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:6833:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:6834:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:6834:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // InternalXtext.g:6835:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:6836:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            // InternalXtext.g:6836:4: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:6839:2: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // InternalXtext.g:6840:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:6841:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==38) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalXtext.g:6841:4: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__AssignableAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0"
    // InternalXtext.g:6851:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6855:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // InternalXtext.g:6856:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__AssignableAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__0"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0__Impl"
    // InternalXtext.g:6863:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6867:1: ( ( '|' ) )
            // InternalXtext.g:6868:1: ( '|' )
            {
            // InternalXtext.g:6868:1: ( '|' )
            // InternalXtext.g:6869:2: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__1"
    // InternalXtext.g:6878:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6882:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // InternalXtext.g:6883:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__1__Impl"
    // InternalXtext.g:6889:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6893:1: ( ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:6894:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:6894:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:6895:2: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:6896:2: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:6896:3: rule__AssignableAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__0"
    // InternalXtext.g:6905:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6909:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // InternalXtext.g:6910:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__CrossReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__0"


    // $ANTLR start "rule__CrossReference__Group__0__Impl"
    // InternalXtext.g:6917:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6921:1: ( ( '[' ) )
            // InternalXtext.g:6922:1: ( '[' )
            {
            // InternalXtext.g:6922:1: ( '[' )
            // InternalXtext.g:6923:2: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,45,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__0__Impl"


    // $ANTLR start "rule__CrossReference__Group__1"
    // InternalXtext.g:6932:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6936:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // InternalXtext.g:6937:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_51);
            rule__CrossReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__1"


    // $ANTLR start "rule__CrossReference__Group__1__Impl"
    // InternalXtext.g:6944:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6948:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // InternalXtext.g:6949:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // InternalXtext.g:6949:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // InternalXtext.g:6950:2: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // InternalXtext.g:6951:2: ( rule__CrossReference__TypeAssignment_1 )
            // InternalXtext.g:6951:3: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__2"
    // InternalXtext.g:6959:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6963:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // InternalXtext.g:6964:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_51);
            rule__CrossReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__2"


    // $ANTLR start "rule__CrossReference__Group__2__Impl"
    // InternalXtext.g:6971:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6975:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // InternalXtext.g:6976:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // InternalXtext.g:6976:1: ( ( rule__CrossReference__Group_2__0 )? )
            // InternalXtext.g:6977:2: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // InternalXtext.g:6978:2: ( rule__CrossReference__Group_2__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==38) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalXtext.g:6978:3: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__CrossReference__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__2__Impl"


    // $ANTLR start "rule__CrossReference__Group__3"
    // InternalXtext.g:6986:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:6990:1: ( rule__CrossReference__Group__3__Impl )
            // InternalXtext.g:6991:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__3"


    // $ANTLR start "rule__CrossReference__Group__3__Impl"
    // InternalXtext.g:6997:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7001:1: ( ( ']' ) )
            // InternalXtext.g:7002:1: ( ']' )
            {
            // InternalXtext.g:7002:1: ( ']' )
            // InternalXtext.g:7003:2: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,46,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__3__Impl"


    // $ANTLR start "rule__CrossReference__Group_2__0"
    // InternalXtext.g:7013:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7017:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // InternalXtext.g:7018:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_52);
            rule__CrossReference__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__0"


    // $ANTLR start "rule__CrossReference__Group_2__0__Impl"
    // InternalXtext.g:7025:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7029:1: ( ( '|' ) )
            // InternalXtext.g:7030:1: ( '|' )
            {
            // InternalXtext.g:7030:1: ( '|' )
            // InternalXtext.g:7031:2: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__0__Impl"


    // $ANTLR start "rule__CrossReference__Group_2__1"
    // InternalXtext.g:7040:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7044:1: ( rule__CrossReference__Group_2__1__Impl )
            // InternalXtext.g:7045:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__1"


    // $ANTLR start "rule__CrossReference__Group_2__1__Impl"
    // InternalXtext.g:7051:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7055:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // InternalXtext.g:7056:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // InternalXtext.g:7056:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // InternalXtext.g:7057:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // InternalXtext.g:7058:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            // InternalXtext.g:7058:3: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__TerminalAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__0"
    // InternalXtext.g:7067:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7071:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // InternalXtext.g:7072:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__ParenthesizedElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__0"


    // $ANTLR start "rule__ParenthesizedElement__Group__0__Impl"
    // InternalXtext.g:7079:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7083:1: ( ( '(' ) )
            // InternalXtext.g:7084:1: ( '(' )
            {
            // InternalXtext.g:7084:1: ( '(' )
            // InternalXtext.g:7085:2: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__1"
    // InternalXtext.g:7094:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7098:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // InternalXtext.g:7099:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__ParenthesizedElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__1"


    // $ANTLR start "rule__ParenthesizedElement__Group__1__Impl"
    // InternalXtext.g:7106:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7110:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:7111:1: ( ruleAlternatives )
            {
            // InternalXtext.g:7111:1: ( ruleAlternatives )
            // InternalXtext.g:7112:2: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__2"
    // InternalXtext.g:7121:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7125:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // InternalXtext.g:7126:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__2"


    // $ANTLR start "rule__ParenthesizedElement__Group__2__Impl"
    // InternalXtext.g:7132:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7136:1: ( ( ')' ) )
            // InternalXtext.g:7137:1: ( ')' )
            {
            // InternalXtext.g:7137:1: ( ')' )
            // InternalXtext.g:7138:2: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__2__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__0"
    // InternalXtext.g:7148:1: rule__PredicatedGroup__Group__0 : rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 ;
    public final void rule__PredicatedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7152:1: ( rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 )
            // InternalXtext.g:7153:2: rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__PredicatedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__0"


    // $ANTLR start "rule__PredicatedGroup__Group__0__Impl"
    // InternalXtext.g:7160:1: rule__PredicatedGroup__Group__0__Impl : ( ( rule__PredicatedGroup__Alternatives_0 ) ) ;
    public final void rule__PredicatedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7164:1: ( ( ( rule__PredicatedGroup__Alternatives_0 ) ) )
            // InternalXtext.g:7165:1: ( ( rule__PredicatedGroup__Alternatives_0 ) )
            {
            // InternalXtext.g:7165:1: ( ( rule__PredicatedGroup__Alternatives_0 ) )
            // InternalXtext.g:7166:2: ( rule__PredicatedGroup__Alternatives_0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); 
            // InternalXtext.g:7167:2: ( rule__PredicatedGroup__Alternatives_0 )
            // InternalXtext.g:7167:3: rule__PredicatedGroup__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__0__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__1"
    // InternalXtext.g:7175:1: rule__PredicatedGroup__Group__1 : rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 ;
    public final void rule__PredicatedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7179:1: ( rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 )
            // InternalXtext.g:7180:2: rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__PredicatedGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__1"


    // $ANTLR start "rule__PredicatedGroup__Group__1__Impl"
    // InternalXtext.g:7187:1: rule__PredicatedGroup__Group__1__Impl : ( '(' ) ;
    public final void rule__PredicatedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7191:1: ( ( '(' ) )
            // InternalXtext.g:7192:1: ( '(' )
            {
            // InternalXtext.g:7192:1: ( '(' )
            // InternalXtext.g:7193:2: '('
            {
             before(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__1__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__2"
    // InternalXtext.g:7202:1: rule__PredicatedGroup__Group__2 : rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 ;
    public final void rule__PredicatedGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7206:1: ( rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 )
            // InternalXtext.g:7207:2: rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__PredicatedGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__2"


    // $ANTLR start "rule__PredicatedGroup__Group__2__Impl"
    // InternalXtext.g:7214:1: rule__PredicatedGroup__Group__2__Impl : ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) ;
    public final void rule__PredicatedGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7218:1: ( ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) )
            // InternalXtext.g:7219:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            {
            // InternalXtext.g:7219:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            // InternalXtext.g:7220:2: ( rule__PredicatedGroup__ElementsAssignment_2 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 
            // InternalXtext.g:7221:2: ( rule__PredicatedGroup__ElementsAssignment_2 )
            // InternalXtext.g:7221:3: rule__PredicatedGroup__ElementsAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__2__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__3"
    // InternalXtext.g:7229:1: rule__PredicatedGroup__Group__3 : rule__PredicatedGroup__Group__3__Impl ;
    public final void rule__PredicatedGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7233:1: ( rule__PredicatedGroup__Group__3__Impl )
            // InternalXtext.g:7234:2: rule__PredicatedGroup__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__3"


    // $ANTLR start "rule__PredicatedGroup__Group__3__Impl"
    // InternalXtext.g:7240:1: rule__PredicatedGroup__Group__3__Impl : ( ')' ) ;
    public final void rule__PredicatedGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7244:1: ( ( ')' ) )
            // InternalXtext.g:7245:1: ( ')' )
            {
            // InternalXtext.g:7245:1: ( ')' )
            // InternalXtext.g:7246:2: ')'
            {
             before(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__0"
    // InternalXtext.g:7256:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7260:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // InternalXtext.g:7261:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_53);
            rule__TerminalRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__0"


    // $ANTLR start "rule__TerminalRule__Group__0__Impl"
    // InternalXtext.g:7268:1: rule__TerminalRule__Group__0__Impl : ( ( rule__TerminalRule__AnnotationsAssignment_0 )* ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7272:1: ( ( ( rule__TerminalRule__AnnotationsAssignment_0 )* ) )
            // InternalXtext.g:7273:1: ( ( rule__TerminalRule__AnnotationsAssignment_0 )* )
            {
            // InternalXtext.g:7273:1: ( ( rule__TerminalRule__AnnotationsAssignment_0 )* )
            // InternalXtext.g:7274:2: ( rule__TerminalRule__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0()); 
            // InternalXtext.g:7275:2: ( rule__TerminalRule__AnnotationsAssignment_0 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==31) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalXtext.g:7275:3: rule__TerminalRule__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__TerminalRule__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

             after(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group__1"
    // InternalXtext.g:7283:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7287:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // InternalXtext.g:7288:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_54);
            rule__TerminalRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__1"


    // $ANTLR start "rule__TerminalRule__Group__1__Impl"
    // InternalXtext.g:7295:1: rule__TerminalRule__Group__1__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7299:1: ( ( 'terminal' ) )
            // InternalXtext.g:7300:1: ( 'terminal' )
            {
            // InternalXtext.g:7300:1: ( 'terminal' )
            // InternalXtext.g:7301:2: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1()); 
            match(input,47,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group__2"
    // InternalXtext.g:7310:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7314:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // InternalXtext.g:7315:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_55);
            rule__TerminalRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__2"


    // $ANTLR start "rule__TerminalRule__Group__2__Impl"
    // InternalXtext.g:7322:1: rule__TerminalRule__Group__2__Impl : ( ( rule__TerminalRule__Alternatives_2 ) ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7326:1: ( ( ( rule__TerminalRule__Alternatives_2 ) ) )
            // InternalXtext.g:7327:1: ( ( rule__TerminalRule__Alternatives_2 ) )
            {
            // InternalXtext.g:7327:1: ( ( rule__TerminalRule__Alternatives_2 ) )
            // InternalXtext.g:7328:2: ( rule__TerminalRule__Alternatives_2 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternatives_2()); 
            // InternalXtext.g:7329:2: ( rule__TerminalRule__Alternatives_2 )
            // InternalXtext.g:7329:3: rule__TerminalRule__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__2__Impl"


    // $ANTLR start "rule__TerminalRule__Group__3"
    // InternalXtext.g:7337:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7341:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // InternalXtext.g:7342:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__TerminalRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__3"


    // $ANTLR start "rule__TerminalRule__Group__3__Impl"
    // InternalXtext.g:7349:1: rule__TerminalRule__Group__3__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7353:1: ( ( ':' ) )
            // InternalXtext.g:7354:1: ( ':' )
            {
            // InternalXtext.g:7354:1: ( ':' )
            // InternalXtext.g:7355:2: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__4"
    // InternalXtext.g:7364:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7368:1: ( rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5 )
            // InternalXtext.g:7369:2: rule__TerminalRule__Group__4__Impl rule__TerminalRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__TerminalRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__4"


    // $ANTLR start "rule__TerminalRule__Group__4__Impl"
    // InternalXtext.g:7376:1: rule__TerminalRule__Group__4__Impl : ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7380:1: ( ( ( rule__TerminalRule__AlternativesAssignment_4 ) ) )
            // InternalXtext.g:7381:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            {
            // InternalXtext.g:7381:1: ( ( rule__TerminalRule__AlternativesAssignment_4 ) )
            // InternalXtext.g:7382:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtext.g:7383:2: ( rule__TerminalRule__AlternativesAssignment_4 )
            // InternalXtext.g:7383:3: rule__TerminalRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__AlternativesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__4__Impl"


    // $ANTLR start "rule__TerminalRule__Group__5"
    // InternalXtext.g:7391:1: rule__TerminalRule__Group__5 : rule__TerminalRule__Group__5__Impl ;
    public final void rule__TerminalRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7395:1: ( rule__TerminalRule__Group__5__Impl )
            // InternalXtext.g:7396:2: rule__TerminalRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__5"


    // $ANTLR start "rule__TerminalRule__Group__5__Impl"
    // InternalXtext.g:7402:1: rule__TerminalRule__Group__5__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7406:1: ( ( ';' ) )
            // InternalXtext.g:7407:1: ( ';' )
            {
            // InternalXtext.g:7407:1: ( ';' )
            // InternalXtext.g:7408:2: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__5__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_0__0"
    // InternalXtext.g:7418:1: rule__TerminalRule__Group_2_0__0 : rule__TerminalRule__Group_2_0__0__Impl rule__TerminalRule__Group_2_0__1 ;
    public final void rule__TerminalRule__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7422:1: ( rule__TerminalRule__Group_2_0__0__Impl rule__TerminalRule__Group_2_0__1 )
            // InternalXtext.g:7423:2: rule__TerminalRule__Group_2_0__0__Impl rule__TerminalRule__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TerminalRule__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__0"


    // $ANTLR start "rule__TerminalRule__Group_2_0__0__Impl"
    // InternalXtext.g:7430:1: rule__TerminalRule__Group_2_0__0__Impl : ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) ) ;
    public final void rule__TerminalRule__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7434:1: ( ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) ) )
            // InternalXtext.g:7435:1: ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) )
            {
            // InternalXtext.g:7435:1: ( ( rule__TerminalRule__FragmentAssignment_2_0_0 ) )
            // InternalXtext.g:7436:2: ( rule__TerminalRule__FragmentAssignment_2_0_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0()); 
            // InternalXtext.g:7437:2: ( rule__TerminalRule__FragmentAssignment_2_0_0 )
            // InternalXtext.g:7437:3: rule__TerminalRule__FragmentAssignment_2_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__FragmentAssignment_2_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_0__1"
    // InternalXtext.g:7445:1: rule__TerminalRule__Group_2_0__1 : rule__TerminalRule__Group_2_0__1__Impl ;
    public final void rule__TerminalRule__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7449:1: ( rule__TerminalRule__Group_2_0__1__Impl )
            // InternalXtext.g:7450:2: rule__TerminalRule__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__1"


    // $ANTLR start "rule__TerminalRule__Group_2_0__1__Impl"
    // InternalXtext.g:7456:1: rule__TerminalRule__Group_2_0__1__Impl : ( ( rule__TerminalRule__NameAssignment_2_0_1 ) ) ;
    public final void rule__TerminalRule__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7460:1: ( ( ( rule__TerminalRule__NameAssignment_2_0_1 ) ) )
            // InternalXtext.g:7461:1: ( ( rule__TerminalRule__NameAssignment_2_0_1 ) )
            {
            // InternalXtext.g:7461:1: ( ( rule__TerminalRule__NameAssignment_2_0_1 ) )
            // InternalXtext.g:7462:2: ( rule__TerminalRule__NameAssignment_2_0_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1()); 
            // InternalXtext.g:7463:2: ( rule__TerminalRule__NameAssignment_2_0_1 )
            // InternalXtext.g:7463:3: rule__TerminalRule__NameAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__NameAssignment_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_0__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1__0"
    // InternalXtext.g:7472:1: rule__TerminalRule__Group_2_1__0 : rule__TerminalRule__Group_2_1__0__Impl rule__TerminalRule__Group_2_1__1 ;
    public final void rule__TerminalRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7476:1: ( rule__TerminalRule__Group_2_1__0__Impl rule__TerminalRule__Group_2_1__1 )
            // InternalXtext.g:7477:2: rule__TerminalRule__Group_2_1__0__Impl rule__TerminalRule__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__TerminalRule__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__0"


    // $ANTLR start "rule__TerminalRule__Group_2_1__0__Impl"
    // InternalXtext.g:7484:1: rule__TerminalRule__Group_2_1__0__Impl : ( ( rule__TerminalRule__NameAssignment_2_1_0 ) ) ;
    public final void rule__TerminalRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7488:1: ( ( ( rule__TerminalRule__NameAssignment_2_1_0 ) ) )
            // InternalXtext.g:7489:1: ( ( rule__TerminalRule__NameAssignment_2_1_0 ) )
            {
            // InternalXtext.g:7489:1: ( ( rule__TerminalRule__NameAssignment_2_1_0 ) )
            // InternalXtext.g:7490:2: ( rule__TerminalRule__NameAssignment_2_1_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0()); 
            // InternalXtext.g:7491:2: ( rule__TerminalRule__NameAssignment_2_1_0 )
            // InternalXtext.g:7491:3: rule__TerminalRule__NameAssignment_2_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__NameAssignment_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1__1"
    // InternalXtext.g:7499:1: rule__TerminalRule__Group_2_1__1 : rule__TerminalRule__Group_2_1__1__Impl ;
    public final void rule__TerminalRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7503:1: ( rule__TerminalRule__Group_2_1__1__Impl )
            // InternalXtext.g:7504:2: rule__TerminalRule__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__1"


    // $ANTLR start "rule__TerminalRule__Group_2_1__1__Impl"
    // InternalXtext.g:7510:1: rule__TerminalRule__Group_2_1__1__Impl : ( ( rule__TerminalRule__Group_2_1_1__0 )? ) ;
    public final void rule__TerminalRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7514:1: ( ( ( rule__TerminalRule__Group_2_1_1__0 )? ) )
            // InternalXtext.g:7515:1: ( ( rule__TerminalRule__Group_2_1_1__0 )? )
            {
            // InternalXtext.g:7515:1: ( ( rule__TerminalRule__Group_2_1_1__0 )? )
            // InternalXtext.g:7516:2: ( rule__TerminalRule__Group_2_1_1__0 )?
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1()); 
            // InternalXtext.g:7517:2: ( rule__TerminalRule__Group_2_1_1__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==34) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalXtext.g:7517:3: rule__TerminalRule__Group_2_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_2_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__0"
    // InternalXtext.g:7526:1: rule__TerminalRule__Group_2_1_1__0 : rule__TerminalRule__Group_2_1_1__0__Impl rule__TerminalRule__Group_2_1_1__1 ;
    public final void rule__TerminalRule__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7530:1: ( rule__TerminalRule__Group_2_1_1__0__Impl rule__TerminalRule__Group_2_1_1__1 )
            // InternalXtext.g:7531:2: rule__TerminalRule__Group_2_1_1__0__Impl rule__TerminalRule__Group_2_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__TerminalRule__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__0"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__0__Impl"
    // InternalXtext.g:7538:1: rule__TerminalRule__Group_2_1_1__0__Impl : ( 'returns' ) ;
    public final void rule__TerminalRule__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7542:1: ( ( 'returns' ) )
            // InternalXtext.g:7543:1: ( 'returns' )
            {
            // InternalXtext.g:7543:1: ( 'returns' )
            // InternalXtext.g:7544:2: 'returns'
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__1"
    // InternalXtext.g:7553:1: rule__TerminalRule__Group_2_1_1__1 : rule__TerminalRule__Group_2_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7557:1: ( rule__TerminalRule__Group_2_1_1__1__Impl )
            // InternalXtext.g:7558:2: rule__TerminalRule__Group_2_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_2_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__1"


    // $ANTLR start "rule__TerminalRule__Group_2_1_1__1__Impl"
    // InternalXtext.g:7564:1: rule__TerminalRule__Group_2_1_1__1__Impl : ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) ) ;
    public final void rule__TerminalRule__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7568:1: ( ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) ) )
            // InternalXtext.g:7569:1: ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) )
            {
            // InternalXtext.g:7569:1: ( ( rule__TerminalRule__TypeAssignment_2_1_1_1 ) )
            // InternalXtext.g:7570:2: ( rule__TerminalRule__TypeAssignment_2_1_1_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1()); 
            // InternalXtext.g:7571:2: ( rule__TerminalRule__TypeAssignment_2_1_1_1 )
            // InternalXtext.g:7571:3: rule__TerminalRule__TypeAssignment_2_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__TypeAssignment_2_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_2_1_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__0"
    // InternalXtext.g:7580:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7584:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // InternalXtext.g:7585:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__TerminalAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__0"


    // $ANTLR start "rule__TerminalAlternatives__Group__0__Impl"
    // InternalXtext.g:7592:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7596:1: ( ( ruleTerminalGroup ) )
            // InternalXtext.g:7597:1: ( ruleTerminalGroup )
            {
            // InternalXtext.g:7597:1: ( ruleTerminalGroup )
            // InternalXtext.g:7598:2: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__1"
    // InternalXtext.g:7607:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7611:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // InternalXtext.g:7612:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__1"


    // $ANTLR start "rule__TerminalAlternatives__Group__1__Impl"
    // InternalXtext.g:7618:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7622:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // InternalXtext.g:7623:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // InternalXtext.g:7623:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // InternalXtext.g:7624:2: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // InternalXtext.g:7625:2: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==38) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalXtext.g:7625:3: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalAlternatives__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__0"
    // InternalXtext.g:7634:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7638:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // InternalXtext.g:7639:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__TerminalAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__0__Impl"
    // InternalXtext.g:7646:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7650:1: ( ( () ) )
            // InternalXtext.g:7651:1: ( () )
            {
            // InternalXtext.g:7651:1: ( () )
            // InternalXtext.g:7652:2: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:7653:2: ()
            // InternalXtext.g:7653:3: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1"
    // InternalXtext.g:7661:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7665:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // InternalXtext.g:7666:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1__Impl"
    // InternalXtext.g:7672:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7676:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtext.g:7677:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:7677:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // InternalXtext.g:7678:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // InternalXtext.g:7678:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // InternalXtext.g:7679:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:7680:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            // InternalXtext.g:7680:4: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:7683:2: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // InternalXtext.g:7684:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtext.g:7685:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==38) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalXtext.g:7685:4: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__TerminalAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0"
    // InternalXtext.g:7695:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7699:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // InternalXtext.g:7700:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__TerminalAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__0"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0__Impl"
    // InternalXtext.g:7707:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7711:1: ( ( '|' ) )
            // InternalXtext.g:7712:1: ( '|' )
            {
            // InternalXtext.g:7712:1: ( '|' )
            // InternalXtext.g:7713:2: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__1"
    // InternalXtext.g:7722:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7726:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // InternalXtext.g:7727:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__1__Impl"
    // InternalXtext.g:7733:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7737:1: ( ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:7738:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:7738:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:7739:2: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:7740:2: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtext.g:7740:3: rule__TerminalAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__0"
    // InternalXtext.g:7749:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7753:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // InternalXtext.g:7754:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__TerminalGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__0"


    // $ANTLR start "rule__TerminalGroup__Group__0__Impl"
    // InternalXtext.g:7761:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7765:1: ( ( ruleTerminalToken ) )
            // InternalXtext.g:7766:1: ( ruleTerminalToken )
            {
            // InternalXtext.g:7766:1: ( ruleTerminalToken )
            // InternalXtext.g:7767:2: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__1"
    // InternalXtext.g:7776:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7780:1: ( rule__TerminalGroup__Group__1__Impl )
            // InternalXtext.g:7781:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__1"


    // $ANTLR start "rule__TerminalGroup__Group__1__Impl"
    // InternalXtext.g:7787:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7791:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // InternalXtext.g:7792:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // InternalXtext.g:7792:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // InternalXtext.g:7793:2: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // InternalXtext.g:7794:2: ( rule__TerminalGroup__Group_1__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID||LA72_0==RULE_STRING||(LA72_0>=17 && LA72_0<=18)||LA72_0==23||LA72_0==27||LA72_0==44||(LA72_0>=48 && LA72_0<=49)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalXtext.g:7794:3: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalGroup__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__0"
    // InternalXtext.g:7803:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7807:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // InternalXtext.g:7808:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__TerminalGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__0"


    // $ANTLR start "rule__TerminalGroup__Group_1__0__Impl"
    // InternalXtext.g:7815:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7819:1: ( ( () ) )
            // InternalXtext.g:7820:1: ( () )
            {
            // InternalXtext.g:7820:1: ( () )
            // InternalXtext.g:7821:2: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtext.g:7822:2: ()
            // InternalXtext.g:7822:3: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__1"
    // InternalXtext.g:7830:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7834:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // InternalXtext.g:7835:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__1"


    // $ANTLR start "rule__TerminalGroup__Group_1__1__Impl"
    // InternalXtext.g:7841:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7845:1: ( ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) )
            // InternalXtext.g:7846:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtext.g:7846:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            // InternalXtext.g:7847:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            {
            // InternalXtext.g:7847:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) )
            // InternalXtext.g:7848:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:7849:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            // InternalXtext.g:7849:4: rule__TerminalGroup__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_57);
            rule__TerminalGroup__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtext.g:7852:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            // InternalXtext.g:7853:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtext.g:7854:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID||LA73_0==RULE_STRING||(LA73_0>=17 && LA73_0<=18)||LA73_0==23||LA73_0==27||LA73_0==44||(LA73_0>=48 && LA73_0<=49)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalXtext.g:7854:4: rule__TerminalGroup__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_57);
            	    rule__TerminalGroup__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalToken__Group__0"
    // InternalXtext.g:7864:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7868:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // InternalXtext.g:7869:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_39);
            rule__TerminalToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__0"


    // $ANTLR start "rule__TerminalToken__Group__0__Impl"
    // InternalXtext.g:7876:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7880:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:7881:1: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:7881:1: ( ruleTerminalTokenElement )
            // InternalXtext.g:7882:2: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__0__Impl"


    // $ANTLR start "rule__TerminalToken__Group__1"
    // InternalXtext.g:7891:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7895:1: ( rule__TerminalToken__Group__1__Impl )
            // InternalXtext.g:7896:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__1"


    // $ANTLR start "rule__TerminalToken__Group__1__Impl"
    // InternalXtext.g:7902:1: rule__TerminalToken__Group__1__Impl : ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7906:1: ( ( ( rule__TerminalToken__CardinalityAssignment_1 )? ) )
            // InternalXtext.g:7907:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            {
            // InternalXtext.g:7907:1: ( ( rule__TerminalToken__CardinalityAssignment_1 )? )
            // InternalXtext.g:7908:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 
            // InternalXtext.g:7909:2: ( rule__TerminalToken__CardinalityAssignment_1 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=12 && LA74_0<=14)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalXtext.g:7909:3: rule__TerminalToken__CardinalityAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalToken__CardinalityAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__0"
    // InternalXtext.g:7918:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7922:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // InternalXtext.g:7923:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__ParenthesizedTerminalElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__0"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__0__Impl"
    // InternalXtext.g:7930:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7934:1: ( ( '(' ) )
            // InternalXtext.g:7935:1: ( '(' )
            {
            // InternalXtext.g:7935:1: ( '(' )
            // InternalXtext.g:7936:2: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__1"
    // InternalXtext.g:7945:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7949:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // InternalXtext.g:7950:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__ParenthesizedTerminalElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__1"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__1__Impl"
    // InternalXtext.g:7957:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7961:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtext.g:7962:1: ( ruleTerminalAlternatives )
            {
            // InternalXtext.g:7962:1: ( ruleTerminalAlternatives )
            // InternalXtext.g:7963:2: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__2"
    // InternalXtext.g:7972:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7976:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // InternalXtext.g:7977:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__2"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__2__Impl"
    // InternalXtext.g:7983:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:7987:1: ( ( ')' ) )
            // InternalXtext.g:7988:1: ( ')' )
            {
            // InternalXtext.g:7988:1: ( ')' )
            // InternalXtext.g:7989:2: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__2__Impl"


    // $ANTLR start "rule__NegatedToken__Group__0"
    // InternalXtext.g:7999:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8003:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // InternalXtext.g:8004:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__NegatedToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__0"


    // $ANTLR start "rule__NegatedToken__Group__0__Impl"
    // InternalXtext.g:8011:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8015:1: ( ( '!' ) )
            // InternalXtext.g:8016:1: ( '!' )
            {
            // InternalXtext.g:8016:1: ( '!' )
            // InternalXtext.g:8017:2: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__0__Impl"


    // $ANTLR start "rule__NegatedToken__Group__1"
    // InternalXtext.g:8026:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8030:1: ( rule__NegatedToken__Group__1__Impl )
            // InternalXtext.g:8031:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__1"


    // $ANTLR start "rule__NegatedToken__Group__1__Impl"
    // InternalXtext.g:8037:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8041:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // InternalXtext.g:8042:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // InternalXtext.g:8042:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // InternalXtext.g:8043:2: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // InternalXtext.g:8044:2: ( rule__NegatedToken__TerminalAssignment_1 )
            // InternalXtext.g:8044:3: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__TerminalAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__1__Impl"


    // $ANTLR start "rule__UntilToken__Group__0"
    // InternalXtext.g:8053:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8057:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // InternalXtext.g:8058:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__UntilToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__0"


    // $ANTLR start "rule__UntilToken__Group__0__Impl"
    // InternalXtext.g:8065:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8069:1: ( ( '->' ) )
            // InternalXtext.g:8070:1: ( '->' )
            {
            // InternalXtext.g:8070:1: ( '->' )
            // InternalXtext.g:8071:2: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__0__Impl"


    // $ANTLR start "rule__UntilToken__Group__1"
    // InternalXtext.g:8080:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8084:1: ( rule__UntilToken__Group__1__Impl )
            // InternalXtext.g:8085:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__1"


    // $ANTLR start "rule__UntilToken__Group__1__Impl"
    // InternalXtext.g:8091:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8095:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // InternalXtext.g:8096:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // InternalXtext.g:8096:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // InternalXtext.g:8097:2: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // InternalXtext.g:8098:2: ( rule__UntilToken__TerminalAssignment_1 )
            // InternalXtext.g:8098:3: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__TerminalAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__1__Impl"


    // $ANTLR start "rule__Wildcard__Group__0"
    // InternalXtext.g:8107:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8111:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalXtext.g:8112:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Wildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Wildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__0"


    // $ANTLR start "rule__Wildcard__Group__0__Impl"
    // InternalXtext.g:8119:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8123:1: ( ( () ) )
            // InternalXtext.g:8124:1: ( () )
            {
            // InternalXtext.g:8124:1: ( () )
            // InternalXtext.g:8125:2: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // InternalXtext.g:8126:2: ()
            // InternalXtext.g:8126:3: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__0__Impl"


    // $ANTLR start "rule__Wildcard__Group__1"
    // InternalXtext.g:8134:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8138:1: ( rule__Wildcard__Group__1__Impl )
            // InternalXtext.g:8139:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Wildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__1"


    // $ANTLR start "rule__Wildcard__Group__1__Impl"
    // InternalXtext.g:8145:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8149:1: ( ( '.' ) )
            // InternalXtext.g:8150:1: ( '.' )
            {
            // InternalXtext.g:8150:1: ( '.' )
            // InternalXtext.g:8151:2: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__1__Impl"


    // $ANTLR start "rule__EOF__Group__0"
    // InternalXtext.g:8161:1: rule__EOF__Group__0 : rule__EOF__Group__0__Impl rule__EOF__Group__1 ;
    public final void rule__EOF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8165:1: ( rule__EOF__Group__0__Impl rule__EOF__Group__1 )
            // InternalXtext.g:8166:2: rule__EOF__Group__0__Impl rule__EOF__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_56);
            rule__EOF__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__0"


    // $ANTLR start "rule__EOF__Group__0__Impl"
    // InternalXtext.g:8173:1: rule__EOF__Group__0__Impl : ( () ) ;
    public final void rule__EOF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8177:1: ( ( () ) )
            // InternalXtext.g:8178:1: ( () )
            {
            // InternalXtext.g:8178:1: ( () )
            // InternalXtext.g:8179:2: ()
            {
             before(grammarAccess.getEOFAccess().getEOFAction_0()); 
            // InternalXtext.g:8180:2: ()
            // InternalXtext.g:8180:3: 
            {
            }

             after(grammarAccess.getEOFAccess().getEOFAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__0__Impl"


    // $ANTLR start "rule__EOF__Group__1"
    // InternalXtext.g:8188:1: rule__EOF__Group__1 : rule__EOF__Group__1__Impl ;
    public final void rule__EOF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8192:1: ( rule__EOF__Group__1__Impl )
            // InternalXtext.g:8193:2: rule__EOF__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__1"


    // $ANTLR start "rule__EOF__Group__1__Impl"
    // InternalXtext.g:8199:1: rule__EOF__Group__1__Impl : ( 'EOF' ) ;
    public final void rule__EOF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8203:1: ( ( 'EOF' ) )
            // InternalXtext.g:8204:1: ( 'EOF' )
            {
            // InternalXtext.g:8204:1: ( 'EOF' )
            // InternalXtext.g:8205:2: 'EOF'
            {
             before(grammarAccess.getEOFAccess().getEOFKeyword_1()); 
            match(input,49,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEOFAccess().getEOFKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group__0"
    // InternalXtext.g:8215:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8219:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // InternalXtext.g:8220:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_58);
            rule__CharacterRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__0"


    // $ANTLR start "rule__CharacterRange__Group__0__Impl"
    // InternalXtext.g:8227:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8231:1: ( ( ruleKeyword ) )
            // InternalXtext.g:8232:1: ( ruleKeyword )
            {
            // InternalXtext.g:8232:1: ( ruleKeyword )
            // InternalXtext.g:8233:2: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__0__Impl"


    // $ANTLR start "rule__CharacterRange__Group__1"
    // InternalXtext.g:8242:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8246:1: ( rule__CharacterRange__Group__1__Impl )
            // InternalXtext.g:8247:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__1"


    // $ANTLR start "rule__CharacterRange__Group__1__Impl"
    // InternalXtext.g:8253:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8257:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // InternalXtext.g:8258:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // InternalXtext.g:8258:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // InternalXtext.g:8259:2: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // InternalXtext.g:8260:2: ( rule__CharacterRange__Group_1__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==50) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalXtext.g:8260:3: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__CharacterRange__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCharacterRangeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__0"
    // InternalXtext.g:8269:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8273:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // InternalXtext.g:8274:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_58);
            rule__CharacterRange__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__0"


    // $ANTLR start "rule__CharacterRange__Group_1__0__Impl"
    // InternalXtext.g:8281:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8285:1: ( ( () ) )
            // InternalXtext.g:8286:1: ( () )
            {
            // InternalXtext.g:8286:1: ( () )
            // InternalXtext.g:8287:2: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // InternalXtext.g:8288:2: ()
            // InternalXtext.g:8288:3: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__0__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__1"
    // InternalXtext.g:8296:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8300:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // InternalXtext.g:8301:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__CharacterRange__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__1"


    // $ANTLR start "rule__CharacterRange__Group_1__1__Impl"
    // InternalXtext.g:8308:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8312:1: ( ( '..' ) )
            // InternalXtext.g:8313:1: ( '..' )
            {
            // InternalXtext.g:8313:1: ( '..' )
            // InternalXtext.g:8314:2: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,50,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__2"
    // InternalXtext.g:8323:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8327:1: ( rule__CharacterRange__Group_1__2__Impl )
            // InternalXtext.g:8328:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__2"


    // $ANTLR start "rule__CharacterRange__Group_1__2__Impl"
    // InternalXtext.g:8334:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8338:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // InternalXtext.g:8339:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // InternalXtext.g:8339:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // InternalXtext.g:8340:2: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // InternalXtext.g:8341:2: ( rule__CharacterRange__RightAssignment_1_2 )
            // InternalXtext.g:8341:3: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__2__Impl"


    // $ANTLR start "rule__EnumRule__Group__0"
    // InternalXtext.g:8350:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8354:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // InternalXtext.g:8355:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__EnumRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__0"


    // $ANTLR start "rule__EnumRule__Group__0__Impl"
    // InternalXtext.g:8362:1: rule__EnumRule__Group__0__Impl : ( ( rule__EnumRule__AnnotationsAssignment_0 )* ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8366:1: ( ( ( rule__EnumRule__AnnotationsAssignment_0 )* ) )
            // InternalXtext.g:8367:1: ( ( rule__EnumRule__AnnotationsAssignment_0 )* )
            {
            // InternalXtext.g:8367:1: ( ( rule__EnumRule__AnnotationsAssignment_0 )* )
            // InternalXtext.g:8368:2: ( rule__EnumRule__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0()); 
            // InternalXtext.g:8369:2: ( rule__EnumRule__AnnotationsAssignment_0 )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==31) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalXtext.g:8369:3: rule__EnumRule__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_20);
            	    rule__EnumRule__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

             after(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__0__Impl"


    // $ANTLR start "rule__EnumRule__Group__1"
    // InternalXtext.g:8377:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8381:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // InternalXtext.g:8382:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__EnumRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__1"


    // $ANTLR start "rule__EnumRule__Group__1__Impl"
    // InternalXtext.g:8389:1: rule__EnumRule__Group__1__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8393:1: ( ( 'enum' ) )
            // InternalXtext.g:8394:1: ( 'enum' )
            {
            // InternalXtext.g:8394:1: ( 'enum' )
            // InternalXtext.g:8395:2: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_1()); 
            match(input,51,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__1__Impl"


    // $ANTLR start "rule__EnumRule__Group__2"
    // InternalXtext.g:8404:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8408:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // InternalXtext.g:8409:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_59);
            rule__EnumRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__2"


    // $ANTLR start "rule__EnumRule__Group__2__Impl"
    // InternalXtext.g:8416:1: rule__EnumRule__Group__2__Impl : ( ( rule__EnumRule__NameAssignment_2 ) ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8420:1: ( ( ( rule__EnumRule__NameAssignment_2 ) ) )
            // InternalXtext.g:8421:1: ( ( rule__EnumRule__NameAssignment_2 ) )
            {
            // InternalXtext.g:8421:1: ( ( rule__EnumRule__NameAssignment_2 ) )
            // InternalXtext.g:8422:2: ( rule__EnumRule__NameAssignment_2 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_2()); 
            // InternalXtext.g:8423:2: ( rule__EnumRule__NameAssignment_2 )
            // InternalXtext.g:8423:3: rule__EnumRule__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__2__Impl"


    // $ANTLR start "rule__EnumRule__Group__3"
    // InternalXtext.g:8431:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8435:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // InternalXtext.g:8436:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_59);
            rule__EnumRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__3"


    // $ANTLR start "rule__EnumRule__Group__3__Impl"
    // InternalXtext.g:8443:1: rule__EnumRule__Group__3__Impl : ( ( rule__EnumRule__Group_3__0 )? ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8447:1: ( ( ( rule__EnumRule__Group_3__0 )? ) )
            // InternalXtext.g:8448:1: ( ( rule__EnumRule__Group_3__0 )? )
            {
            // InternalXtext.g:8448:1: ( ( rule__EnumRule__Group_3__0 )? )
            // InternalXtext.g:8449:2: ( rule__EnumRule__Group_3__0 )?
            {
             before(grammarAccess.getEnumRuleAccess().getGroup_3()); 
            // InternalXtext.g:8450:2: ( rule__EnumRule__Group_3__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==34) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalXtext.g:8450:3: rule__EnumRule__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EnumRule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__3__Impl"


    // $ANTLR start "rule__EnumRule__Group__4"
    // InternalXtext.g:8458:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8462:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // InternalXtext.g:8463:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__EnumRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__4"


    // $ANTLR start "rule__EnumRule__Group__4__Impl"
    // InternalXtext.g:8470:1: rule__EnumRule__Group__4__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8474:1: ( ( ':' ) )
            // InternalXtext.g:8475:1: ( ':' )
            {
            // InternalXtext.g:8475:1: ( ':' )
            // InternalXtext.g:8476:2: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_4()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__4__Impl"


    // $ANTLR start "rule__EnumRule__Group__5"
    // InternalXtext.g:8485:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl rule__EnumRule__Group__6 ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8489:1: ( rule__EnumRule__Group__5__Impl rule__EnumRule__Group__6 )
            // InternalXtext.g:8490:2: rule__EnumRule__Group__5__Impl rule__EnumRule__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__EnumRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__5"


    // $ANTLR start "rule__EnumRule__Group__5__Impl"
    // InternalXtext.g:8497:1: rule__EnumRule__Group__5__Impl : ( ( rule__EnumRule__AlternativesAssignment_5 ) ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8501:1: ( ( ( rule__EnumRule__AlternativesAssignment_5 ) ) )
            // InternalXtext.g:8502:1: ( ( rule__EnumRule__AlternativesAssignment_5 ) )
            {
            // InternalXtext.g:8502:1: ( ( rule__EnumRule__AlternativesAssignment_5 ) )
            // InternalXtext.g:8503:2: ( rule__EnumRule__AlternativesAssignment_5 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5()); 
            // InternalXtext.g:8504:2: ( rule__EnumRule__AlternativesAssignment_5 )
            // InternalXtext.g:8504:3: rule__EnumRule__AlternativesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__AlternativesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__5__Impl"


    // $ANTLR start "rule__EnumRule__Group__6"
    // InternalXtext.g:8512:1: rule__EnumRule__Group__6 : rule__EnumRule__Group__6__Impl ;
    public final void rule__EnumRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8516:1: ( rule__EnumRule__Group__6__Impl )
            // InternalXtext.g:8517:2: rule__EnumRule__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__6"


    // $ANTLR start "rule__EnumRule__Group__6__Impl"
    // InternalXtext.g:8523:1: rule__EnumRule__Group__6__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8527:1: ( ( ';' ) )
            // InternalXtext.g:8528:1: ( ';' )
            {
            // InternalXtext.g:8528:1: ( ';' )
            // InternalXtext.g:8529:2: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__6__Impl"


    // $ANTLR start "rule__EnumRule__Group_3__0"
    // InternalXtext.g:8539:1: rule__EnumRule__Group_3__0 : rule__EnumRule__Group_3__0__Impl rule__EnumRule__Group_3__1 ;
    public final void rule__EnumRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8543:1: ( rule__EnumRule__Group_3__0__Impl rule__EnumRule__Group_3__1 )
            // InternalXtext.g:8544:2: rule__EnumRule__Group_3__0__Impl rule__EnumRule__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__EnumRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__0"


    // $ANTLR start "rule__EnumRule__Group_3__0__Impl"
    // InternalXtext.g:8551:1: rule__EnumRule__Group_3__0__Impl : ( 'returns' ) ;
    public final void rule__EnumRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8555:1: ( ( 'returns' ) )
            // InternalXtext.g:8556:1: ( 'returns' )
            {
            // InternalXtext.g:8556:1: ( 'returns' )
            // InternalXtext.g:8557:2: 'returns'
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__0__Impl"


    // $ANTLR start "rule__EnumRule__Group_3__1"
    // InternalXtext.g:8566:1: rule__EnumRule__Group_3__1 : rule__EnumRule__Group_3__1__Impl ;
    public final void rule__EnumRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8570:1: ( rule__EnumRule__Group_3__1__Impl )
            // InternalXtext.g:8571:2: rule__EnumRule__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__1"


    // $ANTLR start "rule__EnumRule__Group_3__1__Impl"
    // InternalXtext.g:8577:1: rule__EnumRule__Group_3__1__Impl : ( ( rule__EnumRule__TypeAssignment_3_1 ) ) ;
    public final void rule__EnumRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8581:1: ( ( ( rule__EnumRule__TypeAssignment_3_1 ) ) )
            // InternalXtext.g:8582:1: ( ( rule__EnumRule__TypeAssignment_3_1 ) )
            {
            // InternalXtext.g:8582:1: ( ( rule__EnumRule__TypeAssignment_3_1 ) )
            // InternalXtext.g:8583:2: ( rule__EnumRule__TypeAssignment_3_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1()); 
            // InternalXtext.g:8584:2: ( rule__EnumRule__TypeAssignment_3_1 )
            // InternalXtext.g:8584:3: rule__EnumRule__TypeAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__TypeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group_3__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__0"
    // InternalXtext.g:8593:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8597:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // InternalXtext.g:8598:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__EnumLiterals__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__0"


    // $ANTLR start "rule__EnumLiterals__Group__0__Impl"
    // InternalXtext.g:8605:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8609:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtext.g:8610:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtext.g:8610:1: ( ruleEnumLiteralDeclaration )
            // InternalXtext.g:8611:2: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__1"
    // InternalXtext.g:8620:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8624:1: ( rule__EnumLiterals__Group__1__Impl )
            // InternalXtext.g:8625:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__1"


    // $ANTLR start "rule__EnumLiterals__Group__1__Impl"
    // InternalXtext.g:8631:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8635:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // InternalXtext.g:8636:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // InternalXtext.g:8636:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // InternalXtext.g:8637:2: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // InternalXtext.g:8638:2: ( rule__EnumLiterals__Group_1__0 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==38) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalXtext.g:8638:3: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EnumLiterals__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__0"
    // InternalXtext.g:8647:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8651:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // InternalXtext.g:8652:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__EnumLiterals__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__0"


    // $ANTLR start "rule__EnumLiterals__Group_1__0__Impl"
    // InternalXtext.g:8659:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8663:1: ( ( () ) )
            // InternalXtext.g:8664:1: ( () )
            {
            // InternalXtext.g:8664:1: ( () )
            // InternalXtext.g:8665:2: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtext.g:8666:2: ()
            // InternalXtext.g:8666:3: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__1"
    // InternalXtext.g:8674:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8678:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // InternalXtext.g:8679:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__1"


    // $ANTLR start "rule__EnumLiterals__Group_1__1__Impl"
    // InternalXtext.g:8685:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8689:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // InternalXtext.g:8690:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // InternalXtext.g:8690:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // InternalXtext.g:8691:2: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // InternalXtext.g:8691:2: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // InternalXtext.g:8692:3: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtext.g:8693:3: ( rule__EnumLiterals__Group_1_1__0 )
            // InternalXtext.g:8693:4: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // InternalXtext.g:8696:2: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // InternalXtext.g:8697:3: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtext.g:8698:3: ( rule__EnumLiterals__Group_1_1__0 )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==38) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalXtext.g:8698:4: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__EnumLiterals__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0"
    // InternalXtext.g:8708:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8712:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // InternalXtext.g:8713:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__EnumLiterals__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__0"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0__Impl"
    // InternalXtext.g:8720:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8724:1: ( ( '|' ) )
            // InternalXtext.g:8725:1: ( '|' )
            {
            // InternalXtext.g:8725:1: ( '|' )
            // InternalXtext.g:8726:2: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__1"
    // InternalXtext.g:8735:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8739:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // InternalXtext.g:8740:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__1__Impl"
    // InternalXtext.g:8746:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8750:1: ( ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) )
            // InternalXtext.g:8751:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtext.g:8751:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            // InternalXtext.g:8752:2: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 
            // InternalXtext.g:8753:2: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            // InternalXtext.g:8753:3: rule__EnumLiterals__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0"
    // InternalXtext.g:8762:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8766:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // InternalXtext.g:8767:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__EnumLiteralDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__0"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0__Impl"
    // InternalXtext.g:8774:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8778:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // InternalXtext.g:8779:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // InternalXtext.g:8779:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // InternalXtext.g:8780:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // InternalXtext.g:8781:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // InternalXtext.g:8781:3: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__0__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__1"
    // InternalXtext.g:8789:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8793:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // InternalXtext.g:8794:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__1"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__1__Impl"
    // InternalXtext.g:8800:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8804:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // InternalXtext.g:8805:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // InternalXtext.g:8805:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // InternalXtext.g:8806:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // InternalXtext.g:8807:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==15) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalXtext.g:8807:3: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EnumLiteralDeclaration__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__0"
    // InternalXtext.g:8816:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8820:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // InternalXtext.g:8821:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__0"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__0__Impl"
    // InternalXtext.g:8828:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8832:1: ( ( '=' ) )
            // InternalXtext.g:8833:1: ( '=' )
            {
            // InternalXtext.g:8833:1: ( '=' )
            // InternalXtext.g:8834:2: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__1"
    // InternalXtext.g:8843:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8847:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // InternalXtext.g:8848:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__1"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__1__Impl"
    // InternalXtext.g:8854:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8858:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // InternalXtext.g:8859:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // InternalXtext.g:8859:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // InternalXtext.g:8860:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // InternalXtext.g:8861:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // InternalXtext.g:8861:3: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__LiteralAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__1__Impl"


    // $ANTLR start "rule__Grammar__UnorderedGroup_5"
    // InternalXtext.g:8870:1: rule__Grammar__UnorderedGroup_5 : ( rule__Grammar__UnorderedGroup_5__0 )? ;
    public final void rule__Grammar__UnorderedGroup_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
        	
        try {
            // InternalXtext.g:8875:1: ( ( rule__Grammar__UnorderedGroup_5__0 )? )
            // InternalXtext.g:8876:2: ( rule__Grammar__UnorderedGroup_5__0 )?
            {
            // InternalXtext.g:8876:2: ( rule__Grammar__UnorderedGroup_5__0 )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( LA81_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
                alt81=1;
            }
            else if ( LA81_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
                alt81=1;
            }
            else if ( LA81_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalXtext.g:8876:2: rule__Grammar__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__UnorderedGroup_5__0();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UnorderedGroup_5"


    // $ANTLR start "rule__Grammar__UnorderedGroup_5__Impl"
    // InternalXtext.g:8884:1: rule__Grammar__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) ) ) ) ;
    public final void rule__Grammar__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalXtext.g:8889:1: ( ( ({...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) ) ) ) )
            // InternalXtext.g:8890:3: ( ({...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) ) ) )
            {
            // InternalXtext.g:8890:3: ( ({...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) ) ) | ({...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) ) ) )
            int alt82=3;
            int LA82_0 = input.LA(1);

            if ( LA82_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
                alt82=1;
            }
            else if ( LA82_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
                alt82=2;
            }
            else if ( LA82_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
                alt82=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalXtext.g:8891:3: ({...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) ) )
                    {
                    // InternalXtext.g:8891:3: ({...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) ) )
                    // InternalXtext.g:8892:4: {...}? => ( ( ( rule__Grammar__Group_5_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Grammar__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0)");
                    }
                    // InternalXtext.g:8892:103: ( ( ( rule__Grammar__Group_5_0__0 ) ) )
                    // InternalXtext.g:8893:5: ( ( rule__Grammar__Group_5_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0);
                    				

                    					selected = true;
                    				
                    // InternalXtext.g:8899:5: ( ( rule__Grammar__Group_5_0__0 ) )
                    // InternalXtext.g:8900:6: ( rule__Grammar__Group_5_0__0 )
                    {
                     before(grammarAccess.getGrammarAccess().getGroup_5_0()); 
                    // InternalXtext.g:8901:6: ( rule__Grammar__Group_5_0__0 )
                    // InternalXtext.g:8901:7: rule__Grammar__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGrammarAccess().getGroup_5_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:8906:3: ({...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) ) )
                    {
                    // InternalXtext.g:8906:3: ({...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) ) )
                    // InternalXtext.g:8907:4: {...}? => ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Grammar__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1)");
                    }
                    // InternalXtext.g:8907:103: ( ( ( rule__Grammar__DebugAssignment_5_1 ) ) )
                    // InternalXtext.g:8908:5: ( ( rule__Grammar__DebugAssignment_5_1 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1);
                    				

                    					selected = true;
                    				
                    // InternalXtext.g:8914:5: ( ( rule__Grammar__DebugAssignment_5_1 ) )
                    // InternalXtext.g:8915:6: ( rule__Grammar__DebugAssignment_5_1 )
                    {
                     before(grammarAccess.getGrammarAccess().getDebugAssignment_5_1()); 
                    // InternalXtext.g:8916:6: ( rule__Grammar__DebugAssignment_5_1 )
                    // InternalXtext.g:8916:7: rule__Grammar__DebugAssignment_5_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__DebugAssignment_5_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getGrammarAccess().getDebugAssignment_5_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalXtext.g:8921:3: ({...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) ) )
                    {
                    // InternalXtext.g:8921:3: ({...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) ) )
                    // InternalXtext.g:8922:4: {...}? => ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Grammar__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2)");
                    }
                    // InternalXtext.g:8922:103: ( ( ( rule__Grammar__InitBlockAssignment_5_2 ) ) )
                    // InternalXtext.g:8923:5: ( ( rule__Grammar__InitBlockAssignment_5_2 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2);
                    				

                    					selected = true;
                    				
                    // InternalXtext.g:8929:5: ( ( rule__Grammar__InitBlockAssignment_5_2 ) )
                    // InternalXtext.g:8930:6: ( rule__Grammar__InitBlockAssignment_5_2 )
                    {
                     before(grammarAccess.getGrammarAccess().getInitBlockAssignment_5_2()); 
                    // InternalXtext.g:8931:6: ( rule__Grammar__InitBlockAssignment_5_2 )
                    // InternalXtext.g:8931:7: rule__Grammar__InitBlockAssignment_5_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__InitBlockAssignment_5_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getGrammarAccess().getInitBlockAssignment_5_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UnorderedGroup_5__Impl"


    // $ANTLR start "rule__Grammar__UnorderedGroup_5__0"
    // InternalXtext.g:8944:1: rule__Grammar__UnorderedGroup_5__0 : rule__Grammar__UnorderedGroup_5__Impl ( rule__Grammar__UnorderedGroup_5__1 )? ;
    public final void rule__Grammar__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8948:1: ( rule__Grammar__UnorderedGroup_5__Impl ( rule__Grammar__UnorderedGroup_5__1 )? )
            // InternalXtext.g:8949:2: rule__Grammar__UnorderedGroup_5__Impl ( rule__Grammar__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_60);
            rule__Grammar__UnorderedGroup_5__Impl();

            state._fsp--;

            // InternalXtext.g:8950:2: ( rule__Grammar__UnorderedGroup_5__1 )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( LA83_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
                alt83=1;
            }
            else if ( LA83_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
                alt83=1;
            }
            else if ( LA83_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalXtext.g:8950:2: rule__Grammar__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__UnorderedGroup_5__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UnorderedGroup_5__0"


    // $ANTLR start "rule__Grammar__UnorderedGroup_5__1"
    // InternalXtext.g:8956:1: rule__Grammar__UnorderedGroup_5__1 : rule__Grammar__UnorderedGroup_5__Impl ( rule__Grammar__UnorderedGroup_5__2 )? ;
    public final void rule__Grammar__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8960:1: ( rule__Grammar__UnorderedGroup_5__Impl ( rule__Grammar__UnorderedGroup_5__2 )? )
            // InternalXtext.g:8961:2: rule__Grammar__UnorderedGroup_5__Impl ( rule__Grammar__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_60);
            rule__Grammar__UnorderedGroup_5__Impl();

            state._fsp--;

            // InternalXtext.g:8962:2: ( rule__Grammar__UnorderedGroup_5__2 )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( LA84_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
                alt84=1;
            }
            else if ( LA84_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
                alt84=1;
            }
            else if ( LA84_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalXtext.g:8962:2: rule__Grammar__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__UnorderedGroup_5__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UnorderedGroup_5__1"


    // $ANTLR start "rule__Grammar__UnorderedGroup_5__2"
    // InternalXtext.g:8968:1: rule__Grammar__UnorderedGroup_5__2 : rule__Grammar__UnorderedGroup_5__Impl ;
    public final void rule__Grammar__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8972:1: ( rule__Grammar__UnorderedGroup_5__Impl )
            // InternalXtext.g:8973:2: rule__Grammar__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__UnorderedGroup_5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UnorderedGroup_5__2"


    // $ANTLR start "rule__Grammar__NameAssignment_1"
    // InternalXtext.g:8980:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8984:1: ( ( ruleGrammarID ) )
            // InternalXtext.g:8985:2: ( ruleGrammarID )
            {
            // InternalXtext.g:8985:2: ( ruleGrammarID )
            // InternalXtext.g:8986:3: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__NameAssignment_1"


    // $ANTLR start "rule__Grammar__UsedGrammarsAssignment_2_1"
    // InternalXtext.g:8995:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:8999:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtext.g:9000:2: ( ( ruleGrammarID ) )
            {
            // InternalXtext.g:9000:2: ( ( ruleGrammarID ) )
            // InternalXtext.g:9001:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // InternalXtext.g:9002:3: ( ruleGrammarID )
            // InternalXtext.g:9003:4: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UsedGrammarsAssignment_2_1"


    // $ANTLR start "rule__Grammar__UsedGrammarsAssignment_2_2_1"
    // InternalXtext.g:9014:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9018:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtext.g:9019:2: ( ( ruleGrammarID ) )
            {
            // InternalXtext.g:9019:2: ( ( ruleGrammarID ) )
            // InternalXtext.g:9020:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // InternalXtext.g:9021:3: ( ruleGrammarID )
            // InternalXtext.g:9022:4: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UsedGrammarsAssignment_2_2_1"


    // $ANTLR start "rule__Grammar__DefinesHiddenTokensAssignment_3_0"
    // InternalXtext.g:9033:1: rule__Grammar__DefinesHiddenTokensAssignment_3_0 : ( ( 'hidden' ) ) ;
    public final void rule__Grammar__DefinesHiddenTokensAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9037:1: ( ( ( 'hidden' ) ) )
            // InternalXtext.g:9038:2: ( ( 'hidden' ) )
            {
            // InternalXtext.g:9038:2: ( ( 'hidden' ) )
            // InternalXtext.g:9039:3: ( 'hidden' )
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            // InternalXtext.g:9040:3: ( 'hidden' )
            // InternalXtext.g:9041:4: 'hidden'
            {
             before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 
            match(input,52,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 

            }

             after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__DefinesHiddenTokensAssignment_3_0"


    // $ANTLR start "rule__Grammar__HiddenTokensAssignment_3_2_0"
    // InternalXtext.g:9052:1: rule__Grammar__HiddenTokensAssignment_3_2_0 : ( ( ruleRuleID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9056:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9057:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9057:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9058:3: ( ruleRuleID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 
            // InternalXtext.g:9059:3: ( ruleRuleID )
            // InternalXtext.g:9060:4: ruleRuleID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__HiddenTokensAssignment_3_2_0"


    // $ANTLR start "rule__Grammar__HiddenTokensAssignment_3_2_1_1"
    // InternalXtext.g:9071:1: rule__Grammar__HiddenTokensAssignment_3_2_1_1 : ( ( ruleRuleID ) ) ;
    public final void rule__Grammar__HiddenTokensAssignment_3_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9075:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9076:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9076:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9077:3: ( ruleRuleID )
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 
            // InternalXtext.g:9078:3: ( ruleRuleID )
            // InternalXtext.g:9079:4: ruleRuleID
            {
             before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__HiddenTokensAssignment_3_2_1_1"


    // $ANTLR start "rule__Grammar__MetamodelDeclarationsAssignment_4"
    // InternalXtext.g:9090:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9094:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // InternalXtext.g:9095:2: ( ruleAbstractMetamodelDeclaration )
            {
            // InternalXtext.g:9095:2: ( ruleAbstractMetamodelDeclaration )
            // InternalXtext.g:9096:3: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__MetamodelDeclarationsAssignment_4"


    // $ANTLR start "rule__Grammar__TokenLimitAssignment_5_0_1"
    // InternalXtext.g:9105:1: rule__Grammar__TokenLimitAssignment_5_0_1 : ( RULE_INT ) ;
    public final void rule__Grammar__TokenLimitAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9109:1: ( ( RULE_INT ) )
            // InternalXtext.g:9110:2: ( RULE_INT )
            {
            // InternalXtext.g:9110:2: ( RULE_INT )
            // InternalXtext.g:9111:3: RULE_INT
            {
             before(grammarAccess.getGrammarAccess().getTokenLimitINTTerminalRuleCall_5_0_1_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getTokenLimitINTTerminalRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__TokenLimitAssignment_5_0_1"


    // $ANTLR start "rule__Grammar__DebugAssignment_5_1"
    // InternalXtext.g:9120:1: rule__Grammar__DebugAssignment_5_1 : ( ( 'hoistingDebug' ) ) ;
    public final void rule__Grammar__DebugAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9124:1: ( ( ( 'hoistingDebug' ) ) )
            // InternalXtext.g:9125:2: ( ( 'hoistingDebug' ) )
            {
            // InternalXtext.g:9125:2: ( ( 'hoistingDebug' ) )
            // InternalXtext.g:9126:3: ( 'hoistingDebug' )
            {
             before(grammarAccess.getGrammarAccess().getDebugHoistingDebugKeyword_5_1_0()); 
            // InternalXtext.g:9127:3: ( 'hoistingDebug' )
            // InternalXtext.g:9128:4: 'hoistingDebug'
            {
             before(grammarAccess.getGrammarAccess().getDebugHoistingDebugKeyword_5_1_0()); 
            match(input,53,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getDebugHoistingDebugKeyword_5_1_0()); 

            }

             after(grammarAccess.getGrammarAccess().getDebugHoistingDebugKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__DebugAssignment_5_1"


    // $ANTLR start "rule__Grammar__InitBlockAssignment_5_2"
    // InternalXtext.g:9139:1: rule__Grammar__InitBlockAssignment_5_2 : ( ruleInitBlock ) ;
    public final void rule__Grammar__InitBlockAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9143:1: ( ( ruleInitBlock ) )
            // InternalXtext.g:9144:2: ( ruleInitBlock )
            {
            // InternalXtext.g:9144:2: ( ruleInitBlock )
            // InternalXtext.g:9145:3: ruleInitBlock
            {
             before(grammarAccess.getGrammarAccess().getInitBlockInitBlockParserRuleCall_5_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleInitBlock();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getInitBlockInitBlockParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__InitBlockAssignment_5_2"


    // $ANTLR start "rule__Grammar__RulesAssignment_6"
    // InternalXtext.g:9154:1: rule__Grammar__RulesAssignment_6 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9158:1: ( ( ruleAbstractRule ) )
            // InternalXtext.g:9159:2: ( ruleAbstractRule )
            {
            // InternalXtext.g:9159:2: ( ruleAbstractRule )
            // InternalXtext.g:9160:3: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__RulesAssignment_6"


    // $ANTLR start "rule__InitBlock__CodeAssignment_1"
    // InternalXtext.g:9169:1: rule__InitBlock__CodeAssignment_1 : ( ruleJavaCode ) ;
    public final void rule__InitBlock__CodeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9173:1: ( ( ruleJavaCode ) )
            // InternalXtext.g:9174:2: ( ruleJavaCode )
            {
            // InternalXtext.g:9174:2: ( ruleJavaCode )
            // InternalXtext.g:9175:3: ruleJavaCode
            {
             before(grammarAccess.getInitBlockAccess().getCodeJavaCodeParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleJavaCode();

            state._fsp--;

             after(grammarAccess.getInitBlockAccess().getCodeJavaCodeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InitBlock__CodeAssignment_1"


    // $ANTLR start "rule__GeneratedMetamodel__NameAssignment_1"
    // InternalXtext.g:9184:1: rule__GeneratedMetamodel__NameAssignment_1 : ( ruleValidID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9188:1: ( ( ruleValidID ) )
            // InternalXtext.g:9189:2: ( ruleValidID )
            {
            // InternalXtext.g:9189:2: ( ruleValidID )
            // InternalXtext.g:9190:3: ruleValidID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__NameAssignment_1"


    // $ANTLR start "rule__GeneratedMetamodel__EPackageAssignment_2"
    // InternalXtext.g:9199:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9203:1: ( ( ( RULE_STRING ) ) )
            // InternalXtext.g:9204:2: ( ( RULE_STRING ) )
            {
            // InternalXtext.g:9204:2: ( ( RULE_STRING ) )
            // InternalXtext.g:9205:3: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // InternalXtext.g:9206:3: ( RULE_STRING )
            // InternalXtext.g:9207:4: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__EPackageAssignment_2"


    // $ANTLR start "rule__GeneratedMetamodel__AliasAssignment_3_1"
    // InternalXtext.g:9218:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( ruleValidID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9222:1: ( ( ruleValidID ) )
            // InternalXtext.g:9223:2: ( ruleValidID )
            {
            // InternalXtext.g:9223:2: ( ruleValidID )
            // InternalXtext.g:9224:3: ruleValidID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__AliasAssignment_3_1"


    // $ANTLR start "rule__ReferencedMetamodel__EPackageAssignment_1"
    // InternalXtext.g:9233:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9237:1: ( ( ( RULE_STRING ) ) )
            // InternalXtext.g:9238:2: ( ( RULE_STRING ) )
            {
            // InternalXtext.g:9238:2: ( ( RULE_STRING ) )
            // InternalXtext.g:9239:3: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // InternalXtext.g:9240:3: ( RULE_STRING )
            // InternalXtext.g:9241:4: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__EPackageAssignment_1"


    // $ANTLR start "rule__ReferencedMetamodel__AliasAssignment_2_1"
    // InternalXtext.g:9252:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( ruleValidID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9256:1: ( ( ruleValidID ) )
            // InternalXtext.g:9257:2: ( ruleValidID )
            {
            // InternalXtext.g:9257:2: ( ruleValidID )
            // InternalXtext.g:9258:3: ruleValidID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__AliasAssignment_2_1"


    // $ANTLR start "rule__Annotation__NameAssignment_1"
    // InternalXtext.g:9267:1: rule__Annotation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Annotation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9271:1: ( ( RULE_ID ) )
            // InternalXtext.g:9272:2: ( RULE_ID )
            {
            // InternalXtext.g:9272:2: ( RULE_ID )
            // InternalXtext.g:9273:3: RULE_ID
            {
             before(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotation__NameAssignment_1"


    // $ANTLR start "rule__ParserRule__AnnotationsAssignment_0"
    // InternalXtext.g:9282:1: rule__ParserRule__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__ParserRule__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9286:1: ( ( ruleAnnotation ) )
            // InternalXtext.g:9287:2: ( ruleAnnotation )
            {
            // InternalXtext.g:9287:2: ( ruleAnnotation )
            // InternalXtext.g:9288:3: ruleAnnotation
            {
             before(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__AnnotationsAssignment_0"


    // $ANTLR start "rule__ParserRule__FragmentAssignment_1_0_0"
    // InternalXtext.g:9297:1: rule__ParserRule__FragmentAssignment_1_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__ParserRule__FragmentAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9301:1: ( ( ( 'fragment' ) ) )
            // InternalXtext.g:9302:2: ( ( 'fragment' ) )
            {
            // InternalXtext.g:9302:2: ( ( 'fragment' ) )
            // InternalXtext.g:9303:3: ( 'fragment' )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            // InternalXtext.g:9304:3: ( 'fragment' )
            // InternalXtext.g:9305:4: 'fragment'
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            match(input,54,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__FragmentAssignment_1_0_0"


    // $ANTLR start "rule__ParserRule__WildcardAssignment_1_0_2_0"
    // InternalXtext.g:9316:1: rule__ParserRule__WildcardAssignment_1_0_2_0 : ( ( '*' ) ) ;
    public final void rule__ParserRule__WildcardAssignment_1_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9320:1: ( ( ( '*' ) ) )
            // InternalXtext.g:9321:2: ( ( '*' ) )
            {
            // InternalXtext.g:9321:2: ( ( '*' ) )
            // InternalXtext.g:9322:3: ( '*' )
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 
            // InternalXtext.g:9323:3: ( '*' )
            // InternalXtext.g:9324:4: '*'
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__WildcardAssignment_1_0_2_0"


    // $ANTLR start "rule__ParserRule__TypeAssignment_1_0_2_1_1"
    // InternalXtext.g:9335:1: rule__ParserRule__TypeAssignment_1_0_2_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_0_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9339:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9340:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9340:2: ( ruleTypeRef )
            // InternalXtext.g:9341:3: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__TypeAssignment_1_0_2_1_1"


    // $ANTLR start "rule__ParserRule__TypeAssignment_1_1_1_1"
    // InternalXtext.g:9350:1: rule__ParserRule__TypeAssignment_1_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__ParserRule__TypeAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9354:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9355:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9355:2: ( ruleTypeRef )
            // InternalXtext.g:9356:3: ruleTypeRef
            {
             before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__TypeAssignment_1_1_1_1"


    // $ANTLR start "rule__ParserRule__DefinesHiddenTokensAssignment_2_0"
    // InternalXtext.g:9365:1: rule__ParserRule__DefinesHiddenTokensAssignment_2_0 : ( ( 'hidden' ) ) ;
    public final void rule__ParserRule__DefinesHiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9369:1: ( ( ( 'hidden' ) ) )
            // InternalXtext.g:9370:2: ( ( 'hidden' ) )
            {
            // InternalXtext.g:9370:2: ( ( 'hidden' ) )
            // InternalXtext.g:9371:3: ( 'hidden' )
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            // InternalXtext.g:9372:3: ( 'hidden' )
            // InternalXtext.g:9373:4: 'hidden'
            {
             before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 
            match(input,52,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__DefinesHiddenTokensAssignment_2_0"


    // $ANTLR start "rule__ParserRule__HiddenTokensAssignment_2_2_0"
    // InternalXtext.g:9384:1: rule__ParserRule__HiddenTokensAssignment_2_2_0 : ( ( ruleRuleID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9388:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9389:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9389:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9390:3: ( ruleRuleID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 
            // InternalXtext.g:9391:3: ( ruleRuleID )
            // InternalXtext.g:9392:4: ruleRuleID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__HiddenTokensAssignment_2_2_0"


    // $ANTLR start "rule__ParserRule__HiddenTokensAssignment_2_2_1_1"
    // InternalXtext.g:9403:1: rule__ParserRule__HiddenTokensAssignment_2_2_1_1 : ( ( ruleRuleID ) ) ;
    public final void rule__ParserRule__HiddenTokensAssignment_2_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9407:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9408:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9408:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9409:3: ( ruleRuleID )
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 
            // InternalXtext.g:9410:3: ( ruleRuleID )
            // InternalXtext.g:9411:4: ruleRuleID
            {
             before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1()); 

            }

             after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__HiddenTokensAssignment_2_2_1_1"


    // $ANTLR start "rule__ParserRule__AlternativesAssignment_4"
    // InternalXtext.g:9422:1: rule__ParserRule__AlternativesAssignment_4 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9426:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:9427:2: ( ruleAlternatives )
            {
            // InternalXtext.g:9427:2: ( ruleAlternatives )
            // InternalXtext.g:9428:3: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__AlternativesAssignment_4"


    // $ANTLR start "rule__RuleNameAndParams__NameAssignment_0"
    // InternalXtext.g:9437:1: rule__RuleNameAndParams__NameAssignment_0 : ( ruleValidID ) ;
    public final void rule__RuleNameAndParams__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9441:1: ( ( ruleValidID ) )
            // InternalXtext.g:9442:2: ( ruleValidID )
            {
            // InternalXtext.g:9442:2: ( ruleValidID )
            // InternalXtext.g:9443:3: ruleValidID
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__NameAssignment_0"


    // $ANTLR start "rule__RuleNameAndParams__ParametersAssignment_1_1_0"
    // InternalXtext.g:9452:1: rule__RuleNameAndParams__ParametersAssignment_1_1_0 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9456:1: ( ( ruleParameter ) )
            // InternalXtext.g:9457:2: ( ruleParameter )
            {
            // InternalXtext.g:9457:2: ( ruleParameter )
            // InternalXtext.g:9458:3: ruleParameter
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__ParametersAssignment_1_1_0"


    // $ANTLR start "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1"
    // InternalXtext.g:9467:1: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9471:1: ( ( ruleParameter ) )
            // InternalXtext.g:9472:2: ( ruleParameter )
            {
            // InternalXtext.g:9472:2: ( ruleParameter )
            // InternalXtext.g:9473:3: ruleParameter
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1"


    // $ANTLR start "rule__Parameter__NameAssignment"
    // InternalXtext.g:9482:1: rule__Parameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9486:1: ( ( RULE_ID ) )
            // InternalXtext.g:9487:2: ( RULE_ID )
            {
            // InternalXtext.g:9487:2: ( RULE_ID )
            // InternalXtext.g:9488:3: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment"


    // $ANTLR start "rule__TypeRef__MetamodelAssignment_0_0"
    // InternalXtext.g:9497:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9501:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9502:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9502:2: ( ( RULE_ID ) )
            // InternalXtext.g:9503:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // InternalXtext.g:9504:3: ( RULE_ID )
            // InternalXtext.g:9505:4: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__MetamodelAssignment_0_0"


    // $ANTLR start "rule__TypeRef__ClassifierAssignment_1"
    // InternalXtext.g:9516:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9520:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9521:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9521:2: ( ( RULE_ID ) )
            // InternalXtext.g:9522:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalXtext.g:9523:3: ( RULE_ID )
            // InternalXtext.g:9524:4: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__ClassifierAssignment_1"


    // $ANTLR start "rule__Alternatives__ElementsAssignment_1_1_1"
    // InternalXtext.g:9535:1: rule__Alternatives__ElementsAssignment_1_1_1 : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9539:1: ( ( ruleConditionalBranch ) )
            // InternalXtext.g:9540:2: ( ruleConditionalBranch )
            {
            // InternalXtext.g:9540:2: ( ruleConditionalBranch )
            // InternalXtext.g:9541:3: ruleConditionalBranch
            {
             before(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__ConditionalBranch__GuardConditionAssignment_1_2"
    // InternalXtext.g:9550:1: rule__ConditionalBranch__GuardConditionAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__ConditionalBranch__GuardConditionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9554:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:9555:2: ( ruleDisjunction )
            {
            // InternalXtext.g:9555:2: ( ruleDisjunction )
            // InternalXtext.g:9556:3: ruleDisjunction
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__GuardConditionAssignment_1_2"


    // $ANTLR start "rule__ConditionalBranch__ElementsAssignment_1_4"
    // InternalXtext.g:9565:1: rule__ConditionalBranch__ElementsAssignment_1_4 : ( ruleAbstractToken ) ;
    public final void rule__ConditionalBranch__ElementsAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9569:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:9570:2: ( ruleAbstractToken )
            {
            // InternalXtext.g:9570:2: ( ruleAbstractToken )
            // InternalXtext.g:9571:3: ruleAbstractToken
            {
             before(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__ElementsAssignment_1_4"


    // $ANTLR start "rule__UnorderedGroup__ElementsAssignment_1_1_1"
    // InternalXtext.g:9580:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9584:1: ( ( ruleGroup ) )
            // InternalXtext.g:9585:2: ( ruleGroup )
            {
            // InternalXtext.g:9585:2: ( ruleGroup )
            // InternalXtext.g:9586:3: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__Group__ElementsAssignment_1_1"
    // InternalXtext.g:9595:1: rule__Group__ElementsAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9599:1: ( ( ruleAbstractToken ) )
            // InternalXtext.g:9600:2: ( ruleAbstractToken )
            {
            // InternalXtext.g:9600:2: ( ruleAbstractToken )
            // InternalXtext.g:9601:3: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__ElementsAssignment_1_1"


    // $ANTLR start "rule__GatedSemanticPredicate__CodeAssignment_0"
    // InternalXtext.g:9610:1: rule__GatedSemanticPredicate__CodeAssignment_0 : ( ruleJavaCode ) ;
    public final void rule__GatedSemanticPredicate__CodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9614:1: ( ( ruleJavaCode ) )
            // InternalXtext.g:9615:2: ( ruleJavaCode )
            {
            // InternalXtext.g:9615:2: ( ruleJavaCode )
            // InternalXtext.g:9616:3: ruleJavaCode
            {
             before(grammarAccess.getGatedSemanticPredicateAccess().getCodeJavaCodeParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleJavaCode();

            state._fsp--;

             after(grammarAccess.getGatedSemanticPredicateAccess().getCodeJavaCodeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GatedSemanticPredicate__CodeAssignment_0"


    // $ANTLR start "rule__DisambiguatingSemanticPredicate__CodeAssignment_0"
    // InternalXtext.g:9625:1: rule__DisambiguatingSemanticPredicate__CodeAssignment_0 : ( ruleJavaCode ) ;
    public final void rule__DisambiguatingSemanticPredicate__CodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9629:1: ( ( ruleJavaCode ) )
            // InternalXtext.g:9630:2: ( ruleJavaCode )
            {
            // InternalXtext.g:9630:2: ( ruleJavaCode )
            // InternalXtext.g:9631:3: ruleJavaCode
            {
             before(grammarAccess.getDisambiguatingSemanticPredicateAccess().getCodeJavaCodeParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleJavaCode();

            state._fsp--;

             after(grammarAccess.getDisambiguatingSemanticPredicateAccess().getCodeJavaCodeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DisambiguatingSemanticPredicate__CodeAssignment_0"


    // $ANTLR start "rule__JavaAction__CodeAssignment"
    // InternalXtext.g:9640:1: rule__JavaAction__CodeAssignment : ( ruleJavaCode ) ;
    public final void rule__JavaAction__CodeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9644:1: ( ( ruleJavaCode ) )
            // InternalXtext.g:9645:2: ( ruleJavaCode )
            {
            // InternalXtext.g:9645:2: ( ruleJavaCode )
            // InternalXtext.g:9646:3: ruleJavaCode
            {
             before(grammarAccess.getJavaActionAccess().getCodeJavaCodeParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleJavaCode();

            state._fsp--;

             after(grammarAccess.getJavaActionAccess().getCodeJavaCodeParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaAction__CodeAssignment"


    // $ANTLR start "rule__JavaCode__SourceAssignment"
    // InternalXtext.g:9655:1: rule__JavaCode__SourceAssignment : ( RULE_JAVACODESTRING ) ;
    public final void rule__JavaCode__SourceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9659:1: ( ( RULE_JAVACODESTRING ) )
            // InternalXtext.g:9660:2: ( RULE_JAVACODESTRING )
            {
            // InternalXtext.g:9660:2: ( RULE_JAVACODESTRING )
            // InternalXtext.g:9661:3: RULE_JAVACODESTRING
            {
             before(grammarAccess.getJavaCodeAccess().getSourceJAVACODESTRINGTerminalRuleCall_0()); 
            match(input,RULE_JAVACODESTRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getJavaCodeAccess().getSourceJAVACODESTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JavaCode__SourceAssignment"


    // $ANTLR start "rule__AbstractTokenWithCardinality__CardinalityAssignment_1"
    // InternalXtext.g:9670:1: rule__AbstractTokenWithCardinality__CardinalityAssignment_1 : ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9674:1: ( ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) ) )
            // InternalXtext.g:9675:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtext.g:9675:2: ( ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 ) )
            // InternalXtext.g:9676:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtext.g:9677:3: ( rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0 )
            // InternalXtext.g:9677:4: rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__CardinalityAssignment_1"


    // $ANTLR start "rule__Action__TypeAssignment_1"
    // InternalXtext.g:9685:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9689:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:9690:2: ( ruleTypeRef )
            {
            // InternalXtext.g:9690:2: ( ruleTypeRef )
            // InternalXtext.g:9691:3: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__TypeAssignment_1"


    // $ANTLR start "rule__Action__FeatureAssignment_2_1"
    // InternalXtext.g:9700:1: rule__Action__FeatureAssignment_2_1 : ( ruleValidID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9704:1: ( ( ruleValidID ) )
            // InternalXtext.g:9705:2: ( ruleValidID )
            {
            // InternalXtext.g:9705:2: ( ruleValidID )
            // InternalXtext.g:9706:3: ruleValidID
            {
             before(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__FeatureAssignment_2_1"


    // $ANTLR start "rule__Action__OperatorAssignment_2_2"
    // InternalXtext.g:9715:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9719:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // InternalXtext.g:9720:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // InternalXtext.g:9720:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // InternalXtext.g:9721:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // InternalXtext.g:9722:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            // InternalXtext.g:9722:4: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__OperatorAlternatives_2_2_0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__OperatorAssignment_2_2"


    // $ANTLR start "rule__Keyword__ValueAssignment"
    // InternalXtext.g:9730:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9734:1: ( ( RULE_STRING ) )
            // InternalXtext.g:9735:2: ( RULE_STRING )
            {
            // InternalXtext.g:9735:2: ( RULE_STRING )
            // InternalXtext.g:9736:3: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__ValueAssignment"


    // $ANTLR start "rule__RuleCall__RuleAssignment_0"
    // InternalXtext.g:9745:1: rule__RuleCall__RuleAssignment_0 : ( ( ruleRuleID ) ) ;
    public final void rule__RuleCall__RuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9749:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9750:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9750:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9751:3: ( ruleRuleID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); 
            // InternalXtext.g:9752:3: ( ruleRuleID )
            // InternalXtext.g:9753:4: ruleRuleID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__RuleAssignment_0"


    // $ANTLR start "rule__RuleCall__ArgumentsAssignment_1_1"
    // InternalXtext.g:9764:1: rule__RuleCall__ArgumentsAssignment_1_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9768:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:9769:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:9769:2: ( ruleNamedArgument )
            // InternalXtext.g:9770:3: ruleNamedArgument
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__ArgumentsAssignment_1_1"


    // $ANTLR start "rule__RuleCall__ArgumentsAssignment_1_2_1"
    // InternalXtext.g:9779:1: rule__RuleCall__ArgumentsAssignment_1_2_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9783:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:9784:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:9784:2: ( ruleNamedArgument )
            // InternalXtext.g:9785:3: ruleNamedArgument
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__ArgumentsAssignment_1_2_1"


    // $ANTLR start "rule__NamedArgument__ParameterAssignment_0_0"
    // InternalXtext.g:9794:1: rule__NamedArgument__ParameterAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__NamedArgument__ParameterAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9798:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9799:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9799:2: ( ( RULE_ID ) )
            // InternalXtext.g:9800:3: ( RULE_ID )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); 
            // InternalXtext.g:9801:3: ( RULE_ID )
            // InternalXtext.g:9802:4: RULE_ID
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ParameterAssignment_0_0"


    // $ANTLR start "rule__NamedArgument__CalledByNameAssignment_0_1"
    // InternalXtext.g:9813:1: rule__NamedArgument__CalledByNameAssignment_0_1 : ( ( '=' ) ) ;
    public final void rule__NamedArgument__CalledByNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9817:1: ( ( ( '=' ) ) )
            // InternalXtext.g:9818:2: ( ( '=' ) )
            {
            // InternalXtext.g:9818:2: ( ( '=' ) )
            // InternalXtext.g:9819:3: ( '=' )
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 
            // InternalXtext.g:9820:3: ( '=' )
            // InternalXtext.g:9821:4: '='
            {
             before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__CalledByNameAssignment_0_1"


    // $ANTLR start "rule__NamedArgument__ValueAssignment_1"
    // InternalXtext.g:9832:1: rule__NamedArgument__ValueAssignment_1 : ( ruleDisjunction ) ;
    public final void rule__NamedArgument__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9836:1: ( ( ruleDisjunction ) )
            // InternalXtext.g:9837:2: ( ruleDisjunction )
            {
            // InternalXtext.g:9837:2: ( ruleDisjunction )
            // InternalXtext.g:9838:3: ruleDisjunction
            {
             before(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ValueAssignment_1"


    // $ANTLR start "rule__LiteralCondition__TrueAssignment_1_0"
    // InternalXtext.g:9847:1: rule__LiteralCondition__TrueAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__LiteralCondition__TrueAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9851:1: ( ( ( 'true' ) ) )
            // InternalXtext.g:9852:2: ( ( 'true' ) )
            {
            // InternalXtext.g:9852:2: ( ( 'true' ) )
            // InternalXtext.g:9853:3: ( 'true' )
            {
             before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 
            // InternalXtext.g:9854:3: ( 'true' )
            // InternalXtext.g:9855:4: 'true'
            {
             before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 

            }

             after(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralCondition__TrueAssignment_1_0"


    // $ANTLR start "rule__Disjunction__RightAssignment_1_2"
    // InternalXtext.g:9866:1: rule__Disjunction__RightAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__Disjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9870:1: ( ( ruleConjunction ) )
            // InternalXtext.g:9871:2: ( ruleConjunction )
            {
            // InternalXtext.g:9871:2: ( ruleConjunction )
            // InternalXtext.g:9872:3: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__RightAssignment_1_2"


    // $ANTLR start "rule__Conjunction__RightAssignment_1_2"
    // InternalXtext.g:9881:1: rule__Conjunction__RightAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9885:1: ( ( ruleNegation ) )
            // InternalXtext.g:9886:2: ( ruleNegation )
            {
            // InternalXtext.g:9886:2: ( ruleNegation )
            // InternalXtext.g:9887:3: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__RightAssignment_1_2"


    // $ANTLR start "rule__Negation__ValueAssignment_1_2"
    // InternalXtext.g:9896:1: rule__Negation__ValueAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Negation__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9900:1: ( ( ruleNegation ) )
            // InternalXtext.g:9901:2: ( ruleNegation )
            {
            // InternalXtext.g:9901:2: ( ruleNegation )
            // InternalXtext.g:9902:3: ruleNegation
            {
             before(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__ValueAssignment_1_2"


    // $ANTLR start "rule__ParameterReference__ParameterAssignment"
    // InternalXtext.g:9911:1: rule__ParameterReference__ParameterAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ParameterReference__ParameterAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9915:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:9916:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:9916:2: ( ( RULE_ID ) )
            // InternalXtext.g:9917:3: ( RULE_ID )
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); 
            // InternalXtext.g:9918:3: ( RULE_ID )
            // InternalXtext.g:9919:4: RULE_ID
            {
             before(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterReference__ParameterAssignment"


    // $ANTLR start "rule__TerminalRuleCall__RuleAssignment"
    // InternalXtext.g:9930:1: rule__TerminalRuleCall__RuleAssignment : ( ( ruleRuleID ) ) ;
    public final void rule__TerminalRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9934:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:9935:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:9935:2: ( ( ruleRuleID ) )
            // InternalXtext.g:9936:3: ( ruleRuleID )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalXtext.g:9937:3: ( ruleRuleID )
            // InternalXtext.g:9938:4: ruleRuleID
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRuleCall__RuleAssignment"


    // $ANTLR start "rule__PredicatedKeyword__PredicatedAssignment_0_0"
    // InternalXtext.g:9949:1: rule__PredicatedKeyword__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedKeyword__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9953:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:9954:2: ( ( '=>' ) )
            {
            // InternalXtext.g:9954:2: ( ( '=>' ) )
            // InternalXtext.g:9955:3: ( '=>' )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:9956:3: ( '=>' )
            // InternalXtext.g:9957:4: '=>'
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,55,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__PredicatedAssignment_0_0"


    // $ANTLR start "rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:9968:1: rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9972:1: ( ( ( '->' ) ) )
            // InternalXtext.g:9973:2: ( ( '->' ) )
            {
            // InternalXtext.g:9973:2: ( ( '->' ) )
            // InternalXtext.g:9974:3: ( '->' )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:9975:3: ( '->' )
            // InternalXtext.g:9976:4: '->'
            {
             before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__PredicatedKeyword__ValueAssignment_1"
    // InternalXtext.g:9987:1: rule__PredicatedKeyword__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PredicatedKeyword__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:9991:1: ( ( RULE_STRING ) )
            // InternalXtext.g:9992:2: ( RULE_STRING )
            {
            // InternalXtext.g:9992:2: ( RULE_STRING )
            // InternalXtext.g:9993:3: RULE_STRING
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__ValueAssignment_1"


    // $ANTLR start "rule__PredicatedRuleCall__PredicatedAssignment_0_0"
    // InternalXtext.g:10002:1: rule__PredicatedRuleCall__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedRuleCall__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10006:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10007:2: ( ( '=>' ) )
            {
            // InternalXtext.g:10007:2: ( ( '=>' ) )
            // InternalXtext.g:10008:3: ( '=>' )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10009:3: ( '=>' )
            // InternalXtext.g:10010:4: '=>'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,55,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__PredicatedAssignment_0_0"


    // $ANTLR start "rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10021:1: rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10025:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10026:2: ( ( '->' ) )
            {
            // InternalXtext.g:10026:2: ( ( '->' ) )
            // InternalXtext.g:10027:3: ( '->' )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10028:3: ( '->' )
            // InternalXtext.g:10029:4: '->'
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__PredicatedRuleCall__RuleAssignment_1"
    // InternalXtext.g:10040:1: rule__PredicatedRuleCall__RuleAssignment_1 : ( ( ruleRuleID ) ) ;
    public final void rule__PredicatedRuleCall__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10044:1: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:10045:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:10045:2: ( ( ruleRuleID ) )
            // InternalXtext.g:10046:3: ( ruleRuleID )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 
            // InternalXtext.g:10047:3: ( ruleRuleID )
            // InternalXtext.g:10048:4: ruleRuleID
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__RuleAssignment_1"


    // $ANTLR start "rule__PredicatedRuleCall__ArgumentsAssignment_2_1"
    // InternalXtext.g:10059:1: rule__PredicatedRuleCall__ArgumentsAssignment_2_1 : ( ruleNamedArgument ) ;
    public final void rule__PredicatedRuleCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10063:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:10064:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:10064:2: ( ruleNamedArgument )
            // InternalXtext.g:10065:3: ruleNamedArgument
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__ArgumentsAssignment_2_1"


    // $ANTLR start "rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1"
    // InternalXtext.g:10074:1: rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1 : ( ruleNamedArgument ) ;
    public final void rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10078:1: ( ( ruleNamedArgument ) )
            // InternalXtext.g:10079:2: ( ruleNamedArgument )
            {
            // InternalXtext.g:10079:2: ( ruleNamedArgument )
            // InternalXtext.g:10080:3: ruleNamedArgument
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1"


    // $ANTLR start "rule__Assignment__PredicatedAssignment_0_0"
    // InternalXtext.g:10089:1: rule__Assignment__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__Assignment__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10093:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10094:2: ( ( '=>' ) )
            {
            // InternalXtext.g:10094:2: ( ( '=>' ) )
            // InternalXtext.g:10095:3: ( '=>' )
            {
             before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10096:3: ( '=>' )
            // InternalXtext.g:10097:4: '=>'
            {
             before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,55,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__PredicatedAssignment_0_0"


    // $ANTLR start "rule__Assignment__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10108:1: rule__Assignment__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__Assignment__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10112:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10113:2: ( ( '->' ) )
            {
            // InternalXtext.g:10113:2: ( ( '->' ) )
            // InternalXtext.g:10114:3: ( '->' )
            {
             before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10115:3: ( '->' )
            // InternalXtext.g:10116:4: '->'
            {
             before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__Assignment__FeatureAssignment_1"
    // InternalXtext.g:10127:1: rule__Assignment__FeatureAssignment_1 : ( ruleValidID ) ;
    public final void rule__Assignment__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10131:1: ( ( ruleValidID ) )
            // InternalXtext.g:10132:2: ( ruleValidID )
            {
            // InternalXtext.g:10132:2: ( ruleValidID )
            // InternalXtext.g:10133:3: ruleValidID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__FeatureAssignment_1"


    // $ANTLR start "rule__Assignment__OperatorAssignment_2"
    // InternalXtext.g:10142:1: rule__Assignment__OperatorAssignment_2 : ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10146:1: ( ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) )
            // InternalXtext.g:10147:2: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            {
            // InternalXtext.g:10147:2: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            // InternalXtext.g:10148:3: ( rule__Assignment__OperatorAlternatives_2_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 
            // InternalXtext.g:10149:3: ( rule__Assignment__OperatorAlternatives_2_0 )
            // InternalXtext.g:10149:4: rule__Assignment__OperatorAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__OperatorAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__OperatorAssignment_2"


    // $ANTLR start "rule__Assignment__TerminalAssignment_3"
    // InternalXtext.g:10157:1: rule__Assignment__TerminalAssignment_3 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10161:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:10162:2: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:10162:2: ( ruleAssignableTerminal )
            // InternalXtext.g:10163:3: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__TerminalAssignment_3"


    // $ANTLR start "rule__AssignableAlternatives__ElementsAssignment_1_1_1"
    // InternalXtext.g:10172:1: rule__AssignableAlternatives__ElementsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10176:1: ( ( ruleAssignableTerminal ) )
            // InternalXtext.g:10177:2: ( ruleAssignableTerminal )
            {
            // InternalXtext.g:10177:2: ( ruleAssignableTerminal )
            // InternalXtext.g:10178:3: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__CrossReference__TypeAssignment_1"
    // InternalXtext.g:10187:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10191:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10192:2: ( ruleTypeRef )
            {
            // InternalXtext.g:10192:2: ( ruleTypeRef )
            // InternalXtext.g:10193:3: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__TypeAssignment_1"


    // $ANTLR start "rule__CrossReference__TerminalAssignment_2_1"
    // InternalXtext.g:10202:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10206:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtext.g:10207:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtext.g:10207:2: ( ruleCrossReferenceableTerminal )
            // InternalXtext.g:10208:3: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__TerminalAssignment_2_1"


    // $ANTLR start "rule__PredicatedGroup__PredicatedAssignment_0_0"
    // InternalXtext.g:10217:1: rule__PredicatedGroup__PredicatedAssignment_0_0 : ( ( '=>' ) ) ;
    public final void rule__PredicatedGroup__PredicatedAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10221:1: ( ( ( '=>' ) ) )
            // InternalXtext.g:10222:2: ( ( '=>' ) )
            {
            // InternalXtext.g:10222:2: ( ( '=>' ) )
            // InternalXtext.g:10223:3: ( '=>' )
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            // InternalXtext.g:10224:3: ( '=>' )
            // InternalXtext.g:10225:4: '=>'
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 
            match(input,55,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }

             after(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__PredicatedAssignment_0_0"


    // $ANTLR start "rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1"
    // InternalXtext.g:10236:1: rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1 : ( ( '->' ) ) ;
    public final void rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10240:1: ( ( ( '->' ) ) )
            // InternalXtext.g:10241:2: ( ( '->' ) )
            {
            // InternalXtext.g:10241:2: ( ( '->' ) )
            // InternalXtext.g:10242:3: ( '->' )
            {
             before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            // InternalXtext.g:10243:3: ( '->' )
            // InternalXtext.g:10244:4: '->'
            {
             before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 
            match(input,48,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }

             after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1"


    // $ANTLR start "rule__PredicatedGroup__ElementsAssignment_2"
    // InternalXtext.g:10255:1: rule__PredicatedGroup__ElementsAssignment_2 : ( ruleAlternatives ) ;
    public final void rule__PredicatedGroup__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10259:1: ( ( ruleAlternatives ) )
            // InternalXtext.g:10260:2: ( ruleAlternatives )
            {
            // InternalXtext.g:10260:2: ( ruleAlternatives )
            // InternalXtext.g:10261:3: ruleAlternatives
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__ElementsAssignment_2"


    // $ANTLR start "rule__TerminalRule__AnnotationsAssignment_0"
    // InternalXtext.g:10270:1: rule__TerminalRule__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__TerminalRule__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10274:1: ( ( ruleAnnotation ) )
            // InternalXtext.g:10275:2: ( ruleAnnotation )
            {
            // InternalXtext.g:10275:2: ( ruleAnnotation )
            // InternalXtext.g:10276:3: ruleAnnotation
            {
             before(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__AnnotationsAssignment_0"


    // $ANTLR start "rule__TerminalRule__FragmentAssignment_2_0_0"
    // InternalXtext.g:10285:1: rule__TerminalRule__FragmentAssignment_2_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__TerminalRule__FragmentAssignment_2_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10289:1: ( ( ( 'fragment' ) ) )
            // InternalXtext.g:10290:2: ( ( 'fragment' ) )
            {
            // InternalXtext.g:10290:2: ( ( 'fragment' ) )
            // InternalXtext.g:10291:3: ( 'fragment' )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 
            // InternalXtext.g:10292:3: ( 'fragment' )
            // InternalXtext.g:10293:4: 'fragment'
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 
            match(input,54,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 

            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__FragmentAssignment_2_0_0"


    // $ANTLR start "rule__TerminalRule__NameAssignment_2_0_1"
    // InternalXtext.g:10304:1: rule__TerminalRule__NameAssignment_2_0_1 : ( ruleValidID ) ;
    public final void rule__TerminalRule__NameAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10308:1: ( ( ruleValidID ) )
            // InternalXtext.g:10309:2: ( ruleValidID )
            {
            // InternalXtext.g:10309:2: ( ruleValidID )
            // InternalXtext.g:10310:3: ruleValidID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_2_0_1"


    // $ANTLR start "rule__TerminalRule__NameAssignment_2_1_0"
    // InternalXtext.g:10319:1: rule__TerminalRule__NameAssignment_2_1_0 : ( ruleValidID ) ;
    public final void rule__TerminalRule__NameAssignment_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10323:1: ( ( ruleValidID ) )
            // InternalXtext.g:10324:2: ( ruleValidID )
            {
            // InternalXtext.g:10324:2: ( ruleValidID )
            // InternalXtext.g:10325:3: ruleValidID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_2_1_0"


    // $ANTLR start "rule__TerminalRule__TypeAssignment_2_1_1_1"
    // InternalXtext.g:10334:1: rule__TerminalRule__TypeAssignment_2_1_1_1 : ( ruleTypeRef ) ;
    public final void rule__TerminalRule__TypeAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10338:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10339:2: ( ruleTypeRef )
            {
            // InternalXtext.g:10339:2: ( ruleTypeRef )
            // InternalXtext.g:10340:3: ruleTypeRef
            {
             before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__TypeAssignment_2_1_1_1"


    // $ANTLR start "rule__TerminalRule__AlternativesAssignment_4"
    // InternalXtext.g:10349:1: rule__TerminalRule__AlternativesAssignment_4 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10353:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtext.g:10354:2: ( ruleTerminalAlternatives )
            {
            // InternalXtext.g:10354:2: ( ruleTerminalAlternatives )
            // InternalXtext.g:10355:3: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__AlternativesAssignment_4"


    // $ANTLR start "rule__TerminalAlternatives__ElementsAssignment_1_1_1"
    // InternalXtext.g:10364:1: rule__TerminalAlternatives__ElementsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10368:1: ( ( ruleTerminalGroup ) )
            // InternalXtext.g:10369:2: ( ruleTerminalGroup )
            {
            // InternalXtext.g:10369:2: ( ruleTerminalGroup )
            // InternalXtext.g:10370:3: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__TerminalGroup__ElementsAssignment_1_1"
    // InternalXtext.g:10379:1: rule__TerminalGroup__ElementsAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10383:1: ( ( ruleTerminalToken ) )
            // InternalXtext.g:10384:2: ( ruleTerminalToken )
            {
            // InternalXtext.g:10384:2: ( ruleTerminalToken )
            // InternalXtext.g:10385:3: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__ElementsAssignment_1_1"


    // $ANTLR start "rule__TerminalToken__CardinalityAssignment_1"
    // InternalXtext.g:10394:1: rule__TerminalToken__CardinalityAssignment_1 : ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) ;
    public final void rule__TerminalToken__CardinalityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10398:1: ( ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) ) )
            // InternalXtext.g:10399:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            {
            // InternalXtext.g:10399:2: ( ( rule__TerminalToken__CardinalityAlternatives_1_0 ) )
            // InternalXtext.g:10400:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 
            // InternalXtext.g:10401:3: ( rule__TerminalToken__CardinalityAlternatives_1_0 )
            // InternalXtext.g:10401:4: rule__TerminalToken__CardinalityAlternatives_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__CardinalityAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__CardinalityAssignment_1"


    // $ANTLR start "rule__NegatedToken__TerminalAssignment_1"
    // InternalXtext.g:10409:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10413:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:10414:2: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:10414:2: ( ruleTerminalTokenElement )
            // InternalXtext.g:10415:3: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__TerminalAssignment_1"


    // $ANTLR start "rule__UntilToken__TerminalAssignment_1"
    // InternalXtext.g:10424:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10428:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtext.g:10429:2: ( ruleTerminalTokenElement )
            {
            // InternalXtext.g:10429:2: ( ruleTerminalTokenElement )
            // InternalXtext.g:10430:3: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__TerminalAssignment_1"


    // $ANTLR start "rule__CharacterRange__RightAssignment_1_2"
    // InternalXtext.g:10439:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10443:1: ( ( ruleKeyword ) )
            // InternalXtext.g:10444:2: ( ruleKeyword )
            {
            // InternalXtext.g:10444:2: ( ruleKeyword )
            // InternalXtext.g:10445:3: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__RightAssignment_1_2"


    // $ANTLR start "rule__EnumRule__AnnotationsAssignment_0"
    // InternalXtext.g:10454:1: rule__EnumRule__AnnotationsAssignment_0 : ( ruleAnnotation ) ;
    public final void rule__EnumRule__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10458:1: ( ( ruleAnnotation ) )
            // InternalXtext.g:10459:2: ( ruleAnnotation )
            {
            // InternalXtext.g:10459:2: ( ruleAnnotation )
            // InternalXtext.g:10460:3: ruleAnnotation
            {
             before(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAnnotation();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__AnnotationsAssignment_0"


    // $ANTLR start "rule__EnumRule__NameAssignment_2"
    // InternalXtext.g:10469:1: rule__EnumRule__NameAssignment_2 : ( ruleValidID ) ;
    public final void rule__EnumRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10473:1: ( ( ruleValidID ) )
            // InternalXtext.g:10474:2: ( ruleValidID )
            {
            // InternalXtext.g:10474:2: ( ruleValidID )
            // InternalXtext.g:10475:3: ruleValidID
            {
             before(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleValidID();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__NameAssignment_2"


    // $ANTLR start "rule__EnumRule__TypeAssignment_3_1"
    // InternalXtext.g:10484:1: rule__EnumRule__TypeAssignment_3_1 : ( ruleTypeRef ) ;
    public final void rule__EnumRule__TypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10488:1: ( ( ruleTypeRef ) )
            // InternalXtext.g:10489:2: ( ruleTypeRef )
            {
            // InternalXtext.g:10489:2: ( ruleTypeRef )
            // InternalXtext.g:10490:3: ruleTypeRef
            {
             before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__TypeAssignment_3_1"


    // $ANTLR start "rule__EnumRule__AlternativesAssignment_5"
    // InternalXtext.g:10499:1: rule__EnumRule__AlternativesAssignment_5 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10503:1: ( ( ruleEnumLiterals ) )
            // InternalXtext.g:10504:2: ( ruleEnumLiterals )
            {
            // InternalXtext.g:10504:2: ( ruleEnumLiterals )
            // InternalXtext.g:10505:3: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__AlternativesAssignment_5"


    // $ANTLR start "rule__EnumLiterals__ElementsAssignment_1_1_1"
    // InternalXtext.g:10514:1: rule__EnumLiterals__ElementsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10518:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtext.g:10519:2: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtext.g:10519:2: ( ruleEnumLiteralDeclaration )
            // InternalXtext.g:10520:3: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"
    // InternalXtext.g:10529:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10533:1: ( ( ( RULE_ID ) ) )
            // InternalXtext.g:10534:2: ( ( RULE_ID ) )
            {
            // InternalXtext.g:10534:2: ( ( RULE_ID ) )
            // InternalXtext.g:10535:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // InternalXtext.g:10536:3: ( RULE_ID )
            // InternalXtext.g:10537:4: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"


    // $ANTLR start "rule__EnumLiteralDeclaration__LiteralAssignment_1_1"
    // InternalXtext.g:10548:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtext.g:10552:1: ( ( ruleKeyword ) )
            // InternalXtext.g:10553:2: ( ruleKeyword )
            {
            // InternalXtext.g:10553:2: ( ruleKeyword )
            // InternalXtext.g:10554:3: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__LiteralAssignment_1_1"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\2\4\3\uffff\1\4";
    static final String dfa_3s = "\1\66\1\4\3\uffff\1\66";
    static final String dfa_4s = "\2\uffff\1\1\1\2\1\3\1\uffff";
    static final String dfa_5s = "\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\14\uffff\2\2\14\uffff\1\1\17\uffff\1\3\3\uffff\1\4\2\uffff\1\2",
            "\1\5",
            "",
            "",
            "",
            "\1\2\14\uffff\2\2\14\uffff\1\1\17\uffff\1\3\3\uffff\1\4\2\uffff\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1619:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\3\uffff\3\6\1\uffff\3\6\1\uffff";
    static final String dfa_9s = "\6\4\1\uffff\3\4\1\uffff";
    static final String dfa_10s = "\1\67\2\27\3\67\1\uffff\3\67\1\uffff";
    static final String dfa_11s = "\6\uffff\1\2\3\uffff\1\1";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\6\12\uffff\1\5\1\4\4\uffff\1\6\30\uffff\1\2\6\uffff\1\1",
            "\1\7\1\uffff\1\6\12\uffff\1\11\1\10\4\uffff\1\6",
            "\1\7\1\uffff\1\6\12\uffff\1\11\1\10\4\uffff\1\6",
            "\1\6\1\uffff\2\6\4\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\10\uffff\1\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\6\uffff\1\6\6\uffff\1\6",
            "\1\6\1\uffff\2\6\4\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\10\uffff\1\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\6\uffff\1\6\6\uffff\1\6",
            "\1\6\1\uffff\2\6\4\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\10\uffff\1\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\6\uffff\1\6\6\uffff\1\6",
            "",
            "\1\6\1\uffff\2\6\4\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\10\uffff\1\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\6\uffff\1\6\6\uffff\1\6",
            "\1\6\1\uffff\2\6\4\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\10\uffff\1\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\6\uffff\1\6\6\uffff\1\6",
            "\1\6\1\uffff\2\6\4\uffff\3\6\2\12\2\6\1\12\3\uffff\2\6\10\uffff\1\6\1\uffff\1\6\1\uffff\3\6\1\uffff\1\6\6\uffff\1\6\6\uffff\1\6",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1784:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000060010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0030000056200000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000050000002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0048800080060010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0048800080060012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001060010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0040000080060010L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0010000100000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00810208008600D0L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400002000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000010L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000100000860010L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00810200008600D0L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00810200008600D2L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000007000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000040008000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000001000400000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000860010L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0081000000060010L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000098000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000200000860050L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000404000000000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000060050L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000800080000000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0040000000060010L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0003100008860050L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0003100008860052L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000500000000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0020000006000002L});
    }


}