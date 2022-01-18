package org.eclipse.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.services.XtextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_JAVACODESTRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'grammar'", "'with'", "','", "'hidden'", "'('", "')'", "'tokenLimit'", "'hoistingDebug'", "'setup'", "'.'", "'generate'", "'as'", "'import'", "'@'", "'fragment'", "'*'", "'returns'", "':'", "';'", "'<'", "'>'", "'::'", "'|'", "'&'", "'?=>'", "'?'", "'+'", "'{'", "'='", "'+='", "'current'", "'}'", "'true'", "'false'", "'!'", "'=>'", "'->'", "'?='", "'['", "']'", "'terminal'", "'EOF'", "'..'", "'enum'"
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
    public static final int RULE_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
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

        public InternalXtextParser(TokenStream input, XtextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Grammar";
       	}

       	@Override
       	protected XtextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleGrammar"
    // InternalXtext.g:64:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // InternalXtext.g:64:48: (iv_ruleGrammar= ruleGrammar EOF )
            // InternalXtext.g:65:2: iv_ruleGrammar= ruleGrammar EOF
            {
             newCompositeNode(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGrammar=ruleGrammar();

            state._fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // InternalXtext.g:71:1: ruleGrammar returns [EObject current=null] : (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) ) ) ( (lv_rules_18_0= ruleAbstractRule ) )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_definesHiddenTokens_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token lv_tokenLimit_15_0=null;
        Token lv_debug_16_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_metamodelDeclarations_12_0 = null;

        EObject lv_initBlock_17_0 = null;

        EObject lv_rules_18_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:77:2: ( (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) ) ) ( (lv_rules_18_0= ruleAbstractRule ) )+ ) )
            // InternalXtext.g:78:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) ) ) ( (lv_rules_18_0= ruleAbstractRule ) )+ )
            {
            // InternalXtext.g:78:2: (otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) ) ) ( (lv_rules_18_0= ruleAbstractRule ) )+ )
            // InternalXtext.g:79:3: otherlv_0= 'grammar' ( (lv_name_1_0= ruleGrammarID ) ) (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )? ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )? ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )* ( ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) ) ) ( (lv_rules_18_0= ruleAbstractRule ) )+
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGrammarAccess().getGrammarKeyword_0());
            		
            // InternalXtext.g:83:3: ( (lv_name_1_0= ruleGrammarID ) )
            // InternalXtext.g:84:4: (lv_name_1_0= ruleGrammarID )
            {
            // InternalXtext.g:84:4: (lv_name_1_0= ruleGrammarID )
            // InternalXtext.g:85:5: lv_name_1_0= ruleGrammarID
            {

            					newCompositeNode(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_name_1_0=ruleGrammarID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGrammarRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.Xtext.GrammarID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:102:3: (otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtext.g:103:4: otherlv_2= 'with' ( ( ruleGrammarID ) ) (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getGrammarAccess().getWithKeyword_2_0());
                    			
                    // InternalXtext.g:107:4: ( ( ruleGrammarID ) )
                    // InternalXtext.g:108:5: ( ruleGrammarID )
                    {
                    // InternalXtext.g:108:5: ( ruleGrammarID )
                    // InternalXtext.g:109:6: ruleGrammarID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGrammarRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleGrammarID();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtext.g:123:4: (otherlv_4= ',' ( ( ruleGrammarID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalXtext.g:124:5: otherlv_4= ',' ( ( ruleGrammarID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalXtext.g:128:5: ( ( ruleGrammarID ) )
                    	    // InternalXtext.g:129:6: ( ruleGrammarID )
                    	    {
                    	    // InternalXtext.g:129:6: ( ruleGrammarID )
                    	    // InternalXtext.g:130:7: ruleGrammarID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getGrammarRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    ruleGrammarID();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalXtext.g:146:3: ( ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtext.g:147:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) ) otherlv_7= '(' ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )? otherlv_11= ')'
                    {
                    // InternalXtext.g:147:4: ( (lv_definesHiddenTokens_6_0= 'hidden' ) )
                    // InternalXtext.g:148:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    {
                    // InternalXtext.g:148:5: (lv_definesHiddenTokens_6_0= 'hidden' )
                    // InternalXtext.g:149:6: lv_definesHiddenTokens_6_0= 'hidden'
                    {
                    lv_definesHiddenTokens_6_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_definesHiddenTokens_6_0, grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGrammarRule());
                    						}
                    						setWithLastConsumed(current, "definesHiddenTokens", lv_definesHiddenTokens_6_0 != null, "hidden");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalXtext.g:165:4: ( ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||(LA4_0>=44 && LA4_0<=45)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalXtext.g:166:5: ( ( ruleRuleID ) ) (otherlv_9= ',' ( ( ruleRuleID ) ) )*
                            {
                            // InternalXtext.g:166:5: ( ( ruleRuleID ) )
                            // InternalXtext.g:167:6: ( ruleRuleID )
                            {
                            // InternalXtext.g:167:6: ( ruleRuleID )
                            // InternalXtext.g:168:7: ruleRuleID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getGrammarRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_8);
                            ruleRuleID();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalXtext.g:182:5: (otherlv_9= ',' ( ( ruleRuleID ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==14) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // InternalXtext.g:183:6: otherlv_9= ',' ( ( ruleRuleID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            	    						newLeafNode(otherlv_9, grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0());
                            	    					
                            	    // InternalXtext.g:187:6: ( ( ruleRuleID ) )
                            	    // InternalXtext.g:188:7: ( ruleRuleID )
                            	    {
                            	    // InternalXtext.g:188:7: ( ruleRuleID )
                            	    // InternalXtext.g:189:8: ruleRuleID
                            	    {

                            	    								if (current==null) {
                            	    									current = createModelElement(grammarAccess.getGrammarRule());
                            	    								}
                            	    							

                            	    								newCompositeNode(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_8);
                            	    ruleRuleID();

                            	    state._fsp--;


                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_11, grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalXtext.g:210:3: ( (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22||LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalXtext.g:211:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    {
            	    // InternalXtext.g:211:4: (lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration )
            	    // InternalXtext.g:212:5: lv_metamodelDeclarations_12_0= ruleAbstractMetamodelDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_metamodelDeclarations_12_0=ruleAbstractMetamodelDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"metamodelDeclarations",
            	    						lv_metamodelDeclarations_12_0,
            	    						"org.eclipse.xtext.Xtext.AbstractMetamodelDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalXtext.g:229:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) ) )
            // InternalXtext.g:230:4: ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) )
            {
            // InternalXtext.g:230:4: ( ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* ) )
            // InternalXtext.g:231:5: ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            				
            // InternalXtext.g:234:5: ( ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )* )
            // InternalXtext.g:235:6: ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )*
            {
            // InternalXtext.g:235:6: ( ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) ) )*
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( LA7_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
                    alt7=3;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXtext.g:236:4: ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalXtext.g:236:4: ({...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) ) )
            	    // InternalXtext.g:237:5: {...}? => ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGrammar", "getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalXtext.g:237:104: ( ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) ) )
            	    // InternalXtext.g:238:6: ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 0);
            	    					
            	    // InternalXtext.g:241:9: ({...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) ) )
            	    // InternalXtext.g:241:10: {...}? => (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGrammar", "true");
            	    }
            	    // InternalXtext.g:241:19: (otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) ) )
            	    // InternalXtext.g:241:20: otherlv_14= 'tokenLimit' ( (lv_tokenLimit_15_0= RULE_INT ) )
            	    {
            	    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_9); 

            	    									newLeafNode(otherlv_14, grammarAccess.getGrammarAccess().getTokenLimitKeyword_5_0_0());
            	    								
            	    // InternalXtext.g:245:9: ( (lv_tokenLimit_15_0= RULE_INT ) )
            	    // InternalXtext.g:246:10: (lv_tokenLimit_15_0= RULE_INT )
            	    {
            	    // InternalXtext.g:246:10: (lv_tokenLimit_15_0= RULE_INT )
            	    // InternalXtext.g:247:11: lv_tokenLimit_15_0= RULE_INT
            	    {
            	    lv_tokenLimit_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

            	    											newLeafNode(lv_tokenLimit_15_0, grammarAccess.getGrammarAccess().getTokenLimitINTTerminalRuleCall_5_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getGrammarRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"tokenLimit",
            	    												lv_tokenLimit_15_0,
            	    												"org.eclipse.xtext.common.Terminals.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXtext.g:269:4: ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) )
            	    {
            	    // InternalXtext.g:269:4: ({...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) ) )
            	    // InternalXtext.g:270:5: {...}? => ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGrammar", "getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalXtext.g:270:104: ( ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) ) )
            	    // InternalXtext.g:271:6: ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 1);
            	    					
            	    // InternalXtext.g:274:9: ({...}? => ( (lv_debug_16_0= 'hoistingDebug' ) ) )
            	    // InternalXtext.g:274:10: {...}? => ( (lv_debug_16_0= 'hoistingDebug' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGrammar", "true");
            	    }
            	    // InternalXtext.g:274:19: ( (lv_debug_16_0= 'hoistingDebug' ) )
            	    // InternalXtext.g:274:20: (lv_debug_16_0= 'hoistingDebug' )
            	    {
            	    // InternalXtext.g:274:20: (lv_debug_16_0= 'hoistingDebug' )
            	    // InternalXtext.g:275:10: lv_debug_16_0= 'hoistingDebug'
            	    {
            	    lv_debug_16_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

            	    										newLeafNode(lv_debug_16_0, grammarAccess.getGrammarAccess().getDebugHoistingDebugKeyword_5_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getGrammarRule());
            	    										}
            	    										setWithLastConsumed(current, "debug", lv_debug_16_0 != null, "hoistingDebug");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalXtext.g:292:4: ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) )
            	    {
            	    // InternalXtext.g:292:4: ({...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) ) )
            	    // InternalXtext.g:293:5: {...}? => ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGrammar", "getUnorderedGroupHelper().canSelect(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // InternalXtext.g:293:104: ( ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) ) )
            	    // InternalXtext.g:294:6: ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getGrammarAccess().getUnorderedGroup_5(), 2);
            	    					
            	    // InternalXtext.g:297:9: ({...}? => ( (lv_initBlock_17_0= ruleInitBlock ) ) )
            	    // InternalXtext.g:297:10: {...}? => ( (lv_initBlock_17_0= ruleInitBlock ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGrammar", "true");
            	    }
            	    // InternalXtext.g:297:19: ( (lv_initBlock_17_0= ruleInitBlock ) )
            	    // InternalXtext.g:297:20: (lv_initBlock_17_0= ruleInitBlock )
            	    {
            	    // InternalXtext.g:297:20: (lv_initBlock_17_0= ruleInitBlock )
            	    // InternalXtext.g:298:10: lv_initBlock_17_0= ruleInitBlock
            	    {

            	    										newCompositeNode(grammarAccess.getGrammarAccess().getInitBlockInitBlockParserRuleCall_5_2_0());
            	    									
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_initBlock_17_0=ruleInitBlock();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    										}
            	    										set(
            	    											current,
            	    											"initBlock",
            	    											lv_initBlock_17_0,
            	    											"org.eclipse.xtext.Xtext.InitBlock");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getGrammarAccess().getUnorderedGroup_5());
            				

            }

            // InternalXtext.g:327:3: ( (lv_rules_18_0= ruleAbstractRule ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||(LA8_0>=25 && LA8_0<=26)||(LA8_0>=44 && LA8_0<=45)||LA8_0==52||LA8_0==55) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXtext.g:328:4: (lv_rules_18_0= ruleAbstractRule )
            	    {
            	    // InternalXtext.g:328:4: (lv_rules_18_0= ruleAbstractRule )
            	    // InternalXtext.g:329:5: lv_rules_18_0= ruleAbstractRule
            	    {

            	    					newCompositeNode(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_6_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_rules_18_0=ruleAbstractRule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGrammarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rules",
            	    						lv_rules_18_0,
            	    						"org.eclipse.xtext.Xtext.AbstractRule");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "entryRuleInitBlock"
    // InternalXtext.g:350:1: entryRuleInitBlock returns [EObject current=null] : iv_ruleInitBlock= ruleInitBlock EOF ;
    public final EObject entryRuleInitBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitBlock = null;


        try {
            // InternalXtext.g:350:50: (iv_ruleInitBlock= ruleInitBlock EOF )
            // InternalXtext.g:351:2: iv_ruleInitBlock= ruleInitBlock EOF
            {
             newCompositeNode(grammarAccess.getInitBlockRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInitBlock=ruleInitBlock();

            state._fsp--;

             current =iv_ruleInitBlock; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitBlock"


    // $ANTLR start "ruleInitBlock"
    // InternalXtext.g:357:1: ruleInitBlock returns [EObject current=null] : (otherlv_0= 'setup' ( (lv_code_1_0= ruleJavaCode ) ) ) ;
    public final EObject ruleInitBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_code_1_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:363:2: ( (otherlv_0= 'setup' ( (lv_code_1_0= ruleJavaCode ) ) ) )
            // InternalXtext.g:364:2: (otherlv_0= 'setup' ( (lv_code_1_0= ruleJavaCode ) ) )
            {
            // InternalXtext.g:364:2: (otherlv_0= 'setup' ( (lv_code_1_0= ruleJavaCode ) ) )
            // InternalXtext.g:365:3: otherlv_0= 'setup' ( (lv_code_1_0= ruleJavaCode ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getInitBlockAccess().getSetupKeyword_0());
            		
            // InternalXtext.g:369:3: ( (lv_code_1_0= ruleJavaCode ) )
            // InternalXtext.g:370:4: (lv_code_1_0= ruleJavaCode )
            {
            // InternalXtext.g:370:4: (lv_code_1_0= ruleJavaCode )
            // InternalXtext.g:371:5: lv_code_1_0= ruleJavaCode
            {

            					newCompositeNode(grammarAccess.getInitBlockAccess().getCodeJavaCodeParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_code_1_0=ruleJavaCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitBlockRule());
            					}
            					set(
            						current,
            						"code",
            						lv_code_1_0,
            						"org.eclipse.xtext.Xtext.JavaCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitBlock"


    // $ANTLR start "entryRuleGrammarID"
    // InternalXtext.g:392:1: entryRuleGrammarID returns [String current=null] : iv_ruleGrammarID= ruleGrammarID EOF ;
    public final String entryRuleGrammarID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGrammarID = null;


        try {
            // InternalXtext.g:392:49: (iv_ruleGrammarID= ruleGrammarID EOF )
            // InternalXtext.g:393:2: iv_ruleGrammarID= ruleGrammarID EOF
            {
             newCompositeNode(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGrammarID=ruleGrammarID();

            state._fsp--;

             current =iv_ruleGrammarID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // InternalXtext.g:399:1: ruleGrammarID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleGrammarID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalXtext.g:405:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalXtext.g:406:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalXtext.g:406:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalXtext.g:407:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_12);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:417:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalXtext.g:418:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalXtext.g:438:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // InternalXtext.g:438:53: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // InternalXtext.g:439:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalXtext.g:445:1: ruleAbstractRule returns [EObject current=null] : (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ParserRule_0 = null;

        EObject this_TerminalRule_1 = null;

        EObject this_EnumRule_2 = null;



        	enterRule();

        try {
            // InternalXtext.g:451:2: ( (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule ) )
            // InternalXtext.g:452:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            {
            // InternalXtext.g:452:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalXtext.g:453:3: this_ParserRule_0= ruleParserRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParserRule_0=ruleParserRule();

                    state._fsp--;


                    			current = this_ParserRule_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:462:3: this_TerminalRule_1= ruleTerminalRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TerminalRule_1=ruleTerminalRule();

                    state._fsp--;


                    			current = this_TerminalRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:471:3: this_EnumRule_2= ruleEnumRule
                    {

                    			newCompositeNode(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EnumRule_2=ruleEnumRule();

                    state._fsp--;


                    			current = this_EnumRule_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // InternalXtext.g:483:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // InternalXtext.g:483:69: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // InternalXtext.g:484:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();

            state._fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // InternalXtext.g:490:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel_0 = null;

        EObject this_ReferencedMetamodel_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:496:2: ( (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel ) )
            // InternalXtext.g:497:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            {
            // InternalXtext.g:497:2: (this_GeneratedMetamodel_0= ruleGeneratedMetamodel | this_ReferencedMetamodel_1= ruleReferencedMetamodel )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalXtext.g:498:3: this_GeneratedMetamodel_0= ruleGeneratedMetamodel
                    {

                    			newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GeneratedMetamodel_0=ruleGeneratedMetamodel();

                    state._fsp--;


                    			current = this_GeneratedMetamodel_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:507:3: this_ReferencedMetamodel_1= ruleReferencedMetamodel
                    {

                    			newCompositeNode(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferencedMetamodel_1=ruleReferencedMetamodel();

                    state._fsp--;


                    			current = this_ReferencedMetamodel_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // InternalXtext.g:519:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // InternalXtext.g:519:59: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // InternalXtext.g:520:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();

            state._fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // InternalXtext.g:526:1: ruleGeneratedMetamodel returns [EObject current=null] : (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_alias_4_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:532:2: ( (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? ) )
            // InternalXtext.g:533:2: (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? )
            {
            // InternalXtext.g:533:2: (otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )? )
            // InternalXtext.g:534:3: otherlv_0= 'generate' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )?
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0());
            		
            // InternalXtext.g:538:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalXtext.g:539:4: (lv_name_1_0= ruleValidID )
            {
            // InternalXtext.g:539:4: (lv_name_1_0= ruleValidID )
            // InternalXtext.g:540:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_13);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneratedMetamodelRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.Xtext.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:557:3: ( (otherlv_2= RULE_STRING ) )
            // InternalXtext.g:558:4: (otherlv_2= RULE_STRING )
            {
            // InternalXtext.g:558:4: (otherlv_2= RULE_STRING )
            // InternalXtext.g:559:5: otherlv_2= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneratedMetamodelRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_14); 

            					newLeafNode(otherlv_2, grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0());
            				

            }


            }

            // InternalXtext.g:570:3: (otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtext.g:571:4: otherlv_3= 'as' ( (lv_alias_4_0= ruleValidID ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0());
                    			
                    // InternalXtext.g:575:4: ( (lv_alias_4_0= ruleValidID ) )
                    // InternalXtext.g:576:5: (lv_alias_4_0= ruleValidID )
                    {
                    // InternalXtext.g:576:5: (lv_alias_4_0= ruleValidID )
                    // InternalXtext.g:577:6: lv_alias_4_0= ruleValidID
                    {

                    						newCompositeNode(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_alias_4_0=ruleValidID();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGeneratedMetamodelRule());
                    						}
                    						set(
                    							current,
                    							"alias",
                    							lv_alias_4_0,
                    							"org.eclipse.xtext.Xtext.ValidID");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // InternalXtext.g:599:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // InternalXtext.g:599:60: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // InternalXtext.g:600:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             newCompositeNode(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();

            state._fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // InternalXtext.g:606:1: ruleReferencedMetamodel returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_alias_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:612:2: ( (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? ) )
            // InternalXtext.g:613:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? )
            {
            // InternalXtext.g:613:2: (otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? )
            // InternalXtext.g:614:3: otherlv_0= 'import' ( (otherlv_1= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )?
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0());
            		
            // InternalXtext.g:618:3: ( (otherlv_1= RULE_STRING ) )
            // InternalXtext.g:619:4: (otherlv_1= RULE_STRING )
            {
            // InternalXtext.g:619:4: (otherlv_1= RULE_STRING )
            // InternalXtext.g:620:5: otherlv_1= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferencedMetamodelRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_14); 

            					newLeafNode(otherlv_1, grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0());
            				

            }


            }

            // InternalXtext.g:631:3: (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtext.g:632:4: otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) )
                    {
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0());
                    			
                    // InternalXtext.g:636:4: ( (lv_alias_3_0= ruleValidID ) )
                    // InternalXtext.g:637:5: (lv_alias_3_0= ruleValidID )
                    {
                    // InternalXtext.g:637:5: (lv_alias_3_0= ruleValidID )
                    // InternalXtext.g:638:6: lv_alias_3_0= ruleValidID
                    {

                    						newCompositeNode(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_alias_3_0=ruleValidID();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReferencedMetamodelRule());
                    						}
                    						set(
                    							current,
                    							"alias",
                    							lv_alias_3_0,
                    							"org.eclipse.xtext.Xtext.ValidID");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleAnnotation"
    // InternalXtext.g:660:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalXtext.g:660:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalXtext.g:661:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalXtext.g:667:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalXtext.g:673:2: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalXtext.g:674:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalXtext.g:674:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalXtext.g:675:3: otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalXtext.g:679:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXtext.g:680:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXtext.g:680:4: (lv_name_1_0= RULE_ID )
            // InternalXtext.g:681:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleParserRule"
    // InternalXtext.g:701:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // InternalXtext.g:701:51: (iv_ruleParserRule= ruleParserRule EOF )
            // InternalXtext.g:702:2: iv_ruleParserRule= ruleParserRule EOF
            {
             newCompositeNode(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParserRule=ruleParserRule();

            state._fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // InternalXtext.g:708:1: ruleParserRule returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) | (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')' )? otherlv_15= ':' ( (lv_alternatives_16_0= ruleAlternatives ) ) otherlv_17= ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_fragment_1_0=null;
        Token lv_wildcard_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_definesHiddenTokens_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_annotations_0_0 = null;

        EObject this_RuleNameAndParams_2 = null;

        EObject lv_type_5_0 = null;

        EObject this_RuleNameAndParams_6 = null;

        EObject lv_type_8_0 = null;

        EObject lv_alternatives_16_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:714:2: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) | (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')' )? otherlv_15= ':' ( (lv_alternatives_16_0= ruleAlternatives ) ) otherlv_17= ';' ) )
            // InternalXtext.g:715:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) | (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')' )? otherlv_15= ':' ( (lv_alternatives_16_0= ruleAlternatives ) ) otherlv_17= ';' )
            {
            // InternalXtext.g:715:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) | (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')' )? otherlv_15= ':' ( (lv_alternatives_16_0= ruleAlternatives ) ) otherlv_17= ';' )
            // InternalXtext.g:716:3: ( (lv_annotations_0_0= ruleAnnotation ) )* ( ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) | (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? ) ) ( ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')' )? otherlv_15= ':' ( (lv_alternatives_16_0= ruleAlternatives ) ) otherlv_17= ';'
            {
            // InternalXtext.g:716:3: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==25) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalXtext.g:717:4: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalXtext.g:717:4: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalXtext.g:718:5: lv_annotations_0_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParserRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"org.eclipse.xtext.Xtext.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // InternalXtext.g:735:3: ( ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) ) | (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID||(LA18_0>=44 && LA18_0<=45)) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtext.g:736:4: ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) )
                    {
                    // InternalXtext.g:736:4: ( ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? ) )
                    // InternalXtext.g:737:5: ( (lv_fragment_1_0= 'fragment' ) ) this_RuleNameAndParams_2= ruleRuleNameAndParams[$current] ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? )
                    {
                    // InternalXtext.g:737:5: ( (lv_fragment_1_0= 'fragment' ) )
                    // InternalXtext.g:738:6: (lv_fragment_1_0= 'fragment' )
                    {
                    // InternalXtext.g:738:6: (lv_fragment_1_0= 'fragment' )
                    // InternalXtext.g:739:7: lv_fragment_1_0= 'fragment'
                    {
                    lv_fragment_1_0=(Token)match(input,26,FollowSets000.FOLLOW_16); 

                    							newLeafNode(lv_fragment_1_0, grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getParserRuleRule());
                    							}
                    							setWithLastConsumed(current, "fragment", lv_fragment_1_0 != null, "fragment");
                    						

                    }


                    }


                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParserRuleRule());
                    					}
                    					newCompositeNode(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1());
                    				
                    pushFollow(FollowSets000.FOLLOW_17);
                    this_RuleNameAndParams_2=ruleRuleNameAndParams(current);

                    state._fsp--;


                    					current = this_RuleNameAndParams_2;
                    					afterParserOrEnumRuleCall();
                    				
                    // InternalXtext.g:762:5: ( ( (lv_wildcard_3_0= '*' ) ) | (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )? )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==27) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==15||(LA16_0>=28 && LA16_0<=29)) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalXtext.g:763:6: ( (lv_wildcard_3_0= '*' ) )
                            {
                            // InternalXtext.g:763:6: ( (lv_wildcard_3_0= '*' ) )
                            // InternalXtext.g:764:7: (lv_wildcard_3_0= '*' )
                            {
                            // InternalXtext.g:764:7: (lv_wildcard_3_0= '*' )
                            // InternalXtext.g:765:8: lv_wildcard_3_0= '*'
                            {
                            lv_wildcard_3_0=(Token)match(input,27,FollowSets000.FOLLOW_18); 

                            								newLeafNode(lv_wildcard_3_0, grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getParserRuleRule());
                            								}
                            								setWithLastConsumed(current, "wildcard", lv_wildcard_3_0 != null, "*");
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalXtext.g:778:6: (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )?
                            {
                            // InternalXtext.g:778:6: (otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) ) )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==28) ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // InternalXtext.g:779:7: otherlv_4= 'returns' ( (lv_type_5_0= ruleTypeRef ) )
                                    {
                                    otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_15); 

                                    							newLeafNode(otherlv_4, grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0());
                                    						
                                    // InternalXtext.g:783:7: ( (lv_type_5_0= ruleTypeRef ) )
                                    // InternalXtext.g:784:8: (lv_type_5_0= ruleTypeRef )
                                    {
                                    // InternalXtext.g:784:8: (lv_type_5_0= ruleTypeRef )
                                    // InternalXtext.g:785:9: lv_type_5_0= ruleTypeRef
                                    {

                                    									newCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0());
                                    								
                                    pushFollow(FollowSets000.FOLLOW_18);
                                    lv_type_5_0=ruleTypeRef();

                                    state._fsp--;


                                    									if (current==null) {
                                    										current = createModelElementForParent(grammarAccess.getParserRuleRule());
                                    									}
                                    									set(
                                    										current,
                                    										"type",
                                    										lv_type_5_0,
                                    										"org.eclipse.xtext.Xtext.TypeRef");
                                    									afterParserOrEnumRuleCall();
                                    								

                                    }


                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:806:4: (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? )
                    {
                    // InternalXtext.g:806:4: (this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )? )
                    // InternalXtext.g:807:5: this_RuleNameAndParams_6= ruleRuleNameAndParams[$current] (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )?
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParserRuleRule());
                    					}
                    					newCompositeNode(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_19);
                    this_RuleNameAndParams_6=ruleRuleNameAndParams(current);

                    state._fsp--;


                    					current = this_RuleNameAndParams_6;
                    					afterParserOrEnumRuleCall();
                    				
                    // InternalXtext.g:818:5: (otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==28) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalXtext.g:819:6: otherlv_7= 'returns' ( (lv_type_8_0= ruleTypeRef ) )
                            {
                            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_15); 

                            						newLeafNode(otherlv_7, grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0());
                            					
                            // InternalXtext.g:823:6: ( (lv_type_8_0= ruleTypeRef ) )
                            // InternalXtext.g:824:7: (lv_type_8_0= ruleTypeRef )
                            {
                            // InternalXtext.g:824:7: (lv_type_8_0= ruleTypeRef )
                            // InternalXtext.g:825:8: lv_type_8_0= ruleTypeRef
                            {

                            								newCompositeNode(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0());
                            							
                            pushFollow(FollowSets000.FOLLOW_18);
                            lv_type_8_0=ruleTypeRef();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getParserRuleRule());
                            								}
                            								set(
                            									current,
                            									"type",
                            									lv_type_8_0,
                            									"org.eclipse.xtext.Xtext.TypeRef");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalXtext.g:845:3: ( ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==15) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalXtext.g:846:4: ( (lv_definesHiddenTokens_9_0= 'hidden' ) ) otherlv_10= '(' ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )? otherlv_14= ')'
                    {
                    // InternalXtext.g:846:4: ( (lv_definesHiddenTokens_9_0= 'hidden' ) )
                    // InternalXtext.g:847:5: (lv_definesHiddenTokens_9_0= 'hidden' )
                    {
                    // InternalXtext.g:847:5: (lv_definesHiddenTokens_9_0= 'hidden' )
                    // InternalXtext.g:848:6: lv_definesHiddenTokens_9_0= 'hidden'
                    {
                    lv_definesHiddenTokens_9_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_definesHiddenTokens_9_0, grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParserRuleRule());
                    						}
                    						setWithLastConsumed(current, "definesHiddenTokens", lv_definesHiddenTokens_9_0 != null, "hidden");
                    					

                    }


                    }

                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalXtext.g:864:4: ( ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_ID||(LA20_0>=44 && LA20_0<=45)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalXtext.g:865:5: ( ( ruleRuleID ) ) (otherlv_12= ',' ( ( ruleRuleID ) ) )*
                            {
                            // InternalXtext.g:865:5: ( ( ruleRuleID ) )
                            // InternalXtext.g:866:6: ( ruleRuleID )
                            {
                            // InternalXtext.g:866:6: ( ruleRuleID )
                            // InternalXtext.g:867:7: ruleRuleID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getParserRuleRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_8);
                            ruleRuleID();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalXtext.g:881:5: (otherlv_12= ',' ( ( ruleRuleID ) ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==14) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // InternalXtext.g:882:6: otherlv_12= ',' ( ( ruleRuleID ) )
                            	    {
                            	    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                            	    						newLeafNode(otherlv_12, grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0());
                            	    					
                            	    // InternalXtext.g:886:6: ( ( ruleRuleID ) )
                            	    // InternalXtext.g:887:7: ( ruleRuleID )
                            	    {
                            	    // InternalXtext.g:887:7: ( ruleRuleID )
                            	    // InternalXtext.g:888:8: ruleRuleID
                            	    {

                            	    								if (current==null) {
                            	    									current = createModelElement(grammarAccess.getParserRuleRule());
                            	    								}
                            	    							

                            	    								newCompositeNode(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_8);
                            	    ruleRuleID();

                            	    state._fsp--;


                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_20); 

                    				newLeafNode(otherlv_14, grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,29,FollowSets000.FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getParserRuleAccess().getColonKeyword_3());
            		
            // InternalXtext.g:913:3: ( (lv_alternatives_16_0= ruleAlternatives ) )
            // InternalXtext.g:914:4: (lv_alternatives_16_0= ruleAlternatives )
            {
            // InternalXtext.g:914:4: (lv_alternatives_16_0= ruleAlternatives )
            // InternalXtext.g:915:5: lv_alternatives_16_0= ruleAlternatives
            {

            					newCompositeNode(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0());
            				
            pushFollow(FollowSets000.FOLLOW_22);
            lv_alternatives_16_0=ruleAlternatives();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParserRuleRule());
            					}
            					set(
            						current,
            						"alternatives",
            						lv_alternatives_16_0,
            						"org.eclipse.xtext.Xtext.Alternatives");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getParserRuleAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "ruleRuleNameAndParams"
    // InternalXtext.g:941:1: ruleRuleNameAndParams[EObject in_current] returns [EObject current=in_current] : ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? ) ;
    public final EObject ruleRuleNameAndParams(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:947:2: ( ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? ) )
            // InternalXtext.g:948:2: ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? )
            {
            // InternalXtext.g:948:2: ( ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )? )
            // InternalXtext.g:949:3: ( (lv_name_0_0= ruleValidID ) ) (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )?
            {
            // InternalXtext.g:949:3: ( (lv_name_0_0= ruleValidID ) )
            // InternalXtext.g:950:4: (lv_name_0_0= ruleValidID )
            {
            // InternalXtext.g:950:4: (lv_name_0_0= ruleValidID )
            // InternalXtext.g:951:5: lv_name_0_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_23);
            lv_name_0_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleNameAndParamsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.Xtext.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:968:3: (otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXtext.g:969:4: otherlv_1= '<' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_24); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0());
                    			
                    // InternalXtext.g:973:4: ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_ID) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalXtext.g:974:5: ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            {
                            // InternalXtext.g:974:5: ( (lv_parameters_2_0= ruleParameter ) )
                            // InternalXtext.g:975:6: (lv_parameters_2_0= ruleParameter )
                            {
                            // InternalXtext.g:975:6: (lv_parameters_2_0= ruleParameter )
                            // InternalXtext.g:976:7: lv_parameters_2_0= ruleParameter
                            {

                            							newCompositeNode(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_25);
                            lv_parameters_2_0=ruleParameter();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRuleNameAndParamsRule());
                            							}
                            							add(
                            								current,
                            								"parameters",
                            								lv_parameters_2_0,
                            								"org.eclipse.xtext.Xtext.Parameter");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalXtext.g:993:5: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==14) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // InternalXtext.g:994:6: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_15); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalXtext.g:998:6: ( (lv_parameters_4_0= ruleParameter ) )
                            	    // InternalXtext.g:999:7: (lv_parameters_4_0= ruleParameter )
                            	    {
                            	    // InternalXtext.g:999:7: (lv_parameters_4_0= ruleParameter )
                            	    // InternalXtext.g:1000:8: lv_parameters_4_0= ruleParameter
                            	    {

                            	    								newCompositeNode(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0());
                            	    							
                            	    pushFollow(FollowSets000.FOLLOW_25);
                            	    lv_parameters_4_0=ruleParameter();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRuleNameAndParamsRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"parameters",
                            	    									lv_parameters_4_0,
                            	    									"org.eclipse.xtext.Xtext.Parameter");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop22;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "entryRuleParameter"
    // InternalXtext.g:1028:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalXtext.g:1028:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalXtext.g:1029:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalXtext.g:1035:1: ruleParameter returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalXtext.g:1041:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalXtext.g:1042:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalXtext.g:1042:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalXtext.g:1043:3: (lv_name_0_0= RULE_ID )
            {
            // InternalXtext.g:1043:3: (lv_name_0_0= RULE_ID )
            // InternalXtext.g:1044:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getParameterRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeRef"
    // InternalXtext.g:1063:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalXtext.g:1063:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalXtext.g:1064:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             newCompositeNode(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalXtext.g:1070:1: ruleTypeRef returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalXtext.g:1076:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) ) )
            // InternalXtext.g:1077:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalXtext.g:1077:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) ) )
            // InternalXtext.g:1078:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )? ( (otherlv_2= RULE_ID ) )
            {
            // InternalXtext.g:1078:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==33) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalXtext.g:1079:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::'
                    {
                    // InternalXtext.g:1079:4: ( (otherlv_0= RULE_ID ) )
                    // InternalXtext.g:1080:5: (otherlv_0= RULE_ID )
                    {
                    // InternalXtext.g:1080:5: (otherlv_0= RULE_ID )
                    // InternalXtext.g:1081:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRefRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

                    						newLeafNode(otherlv_0, grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalXtext.g:1097:3: ( (otherlv_2= RULE_ID ) )
            // InternalXtext.g:1098:4: (otherlv_2= RULE_ID )
            {
            // InternalXtext.g:1098:4: (otherlv_2= RULE_ID )
            // InternalXtext.g:1099:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeRefRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // InternalXtext.g:1114:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // InternalXtext.g:1114:53: (iv_ruleAlternatives= ruleAlternatives EOF )
            // InternalXtext.g:1115:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAlternatives=ruleAlternatives();

            state._fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // InternalXtext.g:1121:1: ruleAlternatives returns [EObject current=null] : (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ConditionalBranch_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1127:2: ( (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? ) )
            // InternalXtext.g:1128:2: (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            {
            // InternalXtext.g:1128:2: (this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )? )
            // InternalXtext.g:1129:3: this_ConditionalBranch_0= ruleConditionalBranch ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_27);
            this_ConditionalBranch_0=ruleConditionalBranch();

            state._fsp--;


            			current = this_ConditionalBranch_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:1137:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+ )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXtext.g:1138:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    {
                    // InternalXtext.g:1138:4: ()
                    // InternalXtext.g:1139:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:1145:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalXtext.g:1146:5: otherlv_2= '|' ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_21); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtext.g:1150:5: ( (lv_elements_3_0= ruleConditionalBranch ) )
                    	    // InternalXtext.g:1151:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    {
                    	    // InternalXtext.g:1151:6: (lv_elements_3_0= ruleConditionalBranch )
                    	    // InternalXtext.g:1152:7: lv_elements_3_0= ruleConditionalBranch
                    	    {

                    	    							newCompositeNode(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    lv_elements_3_0=ruleConditionalBranch();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAlternativesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.Xtext.ConditionalBranch");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleConditionalBranch"
    // InternalXtext.g:1175:1: entryRuleConditionalBranch returns [EObject current=null] : iv_ruleConditionalBranch= ruleConditionalBranch EOF ;
    public final EObject entryRuleConditionalBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalBranch = null;


        try {
            // InternalXtext.g:1175:58: (iv_ruleConditionalBranch= ruleConditionalBranch EOF )
            // InternalXtext.g:1176:2: iv_ruleConditionalBranch= ruleConditionalBranch EOF
            {
             newCompositeNode(grammarAccess.getConditionalBranchRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConditionalBranch=ruleConditionalBranch();

            state._fsp--;

             current =iv_ruleConditionalBranch; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // InternalXtext.g:1182:1: ruleConditionalBranch returns [EObject current=null] : (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) ) ;
    public final EObject ruleConditionalBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_UnorderedGroup_0 = null;

        EObject lv_guardCondition_3_0 = null;

        EObject lv_elements_5_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1188:2: ( (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) ) )
            // InternalXtext.g:1189:2: (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) )
            {
            // InternalXtext.g:1189:2: (this_UnorderedGroup_0= ruleUnorderedGroup | ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_JAVACODESTRING)||LA29_0==16||LA29_0==39||(LA29_0>=44 && LA29_0<=45)||(LA29_0>=47 && LA29_0<=48)) ) {
                alt29=1;
            }
            else if ( (LA29_0==31) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtext.g:1190:3: this_UnorderedGroup_0= ruleUnorderedGroup
                    {

                    			newCompositeNode(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnorderedGroup_0=ruleUnorderedGroup();

                    state._fsp--;


                    			current = this_UnorderedGroup_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:1199:3: ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ )
                    {
                    // InternalXtext.g:1199:3: ( () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+ )
                    // InternalXtext.g:1200:4: () otherlv_2= '<' ( (lv_guardCondition_3_0= ruleDisjunction ) ) otherlv_4= '>' ( (lv_elements_5_0= ruleAbstractToken ) )+
                    {
                    // InternalXtext.g:1200:4: ()
                    // InternalXtext.g:1201:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConditionalBranchAccess().getGroupAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_28); 

                    				newLeafNode(otherlv_2, grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1());
                    			
                    // InternalXtext.g:1211:4: ( (lv_guardCondition_3_0= ruleDisjunction ) )
                    // InternalXtext.g:1212:5: (lv_guardCondition_3_0= ruleDisjunction )
                    {
                    // InternalXtext.g:1212:5: (lv_guardCondition_3_0= ruleDisjunction )
                    // InternalXtext.g:1213:6: lv_guardCondition_3_0= ruleDisjunction
                    {

                    						newCompositeNode(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_29);
                    lv_guardCondition_3_0=ruleDisjunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalBranchRule());
                    						}
                    						set(
                    							current,
                    							"guardCondition",
                    							lv_guardCondition_3_0,
                    							"org.eclipse.xtext.Xtext.Disjunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_30); 

                    				newLeafNode(otherlv_4, grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3());
                    			
                    // InternalXtext.g:1234:4: ( (lv_elements_5_0= ruleAbstractToken ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_JAVACODESTRING)||LA28_0==16||LA28_0==39||(LA28_0>=44 && LA28_0<=45)||(LA28_0>=47 && LA28_0<=48)) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalXtext.g:1235:5: (lv_elements_5_0= ruleAbstractToken )
                    	    {
                    	    // InternalXtext.g:1235:5: (lv_elements_5_0= ruleAbstractToken )
                    	    // InternalXtext.g:1236:6: lv_elements_5_0= ruleAbstractToken
                    	    {

                    	    						newCompositeNode(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_31);
                    	    lv_elements_5_0=ruleAbstractToken();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getConditionalBranchRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_5_0,
                    	    							"org.eclipse.xtext.Xtext.AbstractToken");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // InternalXtext.g:1258:1: entryRuleUnorderedGroup returns [EObject current=null] : iv_ruleUnorderedGroup= ruleUnorderedGroup EOF ;
    public final EObject entryRuleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnorderedGroup = null;


        try {
            // InternalXtext.g:1258:55: (iv_ruleUnorderedGroup= ruleUnorderedGroup EOF )
            // InternalXtext.g:1259:2: iv_ruleUnorderedGroup= ruleUnorderedGroup EOF
            {
             newCompositeNode(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnorderedGroup=ruleUnorderedGroup();

            state._fsp--;

             current =iv_ruleUnorderedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // InternalXtext.g:1265:1: ruleUnorderedGroup returns [EObject current=null] : (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) ;
    public final EObject ruleUnorderedGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Group_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1271:2: ( (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? ) )
            // InternalXtext.g:1272:2: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            {
            // InternalXtext.g:1272:2: (this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )? )
            // InternalXtext.g:1273:3: this_Group_0= ruleGroup ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_32);
            this_Group_0=ruleGroup();

            state._fsp--;


            			current = this_Group_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:1281:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+ )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtext.g:1282:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    {
                    // InternalXtext.g:1282:4: ()
                    // InternalXtext.g:1283:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:1289:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==35) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalXtext.g:1290:5: otherlv_2= '&' ( (lv_elements_3_0= ruleGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_30); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0());
                    	    				
                    	    // InternalXtext.g:1294:5: ( (lv_elements_3_0= ruleGroup ) )
                    	    // InternalXtext.g:1295:6: (lv_elements_3_0= ruleGroup )
                    	    {
                    	    // InternalXtext.g:1295:6: (lv_elements_3_0= ruleGroup )
                    	    // InternalXtext.g:1296:7: lv_elements_3_0= ruleGroup
                    	    {

                    	    							newCompositeNode(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_32);
                    	    lv_elements_3_0=ruleGroup();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getUnorderedGroupRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.Xtext.Group");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // InternalXtext.g:1319:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalXtext.g:1319:46: (iv_ruleGroup= ruleGroup EOF )
            // InternalXtext.g:1320:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalXtext.g:1326:1: ruleGroup returns [EObject current=null] : (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1332:2: ( (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? ) )
            // InternalXtext.g:1333:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            {
            // InternalXtext.g:1333:2: (this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )? )
            // InternalXtext.g:1334:3: this_AbstractToken_0= ruleAbstractToken ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            {

            			newCompositeNode(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_31);
            this_AbstractToken_0=ruleAbstractToken();

            state._fsp--;


            			current = this_AbstractToken_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:1342:3: ( () ( (lv_elements_2_0= ruleAbstractToken ) )+ )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_JAVACODESTRING)||LA33_0==16||LA33_0==39||(LA33_0>=44 && LA33_0<=45)||(LA33_0>=47 && LA33_0<=48)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXtext.g:1343:4: () ( (lv_elements_2_0= ruleAbstractToken ) )+
                    {
                    // InternalXtext.g:1343:4: ()
                    // InternalXtext.g:1344:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getGroupAccess().getGroupElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:1350:4: ( (lv_elements_2_0= ruleAbstractToken ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_JAVACODESTRING)||LA32_0==16||LA32_0==39||(LA32_0>=44 && LA32_0<=45)||(LA32_0>=47 && LA32_0<=48)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalXtext.g:1351:5: (lv_elements_2_0= ruleAbstractToken )
                    	    {
                    	    // InternalXtext.g:1351:5: (lv_elements_2_0= ruleAbstractToken )
                    	    // InternalXtext.g:1352:6: lv_elements_2_0= ruleAbstractToken
                    	    {

                    	    						newCompositeNode(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_31);
                    	    lv_elements_2_0=ruleAbstractToken();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getGroupRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_2_0,
                    	    							"org.eclipse.xtext.Xtext.AbstractToken");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // InternalXtext.g:1374:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // InternalXtext.g:1374:54: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // InternalXtext.g:1375:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractToken=ruleAbstractToken();

            state._fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // InternalXtext.g:1381:1: ruleAbstractToken returns [EObject current=null] : (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction | this_JavaAction_2= ruleJavaAction | this_SemanticPredicate_3= ruleSemanticPredicate ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractTokenWithCardinality_0 = null;

        EObject this_Action_1 = null;

        EObject this_JavaAction_2 = null;

        EObject this_SemanticPredicate_3 = null;



        	enterRule();

        try {
            // InternalXtext.g:1387:2: ( (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction | this_JavaAction_2= ruleJavaAction | this_SemanticPredicate_3= ruleSemanticPredicate ) )
            // InternalXtext.g:1388:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction | this_JavaAction_2= ruleJavaAction | this_SemanticPredicate_3= ruleSemanticPredicate )
            {
            // InternalXtext.g:1388:2: (this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality | this_Action_1= ruleAction | this_JavaAction_2= ruleJavaAction | this_SemanticPredicate_3= ruleSemanticPredicate )
            int alt34=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case 16:
            case 44:
            case 45:
            case 47:
            case 48:
                {
                alt34=1;
                }
                break;
            case 39:
                {
                alt34=2;
                }
                break;
            case RULE_JAVACODESTRING:
                {
                int LA34_3 = input.LA(2);

                if ( ((LA34_3>=36 && LA34_3<=37)) ) {
                    alt34=4;
                }
                else if ( (LA34_3==EOF||(LA34_3>=RULE_STRING && LA34_3<=RULE_JAVACODESTRING)||(LA34_3>=16 && LA34_3<=17)||LA34_3==30||(LA34_3>=34 && LA34_3<=35)||LA34_3==39||(LA34_3>=44 && LA34_3<=45)||(LA34_3>=47 && LA34_3<=48)) ) {
                    alt34=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalXtext.g:1389:3: this_AbstractTokenWithCardinality_0= ruleAbstractTokenWithCardinality
                    {

                    			newCompositeNode(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractTokenWithCardinality_0=ruleAbstractTokenWithCardinality();

                    state._fsp--;


                    			current = this_AbstractTokenWithCardinality_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:1398:3: this_Action_1= ruleAction
                    {

                    			newCompositeNode(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Action_1=ruleAction();

                    state._fsp--;


                    			current = this_Action_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:1407:3: this_JavaAction_2= ruleJavaAction
                    {

                    			newCompositeNode(grammarAccess.getAbstractTokenAccess().getJavaActionParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_JavaAction_2=ruleJavaAction();

                    state._fsp--;


                    			current = this_JavaAction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtext.g:1416:3: this_SemanticPredicate_3= ruleSemanticPredicate
                    {

                    			newCompositeNode(grammarAccess.getAbstractTokenAccess().getSemanticPredicateParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SemanticPredicate_3=ruleSemanticPredicate();

                    state._fsp--;


                    			current = this_SemanticPredicate_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleSemanticPredicate"
    // InternalXtext.g:1428:1: entryRuleSemanticPredicate returns [EObject current=null] : iv_ruleSemanticPredicate= ruleSemanticPredicate EOF ;
    public final EObject entryRuleSemanticPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSemanticPredicate = null;


        try {
            // InternalXtext.g:1428:58: (iv_ruleSemanticPredicate= ruleSemanticPredicate EOF )
            // InternalXtext.g:1429:2: iv_ruleSemanticPredicate= ruleSemanticPredicate EOF
            {
             newCompositeNode(grammarAccess.getSemanticPredicateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSemanticPredicate=ruleSemanticPredicate();

            state._fsp--;

             current =iv_ruleSemanticPredicate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSemanticPredicate"


    // $ANTLR start "ruleSemanticPredicate"
    // InternalXtext.g:1435:1: ruleSemanticPredicate returns [EObject current=null] : (this_DisambiguatingSemanticPredicate_0= ruleDisambiguatingSemanticPredicate | this_GatedSemanticPredicate_1= ruleGatedSemanticPredicate ) ;
    public final EObject ruleSemanticPredicate() throws RecognitionException {
        EObject current = null;

        EObject this_DisambiguatingSemanticPredicate_0 = null;

        EObject this_GatedSemanticPredicate_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:1441:2: ( (this_DisambiguatingSemanticPredicate_0= ruleDisambiguatingSemanticPredicate | this_GatedSemanticPredicate_1= ruleGatedSemanticPredicate ) )
            // InternalXtext.g:1442:2: (this_DisambiguatingSemanticPredicate_0= ruleDisambiguatingSemanticPredicate | this_GatedSemanticPredicate_1= ruleGatedSemanticPredicate )
            {
            // InternalXtext.g:1442:2: (this_DisambiguatingSemanticPredicate_0= ruleDisambiguatingSemanticPredicate | this_GatedSemanticPredicate_1= ruleGatedSemanticPredicate )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_JAVACODESTRING) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==36) ) {
                    alt35=2;
                }
                else if ( (LA35_1==37) ) {
                    alt35=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalXtext.g:1443:3: this_DisambiguatingSemanticPredicate_0= ruleDisambiguatingSemanticPredicate
                    {

                    			newCompositeNode(grammarAccess.getSemanticPredicateAccess().getDisambiguatingSemanticPredicateParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DisambiguatingSemanticPredicate_0=ruleDisambiguatingSemanticPredicate();

                    state._fsp--;


                    			current = this_DisambiguatingSemanticPredicate_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:1452:3: this_GatedSemanticPredicate_1= ruleGatedSemanticPredicate
                    {

                    			newCompositeNode(grammarAccess.getSemanticPredicateAccess().getGatedSemanticPredicateParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GatedSemanticPredicate_1=ruleGatedSemanticPredicate();

                    state._fsp--;


                    			current = this_GatedSemanticPredicate_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSemanticPredicate"


    // $ANTLR start "entryRuleGatedSemanticPredicate"
    // InternalXtext.g:1464:1: entryRuleGatedSemanticPredicate returns [EObject current=null] : iv_ruleGatedSemanticPredicate= ruleGatedSemanticPredicate EOF ;
    public final EObject entryRuleGatedSemanticPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGatedSemanticPredicate = null;


        try {
            // InternalXtext.g:1464:63: (iv_ruleGatedSemanticPredicate= ruleGatedSemanticPredicate EOF )
            // InternalXtext.g:1465:2: iv_ruleGatedSemanticPredicate= ruleGatedSemanticPredicate EOF
            {
             newCompositeNode(grammarAccess.getGatedSemanticPredicateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGatedSemanticPredicate=ruleGatedSemanticPredicate();

            state._fsp--;

             current =iv_ruleGatedSemanticPredicate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGatedSemanticPredicate"


    // $ANTLR start "ruleGatedSemanticPredicate"
    // InternalXtext.g:1471:1: ruleGatedSemanticPredicate returns [EObject current=null] : ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?=>' ) ;
    public final EObject ruleGatedSemanticPredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1477:2: ( ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?=>' ) )
            // InternalXtext.g:1478:2: ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?=>' )
            {
            // InternalXtext.g:1478:2: ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?=>' )
            // InternalXtext.g:1479:3: ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?=>'
            {
            // InternalXtext.g:1479:3: ( (lv_code_0_0= ruleJavaCode ) )
            // InternalXtext.g:1480:4: (lv_code_0_0= ruleJavaCode )
            {
            // InternalXtext.g:1480:4: (lv_code_0_0= ruleJavaCode )
            // InternalXtext.g:1481:5: lv_code_0_0= ruleJavaCode
            {

            					newCompositeNode(grammarAccess.getGatedSemanticPredicateAccess().getCodeJavaCodeParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_33);
            lv_code_0_0=ruleJavaCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGatedSemanticPredicateRule());
            					}
            					set(
            						current,
            						"code",
            						lv_code_0_0,
            						"org.eclipse.xtext.Xtext.JavaCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getGatedSemanticPredicateAccess().getQuestionMarkEqualsSignGreaterThanSignKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGatedSemanticPredicate"


    // $ANTLR start "entryRuleDisambiguatingSemanticPredicate"
    // InternalXtext.g:1506:1: entryRuleDisambiguatingSemanticPredicate returns [EObject current=null] : iv_ruleDisambiguatingSemanticPredicate= ruleDisambiguatingSemanticPredicate EOF ;
    public final EObject entryRuleDisambiguatingSemanticPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisambiguatingSemanticPredicate = null;


        try {
            // InternalXtext.g:1506:72: (iv_ruleDisambiguatingSemanticPredicate= ruleDisambiguatingSemanticPredicate EOF )
            // InternalXtext.g:1507:2: iv_ruleDisambiguatingSemanticPredicate= ruleDisambiguatingSemanticPredicate EOF
            {
             newCompositeNode(grammarAccess.getDisambiguatingSemanticPredicateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDisambiguatingSemanticPredicate=ruleDisambiguatingSemanticPredicate();

            state._fsp--;

             current =iv_ruleDisambiguatingSemanticPredicate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisambiguatingSemanticPredicate"


    // $ANTLR start "ruleDisambiguatingSemanticPredicate"
    // InternalXtext.g:1513:1: ruleDisambiguatingSemanticPredicate returns [EObject current=null] : ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?' ) ;
    public final EObject ruleDisambiguatingSemanticPredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1519:2: ( ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?' ) )
            // InternalXtext.g:1520:2: ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?' )
            {
            // InternalXtext.g:1520:2: ( ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?' )
            // InternalXtext.g:1521:3: ( (lv_code_0_0= ruleJavaCode ) ) otherlv_1= '?'
            {
            // InternalXtext.g:1521:3: ( (lv_code_0_0= ruleJavaCode ) )
            // InternalXtext.g:1522:4: (lv_code_0_0= ruleJavaCode )
            {
            // InternalXtext.g:1522:4: (lv_code_0_0= ruleJavaCode )
            // InternalXtext.g:1523:5: lv_code_0_0= ruleJavaCode
            {

            					newCompositeNode(grammarAccess.getDisambiguatingSemanticPredicateAccess().getCodeJavaCodeParserRuleCall_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_34);
            lv_code_0_0=ruleJavaCode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDisambiguatingSemanticPredicateRule());
            					}
            					set(
            						current,
            						"code",
            						lv_code_0_0,
            						"org.eclipse.xtext.Xtext.JavaCode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDisambiguatingSemanticPredicateAccess().getQuestionMarkKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisambiguatingSemanticPredicate"


    // $ANTLR start "entryRuleJavaAction"
    // InternalXtext.g:1548:1: entryRuleJavaAction returns [EObject current=null] : iv_ruleJavaAction= ruleJavaAction EOF ;
    public final EObject entryRuleJavaAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaAction = null;


        try {
            // InternalXtext.g:1548:51: (iv_ruleJavaAction= ruleJavaAction EOF )
            // InternalXtext.g:1549:2: iv_ruleJavaAction= ruleJavaAction EOF
            {
             newCompositeNode(grammarAccess.getJavaActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleJavaAction=ruleJavaAction();

            state._fsp--;

             current =iv_ruleJavaAction; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaAction"


    // $ANTLR start "ruleJavaAction"
    // InternalXtext.g:1555:1: ruleJavaAction returns [EObject current=null] : ( (lv_code_0_0= ruleJavaCode ) ) ;
    public final EObject ruleJavaAction() throws RecognitionException {
        EObject current = null;

        EObject lv_code_0_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1561:2: ( ( (lv_code_0_0= ruleJavaCode ) ) )
            // InternalXtext.g:1562:2: ( (lv_code_0_0= ruleJavaCode ) )
            {
            // InternalXtext.g:1562:2: ( (lv_code_0_0= ruleJavaCode ) )
            // InternalXtext.g:1563:3: (lv_code_0_0= ruleJavaCode )
            {
            // InternalXtext.g:1563:3: (lv_code_0_0= ruleJavaCode )
            // InternalXtext.g:1564:4: lv_code_0_0= ruleJavaCode
            {

            				newCompositeNode(grammarAccess.getJavaActionAccess().getCodeJavaCodeParserRuleCall_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_code_0_0=ruleJavaCode();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getJavaActionRule());
            				}
            				set(
            					current,
            					"code",
            					lv_code_0_0,
            					"org.eclipse.xtext.Xtext.JavaCode");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaAction"


    // $ANTLR start "entryRuleJavaCode"
    // InternalXtext.g:1584:1: entryRuleJavaCode returns [EObject current=null] : iv_ruleJavaCode= ruleJavaCode EOF ;
    public final EObject entryRuleJavaCode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaCode = null;


        try {
            // InternalXtext.g:1584:49: (iv_ruleJavaCode= ruleJavaCode EOF )
            // InternalXtext.g:1585:2: iv_ruleJavaCode= ruleJavaCode EOF
            {
             newCompositeNode(grammarAccess.getJavaCodeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleJavaCode=ruleJavaCode();

            state._fsp--;

             current =iv_ruleJavaCode; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaCode"


    // $ANTLR start "ruleJavaCode"
    // InternalXtext.g:1591:1: ruleJavaCode returns [EObject current=null] : ( (lv_source_0_0= RULE_JAVACODESTRING ) ) ;
    public final EObject ruleJavaCode() throws RecognitionException {
        EObject current = null;

        Token lv_source_0_0=null;


        	enterRule();

        try {
            // InternalXtext.g:1597:2: ( ( (lv_source_0_0= RULE_JAVACODESTRING ) ) )
            // InternalXtext.g:1598:2: ( (lv_source_0_0= RULE_JAVACODESTRING ) )
            {
            // InternalXtext.g:1598:2: ( (lv_source_0_0= RULE_JAVACODESTRING ) )
            // InternalXtext.g:1599:3: (lv_source_0_0= RULE_JAVACODESTRING )
            {
            // InternalXtext.g:1599:3: (lv_source_0_0= RULE_JAVACODESTRING )
            // InternalXtext.g:1600:4: lv_source_0_0= RULE_JAVACODESTRING
            {
            lv_source_0_0=(Token)match(input,RULE_JAVACODESTRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_source_0_0, grammarAccess.getJavaCodeAccess().getSourceJAVACODESTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getJavaCodeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"source",
            					lv_source_0_0,
            					"org.eclipse.xtext.Xtext.JAVACODESTRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaCode"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // InternalXtext.g:1619:1: entryRuleAbstractTokenWithCardinality returns [EObject current=null] : iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF ;
    public final EObject entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTokenWithCardinality = null;


        try {
            // InternalXtext.g:1619:69: (iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF )
            // InternalXtext.g:1620:2: iv_ruleAbstractTokenWithCardinality= ruleAbstractTokenWithCardinality EOF
            {
             newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractTokenWithCardinality=ruleAbstractTokenWithCardinality();

            state._fsp--;

             current =iv_ruleAbstractTokenWithCardinality; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // InternalXtext.g:1626:1: ruleAbstractTokenWithCardinality returns [EObject current=null] : ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) ;
    public final EObject ruleAbstractTokenWithCardinality() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_2_1=null;
        Token lv_cardinality_2_2=null;
        Token lv_cardinality_2_3=null;
        EObject this_Assignment_0 = null;

        EObject this_AbstractTerminal_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:1632:2: ( ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? ) )
            // InternalXtext.g:1633:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            {
            // InternalXtext.g:1633:2: ( (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )? )
            // InternalXtext.g:1634:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal ) ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            {
            // InternalXtext.g:1634:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalXtext.g:1635:4: this_Assignment_0= ruleAssignment
                    {

                    				newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0());
                    			
                    pushFollow(FollowSets000.FOLLOW_35);
                    this_Assignment_0=ruleAssignment();

                    state._fsp--;


                    				current = this_Assignment_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalXtext.g:1644:4: this_AbstractTerminal_1= ruleAbstractTerminal
                    {

                    				newCompositeNode(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_35);
                    this_AbstractTerminal_1=ruleAbstractTerminal();

                    state._fsp--;


                    				current = this_AbstractTerminal_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalXtext.g:1653:3: ( ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==27||(LA38_0>=37 && LA38_0<=38)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXtext.g:1654:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    {
                    // InternalXtext.g:1654:4: ( (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' ) )
                    // InternalXtext.g:1655:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    {
                    // InternalXtext.g:1655:5: (lv_cardinality_2_1= '?' | lv_cardinality_2_2= '*' | lv_cardinality_2_3= '+' )
                    int alt37=3;
                    switch ( input.LA(1) ) {
                    case 37:
                        {
                        alt37=1;
                        }
                        break;
                    case 27:
                        {
                        alt37=2;
                        }
                        break;
                    case 38:
                        {
                        alt37=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }

                    switch (alt37) {
                        case 1 :
                            // InternalXtext.g:1656:6: lv_cardinality_2_1= '?'
                            {
                            lv_cardinality_2_1=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                            						newLeafNode(lv_cardinality_2_1, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            						}
                            						setWithLastConsumed(current, "cardinality", lv_cardinality_2_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalXtext.g:1667:6: lv_cardinality_2_2= '*'
                            {
                            lv_cardinality_2_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            						newLeafNode(lv_cardinality_2_2, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            						}
                            						setWithLastConsumed(current, "cardinality", lv_cardinality_2_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalXtext.g:1678:6: lv_cardinality_2_3= '+'
                            {
                            lv_cardinality_2_3=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                            						newLeafNode(lv_cardinality_2_3, grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getAbstractTokenWithCardinalityRule());
                            						}
                            						setWithLastConsumed(current, "cardinality", lv_cardinality_2_3, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "entryRuleAction"
    // InternalXtext.g:1695:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalXtext.g:1695:47: (iv_ruleAction= ruleAction EOF )
            // InternalXtext.g:1696:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalXtext.g:1702:1: ruleAction returns [EObject current=null] : (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_operator_4_1=null;
        Token lv_operator_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_feature_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1708:2: ( (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' ) )
            // InternalXtext.g:1709:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            {
            // InternalXtext.g:1709:2: (otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}' )
            // InternalXtext.g:1710:3: otherlv_0= '{' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalXtext.g:1714:3: ( (lv_type_1_0= ruleTypeRef ) )
            // InternalXtext.g:1715:4: (lv_type_1_0= ruleTypeRef )
            {
            // InternalXtext.g:1715:4: (lv_type_1_0= ruleTypeRef )
            // InternalXtext.g:1716:5: lv_type_1_0= ruleTypeRef
            {

            					newCompositeNode(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_36);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.eclipse.xtext.Xtext.TypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:1733:3: (otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==21) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXtext.g:1734:4: otherlv_2= '.' ( (lv_feature_3_0= ruleValidID ) ) ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) ) otherlv_5= 'current'
                    {
                    otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getFullStopKeyword_2_0());
                    			
                    // InternalXtext.g:1738:4: ( (lv_feature_3_0= ruleValidID ) )
                    // InternalXtext.g:1739:5: (lv_feature_3_0= ruleValidID )
                    {
                    // InternalXtext.g:1739:5: (lv_feature_3_0= ruleValidID )
                    // InternalXtext.g:1740:6: lv_feature_3_0= ruleValidID
                    {

                    						newCompositeNode(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_37);
                    lv_feature_3_0=ruleValidID();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionRule());
                    						}
                    						set(
                    							current,
                    							"feature",
                    							lv_feature_3_0,
                    							"org.eclipse.xtext.Xtext.ValidID");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtext.g:1757:4: ( ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) ) )
                    // InternalXtext.g:1758:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    {
                    // InternalXtext.g:1758:5: ( (lv_operator_4_1= '=' | lv_operator_4_2= '+=' ) )
                    // InternalXtext.g:1759:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    {
                    // InternalXtext.g:1759:6: (lv_operator_4_1= '=' | lv_operator_4_2= '+=' )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==40) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==41) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalXtext.g:1760:7: lv_operator_4_1= '='
                            {
                            lv_operator_4_1=(Token)match(input,40,FollowSets000.FOLLOW_38); 

                            							newLeafNode(lv_operator_4_1, grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getActionRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_4_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalXtext.g:1771:7: lv_operator_4_2= '+='
                            {
                            lv_operator_4_2=(Token)match(input,41,FollowSets000.FOLLOW_38); 

                            							newLeafNode(lv_operator_4_2, grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getActionRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_4_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_5=(Token)match(input,42,FollowSets000.FOLLOW_39); 

                    				newLeafNode(otherlv_5, grammarAccess.getActionAccess().getCurrentKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,43,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // InternalXtext.g:1797:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // InternalXtext.g:1797:57: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // InternalXtext.g:1798:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             newCompositeNode(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();

            state._fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // InternalXtext.g:1804:1: ruleAbstractTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedElement_2 = null;

        EObject this_PredicatedKeyword_3 = null;

        EObject this_PredicatedRuleCall_4 = null;

        EObject this_PredicatedGroup_5 = null;



        	enterRule();

        try {
            // InternalXtext.g:1810:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup ) )
            // InternalXtext.g:1811:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup )
            {
            // InternalXtext.g:1811:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedElement_2= ruleParenthesizedElement | this_PredicatedKeyword_3= rulePredicatedKeyword | this_PredicatedRuleCall_4= rulePredicatedRuleCall | this_PredicatedGroup_5= rulePredicatedGroup )
            int alt41=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt41=1;
                }
                break;
            case RULE_ID:
            case 44:
            case 45:
                {
                alt41=2;
                }
                break;
            case 16:
                {
                alt41=3;
                }
                break;
            case 47:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                case 44:
                case 45:
                    {
                    alt41=5;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt41=4;
                    }
                    break;
                case 16:
                    {
                    alt41=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 4, input);

                    throw nvae;
                }

                }
                break;
            case 48:
                {
                switch ( input.LA(2) ) {
                case 16:
                    {
                    alt41=6;
                    }
                    break;
                case RULE_ID:
                case 44:
                case 45:
                    {
                    alt41=5;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt41=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalXtext.g:1812:3: this_Keyword_0= ruleKeyword
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:1821:3: this_RuleCall_1= ruleRuleCall
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:1830:3: this_ParenthesizedElement_2= ruleParenthesizedElement
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedElement_2=ruleParenthesizedElement();

                    state._fsp--;


                    			current = this_ParenthesizedElement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtext.g:1839:3: this_PredicatedKeyword_3= rulePredicatedKeyword
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedKeyword_3=rulePredicatedKeyword();

                    state._fsp--;


                    			current = this_PredicatedKeyword_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalXtext.g:1848:3: this_PredicatedRuleCall_4= rulePredicatedRuleCall
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedRuleCall_4=rulePredicatedRuleCall();

                    state._fsp--;


                    			current = this_PredicatedRuleCall_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalXtext.g:1857:3: this_PredicatedGroup_5= rulePredicatedGroup
                    {

                    			newCompositeNode(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PredicatedGroup_5=rulePredicatedGroup();

                    state._fsp--;


                    			current = this_PredicatedGroup_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // InternalXtext.g:1869:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // InternalXtext.g:1869:48: (iv_ruleKeyword= ruleKeyword EOF )
            // InternalXtext.g:1870:2: iv_ruleKeyword= ruleKeyword EOF
            {
             newCompositeNode(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeyword=ruleKeyword();

            state._fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // InternalXtext.g:1876:1: ruleKeyword returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalXtext.g:1882:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalXtext.g:1883:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalXtext.g:1883:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalXtext.g:1884:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalXtext.g:1884:3: (lv_value_0_0= RULE_STRING )
            // InternalXtext.g:1885:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getKeywordRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // InternalXtext.g:1904:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // InternalXtext.g:1904:49: (iv_ruleRuleCall= ruleRuleCall EOF )
            // InternalXtext.g:1905:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             newCompositeNode(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCall=ruleRuleCall();

            state._fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // InternalXtext.g:1911:1: ruleRuleCall returns [EObject current=null] : ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:1917:2: ( ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? ) )
            // InternalXtext.g:1918:2: ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? )
            {
            // InternalXtext.g:1918:2: ( ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )? )
            // InternalXtext.g:1919:3: ( ( ruleRuleID ) ) (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )?
            {
            // InternalXtext.g:1919:3: ( ( ruleRuleID ) )
            // InternalXtext.g:1920:4: ( ruleRuleID )
            {
            // InternalXtext.g:1920:4: ( ruleRuleID )
            // InternalXtext.g:1921:5: ruleRuleID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleCallRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0());
            				
            pushFollow(FollowSets000.FOLLOW_23);
            ruleRuleID();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:1935:3: (otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==31) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXtext.g:1936:4: otherlv_1= '<' ( (lv_arguments_2_0= ruleNamedArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_28); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0());
                    			
                    // InternalXtext.g:1940:4: ( (lv_arguments_2_0= ruleNamedArgument ) )
                    // InternalXtext.g:1941:5: (lv_arguments_2_0= ruleNamedArgument )
                    {
                    // InternalXtext.g:1941:5: (lv_arguments_2_0= ruleNamedArgument )
                    // InternalXtext.g:1942:6: lv_arguments_2_0= ruleNamedArgument
                    {

                    						newCompositeNode(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_arguments_2_0=ruleNamedArgument();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleCallRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_2_0,
                    							"org.eclipse.xtext.Xtext.NamedArgument");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtext.g:1959:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==14) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalXtext.g:1960:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleNamedArgument ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_28); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0());
                    	    				
                    	    // InternalXtext.g:1964:5: ( (lv_arguments_4_0= ruleNamedArgument ) )
                    	    // InternalXtext.g:1965:6: (lv_arguments_4_0= ruleNamedArgument )
                    	    {
                    	    // InternalXtext.g:1965:6: (lv_arguments_4_0= ruleNamedArgument )
                    	    // InternalXtext.g:1966:7: lv_arguments_4_0= ruleNamedArgument
                    	    {

                    	    							newCompositeNode(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_arguments_4_0=ruleNamedArgument();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRuleCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_4_0,
                    	    								"org.eclipse.xtext.Xtext.NamedArgument");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleNamedArgument"
    // InternalXtext.g:1993:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalXtext.g:1993:54: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalXtext.g:1994:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
             newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;

             current =iv_ruleNamedArgument; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // InternalXtext.g:2000:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_calledByName_1_0=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2006:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) ) )
            // InternalXtext.g:2007:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) )
            {
            // InternalXtext.g:2007:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) ) )
            // InternalXtext.g:2008:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )? ( (lv_value_2_0= ruleDisjunction ) )
            {
            // InternalXtext.g:2008:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==40) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalXtext.g:2009:4: ( (otherlv_0= RULE_ID ) ) ( (lv_calledByName_1_0= '=' ) )
                    {
                    // InternalXtext.g:2009:4: ( (otherlv_0= RULE_ID ) )
                    // InternalXtext.g:2010:5: (otherlv_0= RULE_ID )
                    {
                    // InternalXtext.g:2010:5: (otherlv_0= RULE_ID )
                    // InternalXtext.g:2011:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNamedArgumentRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_40); 

                    						newLeafNode(otherlv_0, grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0());
                    					

                    }


                    }

                    // InternalXtext.g:2022:4: ( (lv_calledByName_1_0= '=' ) )
                    // InternalXtext.g:2023:5: (lv_calledByName_1_0= '=' )
                    {
                    // InternalXtext.g:2023:5: (lv_calledByName_1_0= '=' )
                    // InternalXtext.g:2024:6: lv_calledByName_1_0= '='
                    {
                    lv_calledByName_1_0=(Token)match(input,40,FollowSets000.FOLLOW_28); 

                    						newLeafNode(lv_calledByName_1_0, grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNamedArgumentRule());
                    						}
                    						setWithLastConsumed(current, "calledByName", lv_calledByName_1_0 != null, "=");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXtext.g:2037:3: ( (lv_value_2_0= ruleDisjunction ) )
            // InternalXtext.g:2038:4: (lv_value_2_0= ruleDisjunction )
            {
            // InternalXtext.g:2038:4: (lv_value_2_0= ruleDisjunction )
            // InternalXtext.g:2039:5: lv_value_2_0= ruleDisjunction
            {

            					newCompositeNode(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_2_0=ruleDisjunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNamedArgumentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.Xtext.Disjunction");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleLiteralCondition"
    // InternalXtext.g:2060:1: entryRuleLiteralCondition returns [EObject current=null] : iv_ruleLiteralCondition= ruleLiteralCondition EOF ;
    public final EObject entryRuleLiteralCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralCondition = null;


        try {
            // InternalXtext.g:2060:57: (iv_ruleLiteralCondition= ruleLiteralCondition EOF )
            // InternalXtext.g:2061:2: iv_ruleLiteralCondition= ruleLiteralCondition EOF
            {
             newCompositeNode(grammarAccess.getLiteralConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralCondition=ruleLiteralCondition();

            state._fsp--;

             current =iv_ruleLiteralCondition; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralCondition"


    // $ANTLR start "ruleLiteralCondition"
    // InternalXtext.g:2067:1: ruleLiteralCondition returns [EObject current=null] : ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleLiteralCondition() throws RecognitionException {
        EObject current = null;

        Token lv_true_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalXtext.g:2073:2: ( ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalXtext.g:2074:2: ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalXtext.g:2074:2: ( () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalXtext.g:2075:3: () ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalXtext.g:2075:3: ()
            // InternalXtext.g:2076:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0(),
            					current);
            			

            }

            // InternalXtext.g:2082:3: ( ( (lv_true_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==44) ) {
                alt45=1;
            }
            else if ( (LA45_0==45) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalXtext.g:2083:4: ( (lv_true_1_0= 'true' ) )
                    {
                    // InternalXtext.g:2083:4: ( (lv_true_1_0= 'true' ) )
                    // InternalXtext.g:2084:5: (lv_true_1_0= 'true' )
                    {
                    // InternalXtext.g:2084:5: (lv_true_1_0= 'true' )
                    // InternalXtext.g:2085:6: lv_true_1_0= 'true'
                    {
                    lv_true_1_0=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                    						newLeafNode(lv_true_1_0, grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralConditionRule());
                    						}
                    						setWithLastConsumed(current, "true", lv_true_1_0 != null, "true");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2098:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralCondition"


    // $ANTLR start "entryRuleDisjunction"
    // InternalXtext.g:2107:1: entryRuleDisjunction returns [EObject current=null] : iv_ruleDisjunction= ruleDisjunction EOF ;
    public final EObject entryRuleDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjunction = null;


        try {
            // InternalXtext.g:2107:52: (iv_ruleDisjunction= ruleDisjunction EOF )
            // InternalXtext.g:2108:2: iv_ruleDisjunction= ruleDisjunction EOF
            {
             newCompositeNode(grammarAccess.getDisjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDisjunction=ruleDisjunction();

            state._fsp--;

             current =iv_ruleDisjunction; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // InternalXtext.g:2114:1: ruleDisjunction returns [EObject current=null] : (this_Conjunction_0= ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* ) ;
    public final EObject ruleDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Conjunction_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2120:2: ( (this_Conjunction_0= ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* ) )
            // InternalXtext.g:2121:2: (this_Conjunction_0= ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* )
            {
            // InternalXtext.g:2121:2: (this_Conjunction_0= ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )* )
            // InternalXtext.g:2122:3: this_Conjunction_0= ruleConjunction ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )*
            {

            			newCompositeNode(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_27);
            this_Conjunction_0=ruleConjunction();

            state._fsp--;


            			current = this_Conjunction_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:2130:3: ( () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==34) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalXtext.g:2131:4: () otherlv_2= '|' ( (lv_right_3_0= ruleConjunction ) )
            	    {
            	    // InternalXtext.g:2131:4: ()
            	    // InternalXtext.g:2132:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_28); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1());
            	    			
            	    // InternalXtext.g:2142:4: ( (lv_right_3_0= ruleConjunction ) )
            	    // InternalXtext.g:2143:5: (lv_right_3_0= ruleConjunction )
            	    {
            	    // InternalXtext.g:2143:5: (lv_right_3_0= ruleConjunction )
            	    // InternalXtext.g:2144:6: lv_right_3_0= ruleConjunction
            	    {

            	    						newCompositeNode(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_27);
            	    lv_right_3_0=ruleConjunction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDisjunctionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.eclipse.xtext.Xtext.Conjunction");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // InternalXtext.g:2166:1: entryRuleConjunction returns [EObject current=null] : iv_ruleConjunction= ruleConjunction EOF ;
    public final EObject entryRuleConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConjunction = null;


        try {
            // InternalXtext.g:2166:52: (iv_ruleConjunction= ruleConjunction EOF )
            // InternalXtext.g:2167:2: iv_ruleConjunction= ruleConjunction EOF
            {
             newCompositeNode(grammarAccess.getConjunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConjunction=ruleConjunction();

            state._fsp--;

             current =iv_ruleConjunction; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // InternalXtext.g:2173:1: ruleConjunction returns [EObject current=null] : (this_Negation_0= ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* ) ;
    public final EObject ruleConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Negation_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2179:2: ( (this_Negation_0= ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* ) )
            // InternalXtext.g:2180:2: (this_Negation_0= ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* )
            {
            // InternalXtext.g:2180:2: (this_Negation_0= ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )* )
            // InternalXtext.g:2181:3: this_Negation_0= ruleNegation ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )*
            {

            			newCompositeNode(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_32);
            this_Negation_0=ruleNegation();

            state._fsp--;


            			current = this_Negation_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:2189:3: ( () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==35) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalXtext.g:2190:4: () otherlv_2= '&' ( (lv_right_3_0= ruleNegation ) )
            	    {
            	    // InternalXtext.g:2190:4: ()
            	    // InternalXtext.g:2191:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_28); 

            	    				newLeafNode(otherlv_2, grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1());
            	    			
            	    // InternalXtext.g:2201:4: ( (lv_right_3_0= ruleNegation ) )
            	    // InternalXtext.g:2202:5: (lv_right_3_0= ruleNegation )
            	    {
            	    // InternalXtext.g:2202:5: (lv_right_3_0= ruleNegation )
            	    // InternalXtext.g:2203:6: lv_right_3_0= ruleNegation
            	    {

            	    						newCompositeNode(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_right_3_0=ruleNegation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConjunctionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.eclipse.xtext.Xtext.Negation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // InternalXtext.g:2225:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegation = null;


        try {
            // InternalXtext.g:2225:49: (iv_ruleNegation= ruleNegation EOF )
            // InternalXtext.g:2226:2: iv_ruleNegation= ruleNegation EOF
            {
             newCompositeNode(grammarAccess.getNegationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNegation=ruleNegation();

            state._fsp--;

             current =iv_ruleNegation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // InternalXtext.g:2232:1: ruleNegation returns [EObject current=null] : (this_Atom_0= ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Atom_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2238:2: ( (this_Atom_0= ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) ) )
            // InternalXtext.g:2239:2: (this_Atom_0= ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) )
            {
            // InternalXtext.g:2239:2: (this_Atom_0= ruleAtom | ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID||LA48_0==16||(LA48_0>=44 && LA48_0<=45)) ) {
                alt48=1;
            }
            else if ( (LA48_0==46) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalXtext.g:2240:3: this_Atom_0= ruleAtom
                    {

                    			newCompositeNode(grammarAccess.getNegationAccess().getAtomParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Atom_0=ruleAtom();

                    state._fsp--;


                    			current = this_Atom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:2249:3: ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) )
                    {
                    // InternalXtext.g:2249:3: ( () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) ) )
                    // InternalXtext.g:2250:4: () otherlv_2= '!' ( (lv_value_3_0= ruleNegation ) )
                    {
                    // InternalXtext.g:2250:4: ()
                    // InternalXtext.g:2251:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNegationAccess().getNegationAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_28); 

                    				newLeafNode(otherlv_2, grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1());
                    			
                    // InternalXtext.g:2261:4: ( (lv_value_3_0= ruleNegation ) )
                    // InternalXtext.g:2262:5: (lv_value_3_0= ruleNegation )
                    {
                    // InternalXtext.g:2262:5: (lv_value_3_0= ruleNegation )
                    // InternalXtext.g:2263:6: lv_value_3_0= ruleNegation
                    {

                    						newCompositeNode(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_3_0=ruleNegation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNegationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.Xtext.Negation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // InternalXtext.g:2285:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalXtext.g:2285:45: (iv_ruleAtom= ruleAtom EOF )
            // InternalXtext.g:2286:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalXtext.g:2292:1: ruleAtom returns [EObject current=null] : (this_ParameterReference_0= ruleParameterReference | this_ParenthesizedCondition_1= ruleParenthesizedCondition | this_LiteralCondition_2= ruleLiteralCondition ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterReference_0 = null;

        EObject this_ParenthesizedCondition_1 = null;

        EObject this_LiteralCondition_2 = null;



        	enterRule();

        try {
            // InternalXtext.g:2298:2: ( (this_ParameterReference_0= ruleParameterReference | this_ParenthesizedCondition_1= ruleParenthesizedCondition | this_LiteralCondition_2= ruleLiteralCondition ) )
            // InternalXtext.g:2299:2: (this_ParameterReference_0= ruleParameterReference | this_ParenthesizedCondition_1= ruleParenthesizedCondition | this_LiteralCondition_2= ruleLiteralCondition )
            {
            // InternalXtext.g:2299:2: (this_ParameterReference_0= ruleParameterReference | this_ParenthesizedCondition_1= ruleParenthesizedCondition | this_LiteralCondition_2= ruleLiteralCondition )
            int alt49=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt49=1;
                }
                break;
            case 16:
                {
                alt49=2;
                }
                break;
            case 44:
            case 45:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalXtext.g:2300:3: this_ParameterReference_0= ruleParameterReference
                    {

                    			newCompositeNode(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParameterReference_0=ruleParameterReference();

                    state._fsp--;


                    			current = this_ParameterReference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:2309:3: this_ParenthesizedCondition_1= ruleParenthesizedCondition
                    {

                    			newCompositeNode(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedCondition_1=ruleParenthesizedCondition();

                    state._fsp--;


                    			current = this_ParenthesizedCondition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:2318:3: this_LiteralCondition_2= ruleLiteralCondition
                    {

                    			newCompositeNode(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralCondition_2=ruleLiteralCondition();

                    state._fsp--;


                    			current = this_LiteralCondition_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParenthesizedCondition"
    // InternalXtext.g:2330:1: entryRuleParenthesizedCondition returns [EObject current=null] : iv_ruleParenthesizedCondition= ruleParenthesizedCondition EOF ;
    public final EObject entryRuleParenthesizedCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedCondition = null;


        try {
            // InternalXtext.g:2330:63: (iv_ruleParenthesizedCondition= ruleParenthesizedCondition EOF )
            // InternalXtext.g:2331:2: iv_ruleParenthesizedCondition= ruleParenthesizedCondition EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedConditionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedCondition=ruleParenthesizedCondition();

            state._fsp--;

             current =iv_ruleParenthesizedCondition; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedCondition"


    // $ANTLR start "ruleParenthesizedCondition"
    // InternalXtext.g:2337:1: ruleParenthesizedCondition returns [EObject current=null] : (otherlv_0= '(' this_Disjunction_1= ruleDisjunction otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Disjunction_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:2343:2: ( (otherlv_0= '(' this_Disjunction_1= ruleDisjunction otherlv_2= ')' ) )
            // InternalXtext.g:2344:2: (otherlv_0= '(' this_Disjunction_1= ruleDisjunction otherlv_2= ')' )
            {
            // InternalXtext.g:2344:2: (otherlv_0= '(' this_Disjunction_1= ruleDisjunction otherlv_2= ')' )
            // InternalXtext.g:2345:3: otherlv_0= '(' this_Disjunction_1= ruleDisjunction otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_41);
            this_Disjunction_1=ruleDisjunction();

            state._fsp--;


            			current = this_Disjunction_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedCondition"


    // $ANTLR start "entryRuleParameterReference"
    // InternalXtext.g:2365:1: entryRuleParameterReference returns [EObject current=null] : iv_ruleParameterReference= ruleParameterReference EOF ;
    public final EObject entryRuleParameterReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterReference = null;


        try {
            // InternalXtext.g:2365:59: (iv_ruleParameterReference= ruleParameterReference EOF )
            // InternalXtext.g:2366:2: iv_ruleParameterReference= ruleParameterReference EOF
            {
             newCompositeNode(grammarAccess.getParameterReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterReference=ruleParameterReference();

            state._fsp--;

             current =iv_ruleParameterReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterReference"


    // $ANTLR start "ruleParameterReference"
    // InternalXtext.g:2372:1: ruleParameterReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleParameterReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalXtext.g:2378:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalXtext.g:2379:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalXtext.g:2379:2: ( (otherlv_0= RULE_ID ) )
            // InternalXtext.g:2380:3: (otherlv_0= RULE_ID )
            {
            // InternalXtext.g:2380:3: (otherlv_0= RULE_ID )
            // InternalXtext.g:2381:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getParameterReferenceRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterReference"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // InternalXtext.g:2395:1: entryRuleTerminalRuleCall returns [EObject current=null] : iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF ;
    public final EObject entryRuleTerminalRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRuleCall = null;


        try {
            // InternalXtext.g:2395:57: (iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF )
            // InternalXtext.g:2396:2: iv_ruleTerminalRuleCall= ruleTerminalRuleCall EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRuleCall=ruleTerminalRuleCall();

            state._fsp--;

             current =iv_ruleTerminalRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // InternalXtext.g:2402:1: ruleTerminalRuleCall returns [EObject current=null] : ( ( ruleRuleID ) ) ;
    public final EObject ruleTerminalRuleCall() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalXtext.g:2408:2: ( ( ( ruleRuleID ) ) )
            // InternalXtext.g:2409:2: ( ( ruleRuleID ) )
            {
            // InternalXtext.g:2409:2: ( ( ruleRuleID ) )
            // InternalXtext.g:2410:3: ( ruleRuleID )
            {
            // InternalXtext.g:2410:3: ( ruleRuleID )
            // InternalXtext.g:2411:4: ruleRuleID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getTerminalRuleCallRule());
            				}
            			

            				newCompositeNode(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // InternalXtext.g:2428:1: entryRuleRuleID returns [String current=null] : iv_ruleRuleID= ruleRuleID EOF ;
    public final String entryRuleRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRuleID = null;


        try {
            // InternalXtext.g:2428:46: (iv_ruleRuleID= ruleRuleID EOF )
            // InternalXtext.g:2429:2: iv_ruleRuleID= ruleRuleID EOF
            {
             newCompositeNode(grammarAccess.getRuleIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleID=ruleRuleID();

            state._fsp--;

             current =iv_ruleRuleID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // InternalXtext.g:2435:1: ruleRuleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '::' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleRuleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalXtext.g:2441:2: ( (this_ValidID_0= ruleValidID (kw= '::' this_ValidID_2= ruleValidID )* ) )
            // InternalXtext.g:2442:2: (this_ValidID_0= ruleValidID (kw= '::' this_ValidID_2= ruleValidID )* )
            {
            // InternalXtext.g:2442:2: (this_ValidID_0= ruleValidID (kw= '::' this_ValidID_2= ruleValidID )* )
            // InternalXtext.g:2443:3: this_ValidID_0= ruleValidID (kw= '::' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_42);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:2453:3: (kw= '::' this_ValidID_2= ruleValidID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==33) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalXtext.g:2454:4: kw= '::' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,33,FollowSets000.FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_42);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRuleValidID"
    // InternalXtext.g:2474:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalXtext.g:2474:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalXtext.g:2475:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalXtext.g:2481:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalXtext.g:2487:2: ( (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' ) )
            // InternalXtext.g:2488:2: (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' )
            {
            // InternalXtext.g:2488:2: (this_ID_0= RULE_ID | kw= 'true' | kw= 'false' )
            int alt51=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt51=1;
                }
                break;
            case 44:
                {
                alt51=2;
                }
                break;
            case 45:
                {
                alt51=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalXtext.g:2489:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:2497:3: kw= 'true'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getTrueKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:2503:3: kw= 'false'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getFalseKeyword_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // InternalXtext.g:2512:1: entryRulePredicatedKeyword returns [EObject current=null] : iv_rulePredicatedKeyword= rulePredicatedKeyword EOF ;
    public final EObject entryRulePredicatedKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicatedKeyword = null;


        try {
            // InternalXtext.g:2512:58: (iv_rulePredicatedKeyword= rulePredicatedKeyword EOF )
            // InternalXtext.g:2513:2: iv_rulePredicatedKeyword= rulePredicatedKeyword EOF
            {
             newCompositeNode(grammarAccess.getPredicatedKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedKeyword=rulePredicatedKeyword();

            state._fsp--;

             current =iv_rulePredicatedKeyword; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // InternalXtext.g:2519:1: rulePredicatedKeyword returns [EObject current=null] : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePredicatedKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalXtext.g:2525:2: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalXtext.g:2526:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalXtext.g:2526:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalXtext.g:2527:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalXtext.g:2527:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==47) ) {
                alt52=1;
            }
            else if ( (LA52_0==48) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalXtext.g:2528:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // InternalXtext.g:2528:4: ( (lv_predicated_0_0= '=>' ) )
                    // InternalXtext.g:2529:5: (lv_predicated_0_0= '=>' )
                    {
                    // InternalXtext.g:2529:5: (lv_predicated_0_0= '=>' )
                    // InternalXtext.g:2530:6: lv_predicated_0_0= '=>'
                    {
                    lv_predicated_0_0=(Token)match(input,47,FollowSets000.FOLLOW_13); 

                    						newLeafNode(lv_predicated_0_0, grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicatedKeywordRule());
                    						}
                    						setWithLastConsumed(current, "predicated", lv_predicated_0_0 != null, "=>");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2543:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // InternalXtext.g:2543:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // InternalXtext.g:2544:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // InternalXtext.g:2544:5: (lv_firstSetPredicated_1_0= '->' )
                    // InternalXtext.g:2545:6: lv_firstSetPredicated_1_0= '->'
                    {
                    lv_firstSetPredicated_1_0=(Token)match(input,48,FollowSets000.FOLLOW_13); 

                    						newLeafNode(lv_firstSetPredicated_1_0, grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicatedKeywordRule());
                    						}
                    						setWithLastConsumed(current, "firstSetPredicated", lv_firstSetPredicated_1_0 != null, "->");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXtext.g:2558:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalXtext.g:2559:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalXtext.g:2559:4: (lv_value_2_0= RULE_STRING )
            // InternalXtext.g:2560:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPredicatedKeywordRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // InternalXtext.g:2580:1: entryRulePredicatedRuleCall returns [EObject current=null] : iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF ;
    public final EObject entryRulePredicatedRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicatedRuleCall = null;


        try {
            // InternalXtext.g:2580:59: (iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF )
            // InternalXtext.g:2581:2: iv_rulePredicatedRuleCall= rulePredicatedRuleCall EOF
            {
             newCompositeNode(grammarAccess.getPredicatedRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedRuleCall=rulePredicatedRuleCall();

            state._fsp--;

             current =iv_rulePredicatedRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // InternalXtext.g:2587:1: rulePredicatedRuleCall returns [EObject current=null] : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( ( ruleRuleID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? ) ;
    public final EObject rulePredicatedRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_6_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2593:2: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( ( ruleRuleID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? ) )
            // InternalXtext.g:2594:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( ( ruleRuleID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? )
            {
            // InternalXtext.g:2594:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( ( ruleRuleID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )? )
            // InternalXtext.g:2595:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) ( ( ruleRuleID ) ) (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )?
            {
            // InternalXtext.g:2595:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==47) ) {
                alt53=1;
            }
            else if ( (LA53_0==48) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalXtext.g:2596:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // InternalXtext.g:2596:4: ( (lv_predicated_0_0= '=>' ) )
                    // InternalXtext.g:2597:5: (lv_predicated_0_0= '=>' )
                    {
                    // InternalXtext.g:2597:5: (lv_predicated_0_0= '=>' )
                    // InternalXtext.g:2598:6: lv_predicated_0_0= '=>'
                    {
                    lv_predicated_0_0=(Token)match(input,47,FollowSets000.FOLLOW_3); 

                    						newLeafNode(lv_predicated_0_0, grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicatedRuleCallRule());
                    						}
                    						setWithLastConsumed(current, "predicated", lv_predicated_0_0 != null, "=>");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2611:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // InternalXtext.g:2611:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // InternalXtext.g:2612:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // InternalXtext.g:2612:5: (lv_firstSetPredicated_1_0= '->' )
                    // InternalXtext.g:2613:6: lv_firstSetPredicated_1_0= '->'
                    {
                    lv_firstSetPredicated_1_0=(Token)match(input,48,FollowSets000.FOLLOW_3); 

                    						newLeafNode(lv_firstSetPredicated_1_0, grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicatedRuleCallRule());
                    						}
                    						setWithLastConsumed(current, "firstSetPredicated", lv_firstSetPredicated_1_0 != null, "->");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXtext.g:2626:3: ( ( ruleRuleID ) )
            // InternalXtext.g:2627:4: ( ruleRuleID )
            {
            // InternalXtext.g:2627:4: ( ruleRuleID )
            // InternalXtext.g:2628:5: ruleRuleID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPredicatedRuleCallRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_23);
            ruleRuleID();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:2642:3: (otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==31) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalXtext.g:2643:4: otherlv_3= '<' ( (lv_arguments_4_0= ruleNamedArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,31,FollowSets000.FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalXtext.g:2647:4: ( (lv_arguments_4_0= ruleNamedArgument ) )
                    // InternalXtext.g:2648:5: (lv_arguments_4_0= ruleNamedArgument )
                    {
                    // InternalXtext.g:2648:5: (lv_arguments_4_0= ruleNamedArgument )
                    // InternalXtext.g:2649:6: lv_arguments_4_0= ruleNamedArgument
                    {

                    						newCompositeNode(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_arguments_4_0=ruleNamedArgument();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicatedRuleCallRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_4_0,
                    							"org.eclipse.xtext.Xtext.NamedArgument");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalXtext.g:2666:4: (otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==14) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalXtext.g:2667:5: otherlv_5= ',' ( (lv_arguments_6_0= ruleNamedArgument ) )
                    	    {
                    	    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_28); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalXtext.g:2671:5: ( (lv_arguments_6_0= ruleNamedArgument ) )
                    	    // InternalXtext.g:2672:6: (lv_arguments_6_0= ruleNamedArgument )
                    	    {
                    	    // InternalXtext.g:2672:6: (lv_arguments_6_0= ruleNamedArgument )
                    	    // InternalXtext.g:2673:7: lv_arguments_6_0= ruleNamedArgument
                    	    {

                    	    							newCompositeNode(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_arguments_6_0=ruleNamedArgument();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPredicatedRuleCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_6_0,
                    	    								"org.eclipse.xtext.Xtext.NamedArgument");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // InternalXtext.g:2700:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalXtext.g:2700:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalXtext.g:2701:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalXtext.g:2707:1: ruleAssignment returns [EObject current=null] : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token lv_operator_3_1=null;
        Token lv_operator_3_2=null;
        Token lv_operator_3_3=null;
        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_terminal_4_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2713:2: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) ) )
            // InternalXtext.g:2714:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) )
            {
            // InternalXtext.g:2714:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) ) )
            // InternalXtext.g:2715:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )? ( (lv_feature_2_0= ruleValidID ) ) ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) ) ( (lv_terminal_4_0= ruleAssignableTerminal ) )
            {
            // InternalXtext.g:2715:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )?
            int alt56=3;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==47) ) {
                alt56=1;
            }
            else if ( (LA56_0==48) ) {
                alt56=2;
            }
            switch (alt56) {
                case 1 :
                    // InternalXtext.g:2716:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // InternalXtext.g:2716:4: ( (lv_predicated_0_0= '=>' ) )
                    // InternalXtext.g:2717:5: (lv_predicated_0_0= '=>' )
                    {
                    // InternalXtext.g:2717:5: (lv_predicated_0_0= '=>' )
                    // InternalXtext.g:2718:6: lv_predicated_0_0= '=>'
                    {
                    lv_predicated_0_0=(Token)match(input,47,FollowSets000.FOLLOW_3); 

                    						newLeafNode(lv_predicated_0_0, grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "predicated", lv_predicated_0_0 != null, "=>");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:2731:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // InternalXtext.g:2731:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // InternalXtext.g:2732:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // InternalXtext.g:2732:5: (lv_firstSetPredicated_1_0= '->' )
                    // InternalXtext.g:2733:6: lv_firstSetPredicated_1_0= '->'
                    {
                    lv_firstSetPredicated_1_0=(Token)match(input,48,FollowSets000.FOLLOW_3); 

                    						newLeafNode(lv_firstSetPredicated_1_0, grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "firstSetPredicated", lv_firstSetPredicated_1_0 != null, "->");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXtext.g:2746:3: ( (lv_feature_2_0= ruleValidID ) )
            // InternalXtext.g:2747:4: (lv_feature_2_0= ruleValidID )
            {
            // InternalXtext.g:2747:4: (lv_feature_2_0= ruleValidID )
            // InternalXtext.g:2748:5: lv_feature_2_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_43);
            lv_feature_2_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"feature",
            						lv_feature_2_0,
            						"org.eclipse.xtext.Xtext.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:2765:3: ( ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) ) )
            // InternalXtext.g:2766:4: ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) )
            {
            // InternalXtext.g:2766:4: ( (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' ) )
            // InternalXtext.g:2767:5: (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' )
            {
            // InternalXtext.g:2767:5: (lv_operator_3_1= '+=' | lv_operator_3_2= '=' | lv_operator_3_3= '?=' )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt57=1;
                }
                break;
            case 40:
                {
                alt57=2;
                }
                break;
            case 49:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalXtext.g:2768:6: lv_operator_3_1= '+='
                    {
                    lv_operator_3_1=(Token)match(input,41,FollowSets000.FOLLOW_44); 

                    						newLeafNode(lv_operator_3_1, grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalXtext.g:2779:6: lv_operator_3_2= '='
                    {
                    lv_operator_3_2=(Token)match(input,40,FollowSets000.FOLLOW_44); 

                    						newLeafNode(lv_operator_3_2, grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalXtext.g:2790:6: lv_operator_3_3= '?='
                    {
                    lv_operator_3_3=(Token)match(input,49,FollowSets000.FOLLOW_44); 

                    						newLeafNode(lv_operator_3_3, grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_3, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalXtext.g:2803:3: ( (lv_terminal_4_0= ruleAssignableTerminal ) )
            // InternalXtext.g:2804:4: (lv_terminal_4_0= ruleAssignableTerminal )
            {
            // InternalXtext.g:2804:4: (lv_terminal_4_0= ruleAssignableTerminal )
            // InternalXtext.g:2805:5: lv_terminal_4_0= ruleAssignableTerminal
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_4_0=ruleAssignableTerminal();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"terminal",
            						lv_terminal_4_0,
            						"org.eclipse.xtext.Xtext.AssignableTerminal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleAssignableTerminal"
    // InternalXtext.g:2826:1: entryRuleAssignableTerminal returns [EObject current=null] : iv_ruleAssignableTerminal= ruleAssignableTerminal EOF ;
    public final EObject entryRuleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableTerminal = null;


        try {
            // InternalXtext.g:2826:59: (iv_ruleAssignableTerminal= ruleAssignableTerminal EOF )
            // InternalXtext.g:2827:2: iv_ruleAssignableTerminal= ruleAssignableTerminal EOF
            {
             newCompositeNode(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignableTerminal=ruleAssignableTerminal();

            state._fsp--;

             current =iv_ruleAssignableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // InternalXtext.g:2833:1: ruleAssignableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) ;
    public final EObject ruleAssignableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;

        EObject this_ParenthesizedAssignableElement_2 = null;

        EObject this_CrossReference_3 = null;



        	enterRule();

        try {
            // InternalXtext.g:2839:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference ) )
            // InternalXtext.g:2840:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            {
            // InternalXtext.g:2840:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall | this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement | this_CrossReference_3= ruleCrossReference )
            int alt58=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt58=1;
                }
                break;
            case RULE_ID:
            case 44:
            case 45:
                {
                alt58=2;
                }
                break;
            case 16:
                {
                alt58=3;
                }
                break;
            case 50:
                {
                alt58=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalXtext.g:2841:3: this_Keyword_0= ruleKeyword
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:2850:3: this_RuleCall_1= ruleRuleCall
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:2859:3: this_ParenthesizedAssignableElement_2= ruleParenthesizedAssignableElement
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedAssignableElement_2=ruleParenthesizedAssignableElement();

                    state._fsp--;


                    			current = this_ParenthesizedAssignableElement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtext.g:2868:3: this_CrossReference_3= ruleCrossReference
                    {

                    			newCompositeNode(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CrossReference_3=ruleCrossReference();

                    state._fsp--;


                    			current = this_CrossReference_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // InternalXtext.g:2880:1: entryRuleParenthesizedAssignableElement returns [EObject current=null] : iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF ;
    public final EObject entryRuleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedAssignableElement = null;


        try {
            // InternalXtext.g:2880:71: (iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF )
            // InternalXtext.g:2881:2: iv_ruleParenthesizedAssignableElement= ruleParenthesizedAssignableElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedAssignableElement=ruleParenthesizedAssignableElement();

            state._fsp--;

             current =iv_ruleParenthesizedAssignableElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // InternalXtext.g:2887:1: ruleParenthesizedAssignableElement returns [EObject current=null] : (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedAssignableElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AssignableAlternatives_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:2893:2: ( (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' ) )
            // InternalXtext.g:2894:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            {
            // InternalXtext.g:2894:2: (otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')' )
            // InternalXtext.g:2895:3: otherlv_0= '(' this_AssignableAlternatives_1= ruleAssignableAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_44); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_41);
            this_AssignableAlternatives_1=ruleAssignableAlternatives();

            state._fsp--;


            			current = this_AssignableAlternatives_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // InternalXtext.g:2915:1: entryRuleAssignableAlternatives returns [EObject current=null] : iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF ;
    public final EObject entryRuleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignableAlternatives = null;


        try {
            // InternalXtext.g:2915:63: (iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF )
            // InternalXtext.g:2916:2: iv_ruleAssignableAlternatives= ruleAssignableAlternatives EOF
            {
             newCompositeNode(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignableAlternatives=ruleAssignableAlternatives();

            state._fsp--;

             current =iv_ruleAssignableAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // InternalXtext.g:2922:1: ruleAssignableAlternatives returns [EObject current=null] : (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) ;
    public final EObject ruleAssignableAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AssignableTerminal_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2928:2: ( (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? ) )
            // InternalXtext.g:2929:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            {
            // InternalXtext.g:2929:2: (this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )? )
            // InternalXtext.g:2930:3: this_AssignableTerminal_0= ruleAssignableTerminal ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_27);
            this_AssignableTerminal_0=ruleAssignableTerminal();

            state._fsp--;


            			current = this_AssignableTerminal_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:2938:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+ )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==34) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalXtext.g:2939:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    {
                    // InternalXtext.g:2939:4: ()
                    // InternalXtext.g:2940:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:2946:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) ) )+
                    int cnt59=0;
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==34) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalXtext.g:2947:5: otherlv_2= '|' ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_44); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtext.g:2951:5: ( (lv_elements_3_0= ruleAssignableTerminal ) )
                    	    // InternalXtext.g:2952:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    {
                    	    // InternalXtext.g:2952:6: (lv_elements_3_0= ruleAssignableTerminal )
                    	    // InternalXtext.g:2953:7: lv_elements_3_0= ruleAssignableTerminal
                    	    {

                    	    							newCompositeNode(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    lv_elements_3_0=ruleAssignableTerminal();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAssignableAlternativesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.Xtext.AssignableTerminal");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt59 >= 1 ) break loop59;
                                EarlyExitException eee =
                                    new EarlyExitException(59, input);
                                throw eee;
                        }
                        cnt59++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // InternalXtext.g:2976:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // InternalXtext.g:2976:55: (iv_ruleCrossReference= ruleCrossReference EOF )
            // InternalXtext.g:2977:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossReference=ruleCrossReference();

            state._fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // InternalXtext.g:2983:1: ruleCrossReference returns [EObject current=null] : (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_terminal_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:2989:2: ( (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' ) )
            // InternalXtext.g:2990:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            {
            // InternalXtext.g:2990:2: (otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']' )
            // InternalXtext.g:2991:3: otherlv_0= '[' ( (lv_type_1_0= ruleTypeRef ) ) (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalXtext.g:2995:3: ( (lv_type_1_0= ruleTypeRef ) )
            // InternalXtext.g:2996:4: (lv_type_1_0= ruleTypeRef )
            {
            // InternalXtext.g:2996:4: (lv_type_1_0= ruleTypeRef )
            // InternalXtext.g:2997:5: lv_type_1_0= ruleTypeRef
            {

            					newCompositeNode(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_45);
            lv_type_1_0=ruleTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCrossReferenceRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.eclipse.xtext.Xtext.TypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:3014:3: (otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==34) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalXtext.g:3015:4: otherlv_2= '|' ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    {
                    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_46); 

                    				newLeafNode(otherlv_2, grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0());
                    			
                    // InternalXtext.g:3019:4: ( (lv_terminal_3_0= ruleCrossReferenceableTerminal ) )
                    // InternalXtext.g:3020:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    {
                    // InternalXtext.g:3020:5: (lv_terminal_3_0= ruleCrossReferenceableTerminal )
                    // InternalXtext.g:3021:6: lv_terminal_3_0= ruleCrossReferenceableTerminal
                    {

                    						newCompositeNode(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_47);
                    lv_terminal_3_0=ruleCrossReferenceableTerminal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCrossReferenceRule());
                    						}
                    						set(
                    							current,
                    							"terminal",
                    							lv_terminal_3_0,
                    							"org.eclipse.xtext.Xtext.CrossReferenceableTerminal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // InternalXtext.g:3047:1: entryRuleCrossReferenceableTerminal returns [EObject current=null] : iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF ;
    public final EObject entryRuleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReferenceableTerminal = null;


        try {
            // InternalXtext.g:3047:67: (iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF )
            // InternalXtext.g:3048:2: iv_ruleCrossReferenceableTerminal= ruleCrossReferenceableTerminal EOF
            {
             newCompositeNode(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossReferenceableTerminal=ruleCrossReferenceableTerminal();

            state._fsp--;

             current =iv_ruleCrossReferenceableTerminal; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // InternalXtext.g:3054:1: ruleCrossReferenceableTerminal returns [EObject current=null] : (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) ;
    public final EObject ruleCrossReferenceableTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword_0 = null;

        EObject this_RuleCall_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:3060:2: ( (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall ) )
            // InternalXtext.g:3061:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            {
            // InternalXtext.g:3061:2: (this_Keyword_0= ruleKeyword | this_RuleCall_1= ruleRuleCall )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_STRING) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_ID||(LA62_0>=44 && LA62_0<=45)) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalXtext.g:3062:3: this_Keyword_0= ruleKeyword
                    {

                    			newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Keyword_0=ruleKeyword();

                    state._fsp--;


                    			current = this_Keyword_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:3071:3: this_RuleCall_1= ruleRuleCall
                    {

                    			newCompositeNode(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCall_1=ruleRuleCall();

                    state._fsp--;


                    			current = this_RuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // InternalXtext.g:3083:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // InternalXtext.g:3083:61: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // InternalXtext.g:3084:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();

            state._fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // InternalXtext.g:3090:1: ruleParenthesizedElement returns [EObject current=null] : (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Alternatives_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:3096:2: ( (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' ) )
            // InternalXtext.g:3097:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            {
            // InternalXtext.g:3097:2: (otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')' )
            // InternalXtext.g:3098:3: otherlv_0= '(' this_Alternatives_1= ruleAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_41);
            this_Alternatives_1=ruleAlternatives();

            state._fsp--;


            			current = this_Alternatives_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRulePredicatedGroup"
    // InternalXtext.g:3118:1: entryRulePredicatedGroup returns [EObject current=null] : iv_rulePredicatedGroup= rulePredicatedGroup EOF ;
    public final EObject entryRulePredicatedGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicatedGroup = null;


        try {
            // InternalXtext.g:3118:56: (iv_rulePredicatedGroup= rulePredicatedGroup EOF )
            // InternalXtext.g:3119:2: iv_rulePredicatedGroup= rulePredicatedGroup EOF
            {
             newCompositeNode(grammarAccess.getPredicatedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePredicatedGroup=rulePredicatedGroup();

            state._fsp--;

             current =iv_rulePredicatedGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // InternalXtext.g:3125:1: rulePredicatedGroup returns [EObject current=null] : ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' ) ;
    public final EObject rulePredicatedGroup() throws RecognitionException {
        EObject current = null;

        Token lv_predicated_0_0=null;
        Token lv_firstSetPredicated_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3131:2: ( ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' ) )
            // InternalXtext.g:3132:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' )
            {
            // InternalXtext.g:3132:2: ( ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')' )
            // InternalXtext.g:3133:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) ) otherlv_2= '(' ( (lv_elements_3_0= ruleAlternatives ) ) otherlv_4= ')'
            {
            // InternalXtext.g:3133:3: ( ( (lv_predicated_0_0= '=>' ) ) | ( (lv_firstSetPredicated_1_0= '->' ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==47) ) {
                alt63=1;
            }
            else if ( (LA63_0==48) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalXtext.g:3134:4: ( (lv_predicated_0_0= '=>' ) )
                    {
                    // InternalXtext.g:3134:4: ( (lv_predicated_0_0= '=>' ) )
                    // InternalXtext.g:3135:5: (lv_predicated_0_0= '=>' )
                    {
                    // InternalXtext.g:3135:5: (lv_predicated_0_0= '=>' )
                    // InternalXtext.g:3136:6: lv_predicated_0_0= '=>'
                    {
                    lv_predicated_0_0=(Token)match(input,47,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_predicated_0_0, grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicatedGroupRule());
                    						}
                    						setWithLastConsumed(current, "predicated", lv_predicated_0_0 != null, "=>");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:3149:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    {
                    // InternalXtext.g:3149:4: ( (lv_firstSetPredicated_1_0= '->' ) )
                    // InternalXtext.g:3150:5: (lv_firstSetPredicated_1_0= '->' )
                    {
                    // InternalXtext.g:3150:5: (lv_firstSetPredicated_1_0= '->' )
                    // InternalXtext.g:3151:6: lv_firstSetPredicated_1_0= '->'
                    {
                    lv_firstSetPredicated_1_0=(Token)match(input,48,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_firstSetPredicated_1_0, grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicatedGroupRule());
                    						}
                    						setWithLastConsumed(current, "firstSetPredicated", lv_firstSetPredicated_1_0 != null, "->");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1());
            		
            // InternalXtext.g:3168:3: ( (lv_elements_3_0= ruleAlternatives ) )
            // InternalXtext.g:3169:4: (lv_elements_3_0= ruleAlternatives )
            {
            // InternalXtext.g:3169:4: (lv_elements_3_0= ruleAlternatives )
            // InternalXtext.g:3170:5: lv_elements_3_0= ruleAlternatives
            {

            					newCompositeNode(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0());
            				
            pushFollow(FollowSets000.FOLLOW_41);
            lv_elements_3_0=ruleAlternatives();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPredicatedGroupRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_3_0,
            						"org.eclipse.xtext.Xtext.Alternatives");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // InternalXtext.g:3195:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // InternalXtext.g:3195:53: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // InternalXtext.g:3196:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             newCompositeNode(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // InternalXtext.g:3202:1: ruleTerminalRule returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'terminal' ( ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) ) | ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? ) ) otherlv_7= ':' ( (lv_alternatives_8_0= ruleTerminalAlternatives ) ) otherlv_9= ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_fragment_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_type_6_0 = null;

        EObject lv_alternatives_8_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3208:2: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'terminal' ( ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) ) | ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? ) ) otherlv_7= ':' ( (lv_alternatives_8_0= ruleTerminalAlternatives ) ) otherlv_9= ';' ) )
            // InternalXtext.g:3209:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'terminal' ( ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) ) | ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? ) ) otherlv_7= ':' ( (lv_alternatives_8_0= ruleTerminalAlternatives ) ) otherlv_9= ';' )
            {
            // InternalXtext.g:3209:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'terminal' ( ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) ) | ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? ) ) otherlv_7= ':' ( (lv_alternatives_8_0= ruleTerminalAlternatives ) ) otherlv_9= ';' )
            // InternalXtext.g:3210:3: ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'terminal' ( ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) ) | ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? ) ) otherlv_7= ':' ( (lv_alternatives_8_0= ruleTerminalAlternatives ) ) otherlv_9= ';'
            {
            // InternalXtext.g:3210:3: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==25) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalXtext.g:3211:4: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalXtext.g:3211:4: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalXtext.g:3212:5: lv_annotations_0_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_48);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"org.eclipse.xtext.Xtext.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1());
            		
            // InternalXtext.g:3233:3: ( ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) ) | ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==26) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_ID||(LA66_0>=44 && LA66_0<=45)) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalXtext.g:3234:4: ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) )
                    {
                    // InternalXtext.g:3234:4: ( ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) ) )
                    // InternalXtext.g:3235:5: ( (lv_fragment_2_0= 'fragment' ) ) ( (lv_name_3_0= ruleValidID ) )
                    {
                    // InternalXtext.g:3235:5: ( (lv_fragment_2_0= 'fragment' ) )
                    // InternalXtext.g:3236:6: (lv_fragment_2_0= 'fragment' )
                    {
                    // InternalXtext.g:3236:6: (lv_fragment_2_0= 'fragment' )
                    // InternalXtext.g:3237:7: lv_fragment_2_0= 'fragment'
                    {
                    lv_fragment_2_0=(Token)match(input,26,FollowSets000.FOLLOW_3); 

                    							newLeafNode(lv_fragment_2_0, grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTerminalRuleRule());
                    							}
                    							setWithLastConsumed(current, "fragment", lv_fragment_2_0 != null, "fragment");
                    						

                    }


                    }

                    // InternalXtext.g:3249:5: ( (lv_name_3_0= ruleValidID ) )
                    // InternalXtext.g:3250:6: (lv_name_3_0= ruleValidID )
                    {
                    // InternalXtext.g:3250:6: (lv_name_3_0= ruleValidID )
                    // InternalXtext.g:3251:7: lv_name_3_0= ruleValidID
                    {

                    							newCompositeNode(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_name_3_0=ruleValidID();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_3_0,
                    								"org.eclipse.xtext.Xtext.ValidID");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXtext.g:3270:4: ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? )
                    {
                    // InternalXtext.g:3270:4: ( ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )? )
                    // InternalXtext.g:3271:5: ( (lv_name_4_0= ruleValidID ) ) (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )?
                    {
                    // InternalXtext.g:3271:5: ( (lv_name_4_0= ruleValidID ) )
                    // InternalXtext.g:3272:6: (lv_name_4_0= ruleValidID )
                    {
                    // InternalXtext.g:3272:6: (lv_name_4_0= ruleValidID )
                    // InternalXtext.g:3273:7: lv_name_4_0= ruleValidID
                    {

                    							newCompositeNode(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FollowSets000.FOLLOW_50);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_4_0,
                    								"org.eclipse.xtext.Xtext.ValidID");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalXtext.g:3290:5: (otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==28) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // InternalXtext.g:3291:6: otherlv_5= 'returns' ( (lv_type_6_0= ruleTypeRef ) )
                            {
                            otherlv_5=(Token)match(input,28,FollowSets000.FOLLOW_15); 

                            						newLeafNode(otherlv_5, grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0());
                            					
                            // InternalXtext.g:3295:6: ( (lv_type_6_0= ruleTypeRef ) )
                            // InternalXtext.g:3296:7: (lv_type_6_0= ruleTypeRef )
                            {
                            // InternalXtext.g:3296:7: (lv_type_6_0= ruleTypeRef )
                            // InternalXtext.g:3297:8: lv_type_6_0= ruleTypeRef
                            {

                            								newCompositeNode(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0());
                            							
                            pushFollow(FollowSets000.FOLLOW_20);
                            lv_type_6_0=ruleTypeRef();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
                            								}
                            								set(
                            									current,
                            									"type",
                            									lv_type_6_0,
                            									"org.eclipse.xtext.Xtext.TypeRef");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,29,FollowSets000.FOLLOW_51); 

            			newLeafNode(otherlv_7, grammarAccess.getTerminalRuleAccess().getColonKeyword_3());
            		
            // InternalXtext.g:3321:3: ( (lv_alternatives_8_0= ruleTerminalAlternatives ) )
            // InternalXtext.g:3322:4: (lv_alternatives_8_0= ruleTerminalAlternatives )
            {
            // InternalXtext.g:3322:4: (lv_alternatives_8_0= ruleTerminalAlternatives )
            // InternalXtext.g:3323:5: lv_alternatives_8_0= ruleTerminalAlternatives
            {

            					newCompositeNode(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0());
            				
            pushFollow(FollowSets000.FOLLOW_22);
            lv_alternatives_8_0=ruleTerminalAlternatives();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminalRuleRule());
            					}
            					set(
            						current,
            						"alternatives",
            						lv_alternatives_8_0,
            						"org.eclipse.xtext.Xtext.TerminalAlternatives");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // InternalXtext.g:3348:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // InternalXtext.g:3348:61: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // InternalXtext.g:3349:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             newCompositeNode(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();

            state._fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // InternalXtext.g:3355:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_TerminalGroup_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3361:2: ( (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? ) )
            // InternalXtext.g:3362:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            {
            // InternalXtext.g:3362:2: (this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )? )
            // InternalXtext.g:3363:3: this_TerminalGroup_0= ruleTerminalGroup ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_27);
            this_TerminalGroup_0=ruleTerminalGroup();

            state._fsp--;


            			current = this_TerminalGroup_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:3371:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+ )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==34) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalXtext.g:3372:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    {
                    // InternalXtext.g:3372:4: ()
                    // InternalXtext.g:3373:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:3379:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) ) )+
                    int cnt67=0;
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==34) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalXtext.g:3380:5: otherlv_2= '|' ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_51); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtext.g:3384:5: ( (lv_elements_3_0= ruleTerminalGroup ) )
                    	    // InternalXtext.g:3385:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    {
                    	    // InternalXtext.g:3385:6: (lv_elements_3_0= ruleTerminalGroup )
                    	    // InternalXtext.g:3386:7: lv_elements_3_0= ruleTerminalGroup
                    	    {

                    	    							newCompositeNode(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    lv_elements_3_0=ruleTerminalGroup();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTerminalAlternativesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.Xtext.TerminalGroup");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt67 >= 1 ) break loop67;
                                EarlyExitException eee =
                                    new EarlyExitException(67, input);
                                throw eee;
                        }
                        cnt67++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // InternalXtext.g:3409:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // InternalXtext.g:3409:54: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // InternalXtext.g:3410:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             newCompositeNode(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalGroup=ruleTerminalGroup();

            state._fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // InternalXtext.g:3416:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3422:2: ( (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? ) )
            // InternalXtext.g:3423:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            {
            // InternalXtext.g:3423:2: (this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )? )
            // InternalXtext.g:3424:3: this_TerminalToken_0= ruleTerminalToken ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            {

            			newCompositeNode(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_52);
            this_TerminalToken_0=ruleTerminalToken();

            state._fsp--;


            			current = this_TerminalToken_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:3432:3: ( () ( (lv_elements_2_0= ruleTerminalToken ) )+ )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=RULE_STRING && LA70_0<=RULE_ID)||LA70_0==16||LA70_0==21||(LA70_0>=44 && LA70_0<=46)||LA70_0==48||LA70_0==53) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalXtext.g:3433:4: () ( (lv_elements_2_0= ruleTerminalToken ) )+
                    {
                    // InternalXtext.g:3433:4: ()
                    // InternalXtext.g:3434:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:3440:4: ( (lv_elements_2_0= ruleTerminalToken ) )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_ID)||LA69_0==16||LA69_0==21||(LA69_0>=44 && LA69_0<=46)||LA69_0==48||LA69_0==53) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalXtext.g:3441:5: (lv_elements_2_0= ruleTerminalToken )
                    	    {
                    	    // InternalXtext.g:3441:5: (lv_elements_2_0= ruleTerminalToken )
                    	    // InternalXtext.g:3442:6: lv_elements_2_0= ruleTerminalToken
                    	    {

                    	    						newCompositeNode(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_52);
                    	    lv_elements_2_0=ruleTerminalToken();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTerminalGroupRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_2_0,
                    	    							"org.eclipse.xtext.Xtext.TerminalToken");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt69 >= 1 ) break loop69;
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // InternalXtext.g:3464:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // InternalXtext.g:3464:54: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // InternalXtext.g:3465:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalToken=ruleTerminalToken();

            state._fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // InternalXtext.g:3471:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality_1_1=null;
        Token lv_cardinality_1_2=null;
        Token lv_cardinality_1_3=null;
        EObject this_TerminalTokenElement_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3477:2: ( (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? ) )
            // InternalXtext.g:3478:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            {
            // InternalXtext.g:3478:2: (this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )? )
            // InternalXtext.g:3479:3: this_TerminalTokenElement_0= ruleTerminalTokenElement ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            {

            			newCompositeNode(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_35);
            this_TerminalTokenElement_0=ruleTerminalTokenElement();

            state._fsp--;


            			current = this_TerminalTokenElement_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:3487:3: ( ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==27||(LA72_0>=37 && LA72_0<=38)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalXtext.g:3488:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    {
                    // InternalXtext.g:3488:4: ( (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' ) )
                    // InternalXtext.g:3489:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    {
                    // InternalXtext.g:3489:5: (lv_cardinality_1_1= '?' | lv_cardinality_1_2= '*' | lv_cardinality_1_3= '+' )
                    int alt71=3;
                    switch ( input.LA(1) ) {
                    case 37:
                        {
                        alt71=1;
                        }
                        break;
                    case 27:
                        {
                        alt71=2;
                        }
                        break;
                    case 38:
                        {
                        alt71=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }

                    switch (alt71) {
                        case 1 :
                            // InternalXtext.g:3490:6: lv_cardinality_1_1= '?'
                            {
                            lv_cardinality_1_1=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                            						newLeafNode(lv_cardinality_1_1, grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTerminalTokenRule());
                            						}
                            						setWithLastConsumed(current, "cardinality", lv_cardinality_1_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalXtext.g:3501:6: lv_cardinality_1_2= '*'
                            {
                            lv_cardinality_1_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            						newLeafNode(lv_cardinality_1_2, grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTerminalTokenRule());
                            						}
                            						setWithLastConsumed(current, "cardinality", lv_cardinality_1_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalXtext.g:3512:6: lv_cardinality_1_3= '+'
                            {
                            lv_cardinality_1_3=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                            						newLeafNode(lv_cardinality_1_3, grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTerminalTokenRule());
                            						}
                            						setWithLastConsumed(current, "cardinality", lv_cardinality_1_3, null);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // InternalXtext.g:3529:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // InternalXtext.g:3529:61: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // InternalXtext.g:3530:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             newCompositeNode(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();

            state._fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // InternalXtext.g:3536:1: ruleTerminalTokenElement returns [EObject current=null] : (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange_0 = null;

        EObject this_TerminalRuleCall_1 = null;

        EObject this_ParenthesizedTerminalElement_2 = null;

        EObject this_AbstractNegatedToken_3 = null;

        EObject this_Wildcard_4 = null;

        EObject this_EOF_5 = null;



        	enterRule();

        try {
            // InternalXtext.g:3542:2: ( (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF ) )
            // InternalXtext.g:3543:2: (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF )
            {
            // InternalXtext.g:3543:2: (this_CharacterRange_0= ruleCharacterRange | this_TerminalRuleCall_1= ruleTerminalRuleCall | this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement | this_AbstractNegatedToken_3= ruleAbstractNegatedToken | this_Wildcard_4= ruleWildcard | this_EOF_5= ruleEOF )
            int alt73=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt73=1;
                }
                break;
            case RULE_ID:
            case 44:
            case 45:
                {
                alt73=2;
                }
                break;
            case 16:
                {
                alt73=3;
                }
                break;
            case 46:
            case 48:
                {
                alt73=4;
                }
                break;
            case 21:
                {
                alt73=5;
                }
                break;
            case 53:
                {
                alt73=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalXtext.g:3544:3: this_CharacterRange_0= ruleCharacterRange
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CharacterRange_0=ruleCharacterRange();

                    state._fsp--;


                    			current = this_CharacterRange_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:3553:3: this_TerminalRuleCall_1= ruleTerminalRuleCall
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TerminalRuleCall_1=ruleTerminalRuleCall();

                    state._fsp--;


                    			current = this_TerminalRuleCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXtext.g:3562:3: this_ParenthesizedTerminalElement_2= ruleParenthesizedTerminalElement
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedTerminalElement_2=ruleParenthesizedTerminalElement();

                    state._fsp--;


                    			current = this_ParenthesizedTerminalElement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXtext.g:3571:3: this_AbstractNegatedToken_3= ruleAbstractNegatedToken
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AbstractNegatedToken_3=ruleAbstractNegatedToken();

                    state._fsp--;


                    			current = this_AbstractNegatedToken_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalXtext.g:3580:3: this_Wildcard_4= ruleWildcard
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Wildcard_4=ruleWildcard();

                    state._fsp--;


                    			current = this_Wildcard_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalXtext.g:3589:3: this_EOF_5= ruleEOF
                    {

                    			newCompositeNode(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EOF_5=ruleEOF();

                    state._fsp--;


                    			current = this_EOF_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // InternalXtext.g:3601:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // InternalXtext.g:3601:69: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // InternalXtext.g:3602:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();

            state._fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // InternalXtext.g:3608:1: ruleParenthesizedTerminalElement returns [EObject current=null] : (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TerminalAlternatives_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:3614:2: ( (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' ) )
            // InternalXtext.g:3615:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            {
            // InternalXtext.g:3615:2: (otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')' )
            // InternalXtext.g:3616:3: otherlv_0= '(' this_TerminalAlternatives_1= ruleTerminalAlternatives otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_41);
            this_TerminalAlternatives_1=ruleTerminalAlternatives();

            state._fsp--;


            			current = this_TerminalAlternatives_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // InternalXtext.g:3636:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // InternalXtext.g:3636:61: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // InternalXtext.g:3637:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();

            state._fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // InternalXtext.g:3643:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken_0 = null;

        EObject this_UntilToken_1 = null;



        	enterRule();

        try {
            // InternalXtext.g:3649:2: ( (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken ) )
            // InternalXtext.g:3650:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            {
            // InternalXtext.g:3650:2: (this_NegatedToken_0= ruleNegatedToken | this_UntilToken_1= ruleUntilToken )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==46) ) {
                alt74=1;
            }
            else if ( (LA74_0==48) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalXtext.g:3651:3: this_NegatedToken_0= ruleNegatedToken
                    {

                    			newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NegatedToken_0=ruleNegatedToken();

                    state._fsp--;


                    			current = this_NegatedToken_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXtext.g:3660:3: this_UntilToken_1= ruleUntilToken
                    {

                    			newCompositeNode(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UntilToken_1=ruleUntilToken();

                    state._fsp--;


                    			current = this_UntilToken_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // InternalXtext.g:3672:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // InternalXtext.g:3672:53: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // InternalXtext.g:3673:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             newCompositeNode(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNegatedToken=ruleNegatedToken();

            state._fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // InternalXtext.g:3679:1: ruleNegatedToken returns [EObject current=null] : (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3685:2: ( (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // InternalXtext.g:3686:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // InternalXtext.g:3686:2: (otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // InternalXtext.g:3687:3: otherlv_0= '!' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0());
            		
            // InternalXtext.g:3691:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // InternalXtext.g:3692:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // InternalXtext.g:3692:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // InternalXtext.g:3693:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					newCompositeNode(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNegatedTokenRule());
            					}
            					set(
            						current,
            						"terminal",
            						lv_terminal_1_0,
            						"org.eclipse.xtext.Xtext.TerminalTokenElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // InternalXtext.g:3714:1: entryRuleUntilToken returns [EObject current=null] : iv_ruleUntilToken= ruleUntilToken EOF ;
    public final EObject entryRuleUntilToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilToken = null;


        try {
            // InternalXtext.g:3714:51: (iv_ruleUntilToken= ruleUntilToken EOF )
            // InternalXtext.g:3715:2: iv_ruleUntilToken= ruleUntilToken EOF
            {
             newCompositeNode(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUntilToken=ruleUntilToken();

            state._fsp--;

             current =iv_ruleUntilToken; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // InternalXtext.g:3721:1: ruleUntilToken returns [EObject current=null] : (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) ;
    public final EObject ruleUntilToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_terminal_1_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3727:2: ( (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) ) )
            // InternalXtext.g:3728:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            {
            // InternalXtext.g:3728:2: (otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) ) )
            // InternalXtext.g:3729:3: otherlv_0= '->' ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0());
            		
            // InternalXtext.g:3733:3: ( (lv_terminal_1_0= ruleTerminalTokenElement ) )
            // InternalXtext.g:3734:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            {
            // InternalXtext.g:3734:4: (lv_terminal_1_0= ruleTerminalTokenElement )
            // InternalXtext.g:3735:5: lv_terminal_1_0= ruleTerminalTokenElement
            {

            					newCompositeNode(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_terminal_1_0=ruleTerminalTokenElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUntilTokenRule());
            					}
            					set(
            						current,
            						"terminal",
            						lv_terminal_1_0,
            						"org.eclipse.xtext.Xtext.TerminalTokenElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // InternalXtext.g:3756:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // InternalXtext.g:3756:49: (iv_ruleWildcard= ruleWildcard EOF )
            // InternalXtext.g:3757:2: iv_ruleWildcard= ruleWildcard EOF
            {
             newCompositeNode(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWildcard=ruleWildcard();

            state._fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // InternalXtext.g:3763:1: ruleWildcard returns [EObject current=null] : ( () otherlv_1= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalXtext.g:3769:2: ( ( () otherlv_1= '.' ) )
            // InternalXtext.g:3770:2: ( () otherlv_1= '.' )
            {
            // InternalXtext.g:3770:2: ( () otherlv_1= '.' )
            // InternalXtext.g:3771:3: () otherlv_1= '.'
            {
            // InternalXtext.g:3771:3: ()
            // InternalXtext.g:3772:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getWildcardAccess().getWildcardAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getWildcardAccess().getFullStopKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleEOF"
    // InternalXtext.g:3786:1: entryRuleEOF returns [EObject current=null] : iv_ruleEOF= ruleEOF EOF ;
    public final EObject entryRuleEOF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEOF = null;


        try {
            // InternalXtext.g:3786:44: (iv_ruleEOF= ruleEOF EOF )
            // InternalXtext.g:3787:2: iv_ruleEOF= ruleEOF EOF
            {
             newCompositeNode(grammarAccess.getEOFRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEOF=ruleEOF();

            state._fsp--;

             current =iv_ruleEOF; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // InternalXtext.g:3793:1: ruleEOF returns [EObject current=null] : ( () otherlv_1= 'EOF' ) ;
    public final EObject ruleEOF() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalXtext.g:3799:2: ( ( () otherlv_1= 'EOF' ) )
            // InternalXtext.g:3800:2: ( () otherlv_1= 'EOF' )
            {
            // InternalXtext.g:3800:2: ( () otherlv_1= 'EOF' )
            // InternalXtext.g:3801:3: () otherlv_1= 'EOF'
            {
            // InternalXtext.g:3801:3: ()
            // InternalXtext.g:3802:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEOFAccess().getEOFAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,53,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEOFAccess().getEOFKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // InternalXtext.g:3816:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // InternalXtext.g:3816:55: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // InternalXtext.g:3817:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             newCompositeNode(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCharacterRange=ruleCharacterRange();

            state._fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // InternalXtext.g:3823:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Keyword_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3829:2: ( (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? ) )
            // InternalXtext.g:3830:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            {
            // InternalXtext.g:3830:2: (this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )? )
            // InternalXtext.g:3831:3: this_Keyword_0= ruleKeyword ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            {

            			newCompositeNode(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_53);
            this_Keyword_0=ruleKeyword();

            state._fsp--;


            			current = this_Keyword_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:3839:3: ( () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==54) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalXtext.g:3840:4: () otherlv_2= '..' ( (lv_right_3_0= ruleKeyword ) )
                    {
                    // InternalXtext.g:3840:4: ()
                    // InternalXtext.g:3841:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_13); 

                    				newLeafNode(otherlv_2, grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1());
                    			
                    // InternalXtext.g:3851:4: ( (lv_right_3_0= ruleKeyword ) )
                    // InternalXtext.g:3852:5: (lv_right_3_0= ruleKeyword )
                    {
                    // InternalXtext.g:3852:5: (lv_right_3_0= ruleKeyword )
                    // InternalXtext.g:3853:6: lv_right_3_0= ruleKeyword
                    {

                    						newCompositeNode(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=ruleKeyword();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCharacterRangeRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_3_0,
                    							"org.eclipse.xtext.Xtext.Keyword");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // InternalXtext.g:3875:1: entryRuleEnumRule returns [EObject current=null] : iv_ruleEnumRule= ruleEnumRule EOF ;
    public final EObject entryRuleEnumRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumRule = null;


        try {
            // InternalXtext.g:3875:49: (iv_ruleEnumRule= ruleEnumRule EOF )
            // InternalXtext.g:3876:2: iv_ruleEnumRule= ruleEnumRule EOF
            {
             newCompositeNode(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumRule=ruleEnumRule();

            state._fsp--;

             current =iv_ruleEnumRule; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // InternalXtext.g:3882:1: ruleEnumRule returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'enum' ( (lv_name_2_0= ruleValidID ) ) (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? otherlv_5= ':' ( (lv_alternatives_6_0= ruleEnumLiterals ) ) otherlv_7= ';' ) ;
    public final EObject ruleEnumRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_alternatives_6_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:3888:2: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'enum' ( (lv_name_2_0= ruleValidID ) ) (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? otherlv_5= ':' ( (lv_alternatives_6_0= ruleEnumLiterals ) ) otherlv_7= ';' ) )
            // InternalXtext.g:3889:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'enum' ( (lv_name_2_0= ruleValidID ) ) (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? otherlv_5= ':' ( (lv_alternatives_6_0= ruleEnumLiterals ) ) otherlv_7= ';' )
            {
            // InternalXtext.g:3889:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'enum' ( (lv_name_2_0= ruleValidID ) ) (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? otherlv_5= ':' ( (lv_alternatives_6_0= ruleEnumLiterals ) ) otherlv_7= ';' )
            // InternalXtext.g:3890:3: ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'enum' ( (lv_name_2_0= ruleValidID ) ) (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )? otherlv_5= ':' ( (lv_alternatives_6_0= ruleEnumLiterals ) ) otherlv_7= ';'
            {
            // InternalXtext.g:3890:3: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==25) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalXtext.g:3891:4: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalXtext.g:3891:4: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalXtext.g:3892:5: lv_annotations_0_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_54);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEnumRuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"org.eclipse.xtext.Xtext.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumRuleAccess().getEnumKeyword_1());
            		
            // InternalXtext.g:3913:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalXtext.g:3914:4: (lv_name_2_0= ruleValidID )
            {
            // InternalXtext.g:3914:4: (lv_name_2_0= ruleValidID )
            // InternalXtext.g:3915:5: lv_name_2_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0());
            				
            pushFollow(FollowSets000.FOLLOW_50);
            lv_name_2_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.Xtext.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXtext.g:3932:3: (otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalXtext.g:3933:4: otherlv_3= 'returns' ( (lv_type_4_0= ruleTypeRef ) )
                    {
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_15); 

                    				newLeafNode(otherlv_3, grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0());
                    			
                    // InternalXtext.g:3937:4: ( (lv_type_4_0= ruleTypeRef ) )
                    // InternalXtext.g:3938:5: (lv_type_4_0= ruleTypeRef )
                    {
                    // InternalXtext.g:3938:5: (lv_type_4_0= ruleTypeRef )
                    // InternalXtext.g:3939:6: lv_type_4_0= ruleTypeRef
                    {

                    						newCompositeNode(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_type_4_0=ruleTypeRef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEnumRuleRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_4_0,
                    							"org.eclipse.xtext.Xtext.TypeRef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getEnumRuleAccess().getColonKeyword_4());
            		
            // InternalXtext.g:3961:3: ( (lv_alternatives_6_0= ruleEnumLiterals ) )
            // InternalXtext.g:3962:4: (lv_alternatives_6_0= ruleEnumLiterals )
            {
            // InternalXtext.g:3962:4: (lv_alternatives_6_0= ruleEnumLiterals )
            // InternalXtext.g:3963:5: lv_alternatives_6_0= ruleEnumLiterals
            {

            					newCompositeNode(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0());
            				
            pushFollow(FollowSets000.FOLLOW_22);
            lv_alternatives_6_0=ruleEnumLiterals();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumRuleRule());
            					}
            					set(
            						current,
            						"alternatives",
            						lv_alternatives_6_0,
            						"org.eclipse.xtext.Xtext.EnumLiterals");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // InternalXtext.g:3988:1: entryRuleEnumLiterals returns [EObject current=null] : iv_ruleEnumLiterals= ruleEnumLiterals EOF ;
    public final EObject entryRuleEnumLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiterals = null;


        try {
            // InternalXtext.g:3988:53: (iv_ruleEnumLiterals= ruleEnumLiterals EOF )
            // InternalXtext.g:3989:2: iv_ruleEnumLiterals= ruleEnumLiterals EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiterals=ruleEnumLiterals();

            state._fsp--;

             current =iv_ruleEnumLiterals; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // InternalXtext.g:3995:1: ruleEnumLiterals returns [EObject current=null] : (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) ;
    public final EObject ruleEnumLiterals() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EnumLiteralDeclaration_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:4001:2: ( (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? ) )
            // InternalXtext.g:4002:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            {
            // InternalXtext.g:4002:2: (this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )? )
            // InternalXtext.g:4003:3: this_EnumLiteralDeclaration_0= ruleEnumLiteralDeclaration ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_27);
            this_EnumLiteralDeclaration_0=ruleEnumLiteralDeclaration();

            state._fsp--;


            			current = this_EnumLiteralDeclaration_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalXtext.g:4011:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+ )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==34) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalXtext.g:4012:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    {
                    // InternalXtext.g:4012:4: ()
                    // InternalXtext.g:4013:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalXtext.g:4019:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) ) )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==34) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalXtext.g:4020:5: otherlv_2= '|' ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_15); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalXtext.g:4024:5: ( (lv_elements_3_0= ruleEnumLiteralDeclaration ) )
                    	    // InternalXtext.g:4025:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    {
                    	    // InternalXtext.g:4025:6: (lv_elements_3_0= ruleEnumLiteralDeclaration )
                    	    // InternalXtext.g:4026:7: lv_elements_3_0= ruleEnumLiteralDeclaration
                    	    {

                    	    							newCompositeNode(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    lv_elements_3_0=ruleEnumLiteralDeclaration();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEnumLiteralsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"org.eclipse.xtext.Xtext.EnumLiteralDeclaration");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt78 >= 1 ) break loop78;
                                EarlyExitException eee =
                                    new EarlyExitException(78, input);
                                throw eee;
                        }
                        cnt78++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // InternalXtext.g:4049:1: entryRuleEnumLiteralDeclaration returns [EObject current=null] : iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF ;
    public final EObject entryRuleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteralDeclaration = null;


        try {
            // InternalXtext.g:4049:63: (iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF )
            // InternalXtext.g:4050:2: iv_ruleEnumLiteralDeclaration= ruleEnumLiteralDeclaration EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiteralDeclaration=ruleEnumLiteralDeclaration();

            state._fsp--;

             current =iv_ruleEnumLiteralDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // InternalXtext.g:4056:1: ruleEnumLiteralDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) ;
    public final EObject ruleEnumLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_literal_2_0 = null;



        	enterRule();

        try {
            // InternalXtext.g:4062:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? ) )
            // InternalXtext.g:4063:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            {
            // InternalXtext.g:4063:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )? )
            // InternalXtext.g:4064:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            {
            // InternalXtext.g:4064:3: ( (otherlv_0= RULE_ID ) )
            // InternalXtext.g:4065:4: (otherlv_0= RULE_ID )
            {
            // InternalXtext.g:4065:4: (otherlv_0= RULE_ID )
            // InternalXtext.g:4066:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumLiteralDeclarationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_55); 

            					newLeafNode(otherlv_0, grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0());
            				

            }


            }

            // InternalXtext.g:4077:3: (otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==40) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalXtext.g:4078:4: otherlv_1= '=' ( (lv_literal_2_0= ruleKeyword ) )
                    {
                    otherlv_1=(Token)match(input,40,FollowSets000.FOLLOW_13); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0());
                    			
                    // InternalXtext.g:4082:4: ( (lv_literal_2_0= ruleKeyword ) )
                    // InternalXtext.g:4083:5: (lv_literal_2_0= ruleKeyword )
                    {
                    // InternalXtext.g:4083:5: (lv_literal_2_0= ruleKeyword )
                    // InternalXtext.g:4084:6: lv_literal_2_0= ruleKeyword
                    {

                    						newCompositeNode(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_literal_2_0=ruleKeyword();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEnumLiteralDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"literal",
                    							lv_literal_2_0,
                    							"org.eclipse.xtext.Xtext.Keyword");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteralDeclaration"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\2\6\3\uffff\1\6";
    static final String dfa_3s = "\1\67\1\6\3\uffff\1\67";
    static final String dfa_4s = "\2\uffff\1\1\1\2\1\3\1\uffff";
    static final String dfa_5s = "\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\22\uffff\1\1\1\2\21\uffff\2\2\6\uffff\1\3\2\uffff\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\2\22\uffff\1\1\1\2\21\uffff\2\2\6\uffff\1\3\2\uffff\1\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "452:2: (this_ParserRule_0= ruleParserRule | this_TerminalRule_1= ruleTerminalRule | this_EnumRule_2= ruleEnumRule )";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\3\uffff\3\6\1\uffff\3\6\1\uffff";
    static final String dfa_9s = "\6\5\1\uffff\3\5\1\uffff";
    static final String dfa_10s = "\1\60\2\55\3\61\1\uffff\3\61\1\uffff";
    static final String dfa_11s = "\6\uffff\1\2\3\uffff\1\1";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\6\1\3\11\uffff\1\6\33\uffff\1\4\1\5\1\uffff\1\1\1\2",
            "\1\6\1\7\11\uffff\1\6\33\uffff\1\10\1\11",
            "\1\6\1\7\11\uffff\1\6\33\uffff\1\10\1\11",
            "\3\6\10\uffff\2\6\11\uffff\1\6\2\uffff\2\6\1\uffff\3\6\1\uffff\3\6\2\12\2\uffff\2\6\1\uffff\2\6\1\12",
            "\3\6\10\uffff\2\6\11\uffff\1\6\2\uffff\2\6\1\uffff\3\6\1\uffff\3\6\2\12\2\uffff\2\6\1\uffff\2\6\1\12",
            "\3\6\10\uffff\2\6\11\uffff\1\6\2\uffff\2\6\1\uffff\3\6\1\uffff\3\6\2\12\2\uffff\2\6\1\uffff\2\6\1\12",
            "",
            "\3\6\10\uffff\2\6\11\uffff\1\6\2\uffff\2\6\1\uffff\3\6\1\uffff\3\6\2\12\2\uffff\2\6\1\uffff\2\6\1\12",
            "\3\6\10\uffff\2\6\11\uffff\1\6\2\uffff\2\6\1\uffff\3\6\1\uffff\3\6\2\12\2\uffff\2\6\1\uffff\2\6\1\12",
            "\3\6\10\uffff\2\6\11\uffff\1\6\2\uffff\2\6\1\uffff\3\6\1\uffff\3\6\2\12\2\uffff\2\6\1\uffff\2\6\1\12",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1634:3: (this_Assignment_0= ruleAssignment | this_AbstractTerminal_1= ruleAbstractTerminal )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000300000000040L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00903000075CA040L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00903000075CE040L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000300000020040L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000024000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00903000075CA042L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000300006000040L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000038008000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020008000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000030008000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0001B080800100E0L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000040L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100004000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000700000010040L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001B080000100E0L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001B080000100E2L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000006008000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080000200000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000030000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0002030000000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0004300000010060L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0008000400000000L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000300000000060L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010000002000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000300004000040L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0021700000210060L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0021700000210062L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0080000002000000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000010000000002L});
    }


}