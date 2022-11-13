package com.springcsvfile.csvfile.model;

import javax.persistence.*;


import java.lang.annotation.Documented;

@Entity
public class Tutorial {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long referenceDate;
    private String annotator;
    @Column(unique=true)
    private String index;
    private String action;
    private String internalIndex;
    private int coOccurringRuleID;
    private String bioMarkerType;
    private String variantOrRule;
    private String sequenceOrStructural;
    
    private String transcriptID;
	public long getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(long referenceDate) {
		this.referenceDate = referenceDate;
	}
	public String getAnnotator() {
		return annotator;
	}
	public void setAnnotator(String annotator) {
		this.annotator = annotator;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInternalIndex() {
		return internalIndex;
	}
	public void setInternalIndex(String internalIndex) {
		this.internalIndex = internalIndex;
	}
	public int getCoOccurringRuleID() {
		return coOccurringRuleID;
	}
	public void setCoOccurringRuleID(int coOccurringRuleID) {
		this.coOccurringRuleID = coOccurringRuleID;
	}
	public String getBioMarkerType() {
		return bioMarkerType;
	}
	public void setBioMarkerType(String bioMarkerType) {
		this.bioMarkerType = bioMarkerType;
	}
	public String getVariantOrRule() {
		return variantOrRule;
	}
	public void setVariantOrRule(String variantOrRule) {
		this.variantOrRule = variantOrRule;
	}
	public String getSequenceOrStructural() {
		return sequenceOrStructural;
	}
	public void setSequenceOrStructural(String sequenceOrStructural) {
		this.sequenceOrStructural = sequenceOrStructural;
	}
	public String getTranscriptID() {
		return transcriptID;
	}
	public void setTranscriptID(String transcriptID) {
		this.transcriptID = transcriptID;
	}
	public Tutorial(long referenceDate, String annotator, String index, String action, String internalIndex,
			int coOccurringRuleID, String bioMarkerType, String variantOrRule, String sequenceOrStructural,
			String transcriptID) {
		super();
		this.referenceDate = referenceDate;
		this.annotator = annotator;
		this.index = index;
		this.action = action;
		this.internalIndex = internalIndex;
		this.coOccurringRuleID = coOccurringRuleID;
		this.bioMarkerType = bioMarkerType;
		this.variantOrRule = variantOrRule;
		this.sequenceOrStructural = sequenceOrStructural;
		this.transcriptID = transcriptID;
	}
	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tutorial [referenceDate=" + referenceDate + ", annotator=" + annotator + ", index=" + index
				+ ", action=" + action + ", internalIndex=" + internalIndex + ", coOccurringRuleID=" + coOccurringRuleID
				+ ", bioMarkerType=" + bioMarkerType + ", variantOrRule=" + variantOrRule + ", sequenceOrStructural="
				+ sequenceOrStructural + ", transcriptID=" + transcriptID + "]";
	}

    
}