package org.jinghouyu.office.word.object.lcb;

import java.io.IOException;
import java.io.InputStream;

import org.jinghouyu.office.basic.compound.utils.IOUtils;
import org.jinghouyu.office.basic.compound.utils.littleendian.LeInteger;

public class Lcb97 {

	private long fcStshfOrig;
	private long lcbStshfOrig;
	private long fcStshf;
	private long lcbStshf;
	private long fcPlcffndRef;
	private long lcbPlcffndRef;
	private long fcPlcffndTxt;
	private long lcbPlcffndTxt;
	private long fcPlcfandRef;
	private long lcbPlcfandRef;
	private long fcPlcfandTxt;
	private long lcbPlcfandTxt;
	private long fcPlcfSed;
	private long lcbPlcfSed;
	private long fcPlcPad;
	private long lcbPlcPad;
	private long fcPlcfPhe;
	private long lcbPlcfPhe;
	private long fcSttbfGlsy;
	private long lcbSttbfGlsy;
	private long fcPlcfGlsy;
	private long lcbPlcfGlsy;
	private long fcPlcfHdd;
	private long lcbPlcfHdd;
	private long fcPlcfBteChpx;
	private long lcbPlcfBteChpx;
	private long fcPlcfBtePapx;
	private long lcbPlcfBtePapx;
	private long fcPlcfSea;
	private long lcbPlcfSea;
	private long fcSttbfFfn;
	private long lcbSttbfFfn;
	private long fcPlcfFldMom;
	private long lcbPlcfFldMom;
	private long fcPlcfFldHdr;
	private long lcbPlcfFldHdr;
	private long fcPlcfFldFtn;
	private long lcbPlcfFldFtn;
	private long fcPlcfFldAtn;
	private long lcbPlcfFldAtn;
	private long fcPlcfFldMcr;
	private long lcbPlcfFldMcr;
	private long fcSttbfBkmk;
	private long lcbSttbfBkmk;
	private long fcPlcfBkf;
	private long lcbPlcfBkf;
	private long fcPlcfBkl;
	private long lcbPlcfBkl;
	private long fcCmds;
	private long lcbCmds;
	private long fcUnused1;
	private long lcbUnused1;
	private long fcSttbfMcr;
	private long lcbSttbfMcr;
	private long fcPrDrvr;
	private long lcbPrDrvr;
	private long fcPrEnvPort;
	private long lcbPrEnvPort;
	private long fcPrEnvLand;
	private long lcbPrEnvLand;
	private long fcWss;
	private long lcbWss;
	private long fcDop;
	private long lcbDop;
	private long fcSttbfAssoc;
	private long lcbSttbfAssoc;
	private long fcClx;
	private long lcbClx;
	private long fcPlcfPgdFtn;
	private long lcbPlcfPgdFtn;
	private long fcAutosaveSource;
	private long lcbAutosaveSource;
	private long fcGrpXstAtnOwners;
	private long lcbGrpXstAtnOwners;
	private long fcSttbfAtnBkmk;
	private long lcbSttbfAtnBkmk;
	private long fcUnused2;
	private long lcbUnused2;
	private long fcUnused3;
	private long lcbUnused3;
	private long fcPlcSpaMom;
	private long lcbPlcSpaMom;
	private long fcPlcSpaHdr;
	private long lcbPlcSpaHdr;
	private long fcPlcfAtnBkf;
	private long lcbPlcfAtnBkf;
	private long fcPlcfAtnBkl;
	private long lcbPlcfAtnBkl;
	private long fcPms;
	private long lcbPms;
	private long fcFormFldSttbs;
	private long lcbFormFldSttbs;
	private long fcPlcfendRef;
	private long lcbPlcfendRef;
	private long fcPlcfendTxt;
	private long lcbPlcfendTxt;
	private long fcPlcfFldEdn;
	private long lcbPlcfFldEdn;
	private long fcUnused4;
	private long lcbUnused4;
	private long fcDggInfo;
	private long lcbDggInfo;
	private long fcSttbfRMark;
	private long lcbSttbfRMark;
	private long fcSttbfCaption;
	private long lcbSttbfCaption;
	private long fcSttbfAutoCaption;
	private long lcbSttbfAutoCaption;
	private long fcPlcfWkb;
	private long lcbPlcfWkb;
	private long fcPlcfSpl;
	private long lcbPlcfSpl;
	private long fcPlcftxbxTxt;
	private long lcbPlcftxbxTxt;
	private long fcPlcfFldTxbx;
	private long lcbPlcfFldTxbx;
	private long fcPlcfHdrtxbxTxt;
	private long lcbPlcfHdrtxbxTxt;
	private long fcPlcffldHdrTxbx;
	private long lcbPlcffldHdrTxbx;
	private long fcStwUser;
	private long lcbStwUser;
	private long fcSttbTtmbd;
	private long lcbSttbTtmbd;
	private long fcCookieData;
	private long lcbCookieData;
	private long fcPgdMotherOldOld;
	private long lcbPgdMotherOldOld;
	private long fcBkdMotherOldOld;
	private long lcbBkdMotherOldOld;
	private long fcPgdFtnOldOld;
	private long lcbPgdFtnOldOld;
	private long fcBkdFtnOldOld;
	private long lcbBkdFtnOldOld;
	private long fcPgdEdnOldOld;
	private long lcbPgdEdnOldOld;
	private long fcBkdEdnOldOld;
	private long lcbBkdEdnOldOld;
	private long fcSttbfIntlFld;
	private long lcbSttbfIntlFld;
	private long fcRouteSlip;
	private long lcbRouteSlip;
	private long fcSttbSavedBy;
	private long lcbSttbSavedBy;
	private long fcSttbFnm;
	private long lcbSttbFnm;
	private long fcPlfLst;
	private long lcbPlfLst;
	private long fcPlfLfo;
	private long lcbPlfLfo;
	private long fcPlcfTxbxBkd;
	private long lcbPlcfTxbxBkd;
	private long fcPlcfTxbxHdrBkd;
	private long lcbPlcfTxbxHdrBkd;
	private long fcDocUndoWord9;
	private long lcbDocUndoWord9;
	private long fcRgbUse;
	private long lcbRgbUse;
	private long fcUsp;
	private long lcbUsp;
	private long fcUskf;
	private long lcbUskf;
	private long fcPlcupcRgbUse;
	private long lcbPlcupcRgbUse;
	private long fcPlcupcUsp;
	private long lcbPlcupcUsp;
	private long fcSttbGlsyStyle;
	private long lcbSttbGlsyStyle;
	private long fcPlgosl;
	private long lcbPlgosl;
	private long fcPlcocx;
	private long lcbPlcocx;
	private long fcPlcfBteLvc;
	private long lcbPlcfBteLvc;
	private long dwLowDateTime;
	private long dwHighDateTime;
	private long fcPlcfLvcPre10;
	private long lcbPlcfLvcPre10;
	private long fcPlcfAsumy;
	private long lcbPlcfAsumy;
	private long fcPlcfGram;
	private long lcbPlcfGram;
	private long fcSttbListNames;
	private long lcbSttbListNames;
	private long fcSttbfUssr;
	private long lcbSttbfUssr;

	public void parse(InputStream in) throws IOException {
		this.fcStshfOrig = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbStshfOrig = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcStshf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbStshf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcffndRef = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcffndRef = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcffndTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcffndTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfandRef = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfandRef = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfandTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfandTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfSed = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfSed = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcPad = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcPad = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfPhe = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfPhe = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfGlsy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfGlsy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfGlsy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfGlsy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfHdd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfHdd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBteChpx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBteChpx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBtePapx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBtePapx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfSea = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfSea = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfFfn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfFfn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldMom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldMom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldHdr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldHdr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldFtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldFtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldAtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldAtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldMcr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldMcr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfBkmk = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfBkmk = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBkf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBkf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBkl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBkl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcCmds = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbCmds = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused1 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused1 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfMcr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfMcr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPrDrvr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPrDrvr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPrEnvPort = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPrEnvPort = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPrEnvLand = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPrEnvLand = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcWss = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbWss = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcDop = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbDop = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfAssoc = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfAssoc = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcClx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbClx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfPgdFtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfPgdFtn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcAutosaveSource = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbAutosaveSource = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcGrpXstAtnOwners = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbGrpXstAtnOwners = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfAtnBkmk = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfAtnBkmk = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused2 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused2 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused3 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused3 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcSpaMom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcSpaMom = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcSpaHdr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcSpaHdr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfAtnBkf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfAtnBkf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfAtnBkl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfAtnBkl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPms = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPms = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcFormFldSttbs = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbFormFldSttbs = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfendRef = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfendRef = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfendTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfendTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldEdn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldEdn = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUnused4 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUnused4 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcDggInfo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbDggInfo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfRMark = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfRMark = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfCaption = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfCaption = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfAutoCaption = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfAutoCaption = LeInteger
				.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfWkb = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfWkb = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfSpl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfSpl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcftxbxTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcftxbxTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfFldTxbx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfFldTxbx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfHdrtxbxTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfHdrtxbxTxt = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcffldHdrTxbx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcffldHdrTxbx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcStwUser = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbStwUser = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbTtmbd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbTtmbd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcCookieData = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbCookieData = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPgdMotherOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPgdMotherOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcBkdMotherOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbBkdMotherOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPgdFtnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPgdFtnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcBkdFtnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbBkdFtnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPgdEdnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPgdEdnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcBkdEdnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbBkdEdnOldOld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfIntlFld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfIntlFld = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcRouteSlip = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbRouteSlip = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbSavedBy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbSavedBy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbFnm = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbFnm = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlfLst = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlfLst = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlfLfo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlfLfo = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfTxbxBkd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfTxbxBkd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfTxbxHdrBkd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfTxbxHdrBkd = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcDocUndoWord9 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbDocUndoWord9 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcRgbUse = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbRgbUse = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUsp = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUsp = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcUskf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbUskf = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcupcRgbUse = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcupcRgbUse = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcupcUsp = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcupcUsp = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbGlsyStyle = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbGlsyStyle = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlgosl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlgosl = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcocx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcocx = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfBteLvc = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfBteLvc = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.dwLowDateTime = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.dwHighDateTime = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfLvcPre10 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfLvcPre10 = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfAsumy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfAsumy = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcPlcfGram = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbPlcfGram = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbListNames = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbListNames = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.fcSttbfUssr = LeInteger.toInteger(IOUtils.readFully(in, 4));
		this.lcbSttbfUssr = LeInteger.toInteger(IOUtils.readFully(in, 4));
	}

	public long getFcStshfOrig() {
		return fcStshfOrig;
	}

	public long getLcbStshfOrig() {
		return lcbStshfOrig;
	}

	public long getFcStshf() {
		return fcStshf;
	}

	public long getLcbStshf() {
		return lcbStshf;
	}

	public long getFcPlcffndRef() {
		return fcPlcffndRef;
	}

	public long getLcbPlcffndRef() {
		return lcbPlcffndRef;
	}

	public long getFcPlcffndTxt() {
		return fcPlcffndTxt;
	}

	public long getLcbPlcffndTxt() {
		return lcbPlcffndTxt;
	}

	public long getFcPlcfandRef() {
		return fcPlcfandRef;
	}

	public long getLcbPlcfandRef() {
		return lcbPlcfandRef;
	}

	public long getFcPlcfandTxt() {
		return fcPlcfandTxt;
	}

	public long getLcbPlcfandTxt() {
		return lcbPlcfandTxt;
	}

	public long getFcPlcfSed() {
		return fcPlcfSed;
	}

	public long getLcbPlcfSed() {
		return lcbPlcfSed;
	}

	public long getFcPlcPad() {
		return fcPlcPad;
	}

	public long getLcbPlcPad() {
		return lcbPlcPad;
	}

	public long getFcPlcfPhe() {
		return fcPlcfPhe;
	}

	public long getLcbPlcfPhe() {
		return lcbPlcfPhe;
	}

	public long getFcSttbfGlsy() {
		return fcSttbfGlsy;
	}

	public long getLcbSttbfGlsy() {
		return lcbSttbfGlsy;
	}

	public long getFcPlcfGlsy() {
		return fcPlcfGlsy;
	}

	public long getLcbPlcfGlsy() {
		return lcbPlcfGlsy;
	}

	public long getFcPlcfHdd() {
		return fcPlcfHdd;
	}

	public long getLcbPlcfHdd() {
		return lcbPlcfHdd;
	}

	public long getFcPlcfBteChpx() {
		return fcPlcfBteChpx;
	}

	public long getLcbPlcfBteChpx() {
		return lcbPlcfBteChpx;
	}

	public long getFcPlcfBtePapx() {
		return fcPlcfBtePapx;
	}

	public long getLcbPlcfBtePapx() {
		return lcbPlcfBtePapx;
	}

	public long getFcPlcfSea() {
		return fcPlcfSea;
	}

	public long getLcbPlcfSea() {
		return lcbPlcfSea;
	}

	public long getFcSttbfFfn() {
		return fcSttbfFfn;
	}

	public long getLcbSttbfFfn() {
		return lcbSttbfFfn;
	}

	public long getFcPlcfFldMom() {
		return fcPlcfFldMom;
	}

	public long getLcbPlcfFldMom() {
		return lcbPlcfFldMom;
	}

	public long getFcPlcfFldHdr() {
		return fcPlcfFldHdr;
	}

	public long getLcbPlcfFldHdr() {
		return lcbPlcfFldHdr;
	}

	public long getFcPlcfFldFtn() {
		return fcPlcfFldFtn;
	}

	public long getLcbPlcfFldFtn() {
		return lcbPlcfFldFtn;
	}

	public long getFcPlcfFldAtn() {
		return fcPlcfFldAtn;
	}

	public long getLcbPlcfFldAtn() {
		return lcbPlcfFldAtn;
	}

	public long getFcPlcfFldMcr() {
		return fcPlcfFldMcr;
	}

	public long getLcbPlcfFldMcr() {
		return lcbPlcfFldMcr;
	}

	public long getFcSttbfBkmk() {
		return fcSttbfBkmk;
	}

	public long getLcbSttbfBkmk() {
		return lcbSttbfBkmk;
	}

	public long getFcPlcfBkf() {
		return fcPlcfBkf;
	}

	public long getLcbPlcfBkf() {
		return lcbPlcfBkf;
	}

	public long getFcPlcfBkl() {
		return fcPlcfBkl;
	}

	public long getLcbPlcfBkl() {
		return lcbPlcfBkl;
	}

	public long getFcCmds() {
		return fcCmds;
	}

	public long getLcbCmds() {
		return lcbCmds;
	}

	public long getFcUnused1() {
		return fcUnused1;
	}

	public long getLcbUnused1() {
		return lcbUnused1;
	}

	public long getFcSttbfMcr() {
		return fcSttbfMcr;
	}

	public long getLcbSttbfMcr() {
		return lcbSttbfMcr;
	}

	public long getFcPrDrvr() {
		return fcPrDrvr;
	}

	public long getLcbPrDrvr() {
		return lcbPrDrvr;
	}

	public long getFcPrEnvPort() {
		return fcPrEnvPort;
	}

	public long getLcbPrEnvPort() {
		return lcbPrEnvPort;
	}

	public long getFcPrEnvLand() {
		return fcPrEnvLand;
	}

	public long getLcbPrEnvLand() {
		return lcbPrEnvLand;
	}

	public long getFcWss() {
		return fcWss;
	}

	public long getLcbWss() {
		return lcbWss;
	}

	public long getFcDop() {
		return fcDop;
	}

	public long getLcbDop() {
		return lcbDop;
	}

	public long getFcSttbfAssoc() {
		return fcSttbfAssoc;
	}

	public long getLcbSttbfAssoc() {
		return lcbSttbfAssoc;
	}

	public long getFcClx() {
		return fcClx;
	}

	public long getLcbClx() {
		return lcbClx;
	}

	public long getFcPlcfPgdFtn() {
		return fcPlcfPgdFtn;
	}

	public long getLcbPlcfPgdFtn() {
		return lcbPlcfPgdFtn;
	}

	public long getFcAutosaveSource() {
		return fcAutosaveSource;
	}

	public long getLcbAutosaveSource() {
		return lcbAutosaveSource;
	}

	public long getFcGrpXstAtnOwners() {
		return fcGrpXstAtnOwners;
	}

	public long getLcbGrpXstAtnOwners() {
		return lcbGrpXstAtnOwners;
	}

	public long getFcSttbfAtnBkmk() {
		return fcSttbfAtnBkmk;
	}

	public long getLcbSttbfAtnBkmk() {
		return lcbSttbfAtnBkmk;
	}

	public long getFcUnused2() {
		return fcUnused2;
	}

	public long getLcbUnused2() {
		return lcbUnused2;
	}

	public long getFcUnused3() {
		return fcUnused3;
	}

	public long getLcbUnused3() {
		return lcbUnused3;
	}

	public long getFcPlcSpaMom() {
		return fcPlcSpaMom;
	}

	public long getLcbPlcSpaMom() {
		return lcbPlcSpaMom;
	}

	public long getFcPlcSpaHdr() {
		return fcPlcSpaHdr;
	}

	public long getLcbPlcSpaHdr() {
		return lcbPlcSpaHdr;
	}

	public long getFcPlcfAtnBkf() {
		return fcPlcfAtnBkf;
	}

	public long getLcbPlcfAtnBkf() {
		return lcbPlcfAtnBkf;
	}

	public long getFcPlcfAtnBkl() {
		return fcPlcfAtnBkl;
	}

	public long getLcbPlcfAtnBkl() {
		return lcbPlcfAtnBkl;
	}

	public long getFcPms() {
		return fcPms;
	}

	public long getLcbPms() {
		return lcbPms;
	}

	public long getFcFormFldSttbs() {
		return fcFormFldSttbs;
	}

	public long getLcbFormFldSttbs() {
		return lcbFormFldSttbs;
	}

	public long getFcPlcfendRef() {
		return fcPlcfendRef;
	}

	public long getLcbPlcfendRef() {
		return lcbPlcfendRef;
	}

	public long getFcPlcfendTxt() {
		return fcPlcfendTxt;
	}

	public long getLcbPlcfendTxt() {
		return lcbPlcfendTxt;
	}

	public long getFcPlcfFldEdn() {
		return fcPlcfFldEdn;
	}

	public long getLcbPlcfFldEdn() {
		return lcbPlcfFldEdn;
	}

	public long getFcUnused4() {
		return fcUnused4;
	}

	public long getLcbUnused4() {
		return lcbUnused4;
	}

	public long getFcDggInfo() {
		return fcDggInfo;
	}

	public long getLcbDggInfo() {
		return lcbDggInfo;
	}

	public long getFcSttbfRMark() {
		return fcSttbfRMark;
	}

	public long getLcbSttbfRMark() {
		return lcbSttbfRMark;
	}

	public long getFcSttbfCaption() {
		return fcSttbfCaption;
	}

	public long getLcbSttbfCaption() {
		return lcbSttbfCaption;
	}

	public long getFcSttbfAutoCaption() {
		return fcSttbfAutoCaption;
	}

	public long getLcbSttbfAutoCaption() {
		return lcbSttbfAutoCaption;
	}

	public long getFcPlcfWkb() {
		return fcPlcfWkb;
	}

	public long getLcbPlcfWkb() {
		return lcbPlcfWkb;
	}

	public long getFcPlcfSpl() {
		return fcPlcfSpl;
	}

	public long getLcbPlcfSpl() {
		return lcbPlcfSpl;
	}

	public long getFcPlcftxbxTxt() {
		return fcPlcftxbxTxt;
	}

	public long getLcbPlcftxbxTxt() {
		return lcbPlcftxbxTxt;
	}

	public long getFcPlcfFldTxbx() {
		return fcPlcfFldTxbx;
	}

	public long getLcbPlcfFldTxbx() {
		return lcbPlcfFldTxbx;
	}

	public long getFcPlcfHdrtxbxTxt() {
		return fcPlcfHdrtxbxTxt;
	}

	public long getLcbPlcfHdrtxbxTxt() {
		return lcbPlcfHdrtxbxTxt;
	}

	public long getFcPlcffldHdrTxbx() {
		return fcPlcffldHdrTxbx;
	}

	public long getLcbPlcffldHdrTxbx() {
		return lcbPlcffldHdrTxbx;
	}

	public long getFcStwUser() {
		return fcStwUser;
	}

	public long getLcbStwUser() {
		return lcbStwUser;
	}

	public long getFcSttbTtmbd() {
		return fcSttbTtmbd;
	}

	public long getLcbSttbTtmbd() {
		return lcbSttbTtmbd;
	}

	public long getFcCookieData() {
		return fcCookieData;
	}

	public long getLcbCookieData() {
		return lcbCookieData;
	}

	public long getFcPgdMotherOldOld() {
		return fcPgdMotherOldOld;
	}

	public long getLcbPgdMotherOldOld() {
		return lcbPgdMotherOldOld;
	}

	public long getFcBkdMotherOldOld() {
		return fcBkdMotherOldOld;
	}

	public long getLcbBkdMotherOldOld() {
		return lcbBkdMotherOldOld;
	}

	public long getFcPgdFtnOldOld() {
		return fcPgdFtnOldOld;
	}

	public long getLcbPgdFtnOldOld() {
		return lcbPgdFtnOldOld;
	}

	public long getFcBkdFtnOldOld() {
		return fcBkdFtnOldOld;
	}

	public long getLcbBkdFtnOldOld() {
		return lcbBkdFtnOldOld;
	}

	public long getFcPgdEdnOldOld() {
		return fcPgdEdnOldOld;
	}

	public long getLcbPgdEdnOldOld() {
		return lcbPgdEdnOldOld;
	}

	public long getFcBkdEdnOldOld() {
		return fcBkdEdnOldOld;
	}

	public long getLcbBkdEdnOldOld() {
		return lcbBkdEdnOldOld;
	}

	public long getFcSttbfIntlFld() {
		return fcSttbfIntlFld;
	}

	public long getLcbSttbfIntlFld() {
		return lcbSttbfIntlFld;
	}

	public long getFcRouteSlip() {
		return fcRouteSlip;
	}

	public long getLcbRouteSlip() {
		return lcbRouteSlip;
	}

	public long getFcSttbSavedBy() {
		return fcSttbSavedBy;
	}

	public long getLcbSttbSavedBy() {
		return lcbSttbSavedBy;
	}

	public long getFcSttbFnm() {
		return fcSttbFnm;
	}

	public long getLcbSttbFnm() {
		return lcbSttbFnm;
	}

	public long getFcPlfLst() {
		return fcPlfLst;
	}

	public long getLcbPlfLst() {
		return lcbPlfLst;
	}

	public long getFcPlfLfo() {
		return fcPlfLfo;
	}

	public long getLcbPlfLfo() {
		return lcbPlfLfo;
	}

	public long getFcPlcfTxbxBkd() {
		return fcPlcfTxbxBkd;
	}

	public long getLcbPlcfTxbxBkd() {
		return lcbPlcfTxbxBkd;
	}

	public long getFcPlcfTxbxHdrBkd() {
		return fcPlcfTxbxHdrBkd;
	}

	public long getLcbPlcfTxbxHdrBkd() {
		return lcbPlcfTxbxHdrBkd;
	}

	public long getFcDocUndoWord9() {
		return fcDocUndoWord9;
	}

	public long getLcbDocUndoWord9() {
		return lcbDocUndoWord9;
	}

	public long getFcRgbUse() {
		return fcRgbUse;
	}

	public long getLcbRgbUse() {
		return lcbRgbUse;
	}

	public long getFcUsp() {
		return fcUsp;
	}

	public long getLcbUsp() {
		return lcbUsp;
	}

	public long getFcUskf() {
		return fcUskf;
	}

	public long getLcbUskf() {
		return lcbUskf;
	}

	public long getFcPlcupcRgbUse() {
		return fcPlcupcRgbUse;
	}

	public long getLcbPlcupcRgbUse() {
		return lcbPlcupcRgbUse;
	}

	public long getFcPlcupcUsp() {
		return fcPlcupcUsp;
	}

	public long getLcbPlcupcUsp() {
		return lcbPlcupcUsp;
	}

	public long getFcSttbGlsyStyle() {
		return fcSttbGlsyStyle;
	}

	public long getLcbSttbGlsyStyle() {
		return lcbSttbGlsyStyle;
	}

	public long getFcPlgosl() {
		return fcPlgosl;
	}

	public long getLcbPlgosl() {
		return lcbPlgosl;
	}

	public long getFcPlcocx() {
		return fcPlcocx;
	}

	public long getLcbPlcocx() {
		return lcbPlcocx;
	}

	public long getFcPlcfBteLvc() {
		return fcPlcfBteLvc;
	}

	public long getLcbPlcfBteLvc() {
		return lcbPlcfBteLvc;
	}

	public long getDwLowDateTime() {
		return dwLowDateTime;
	}

	public long getDwHighDateTime() {
		return dwHighDateTime;
	}

	public long getFcPlcfLvcPre10() {
		return fcPlcfLvcPre10;
	}

	public long getLcbPlcfLvcPre10() {
		return lcbPlcfLvcPre10;
	}

	public long getFcPlcfAsumy() {
		return fcPlcfAsumy;
	}

	public long getLcbPlcfAsumy() {
		return lcbPlcfAsumy;
	}

	public long getFcPlcfGram() {
		return fcPlcfGram;
	}

	public long getLcbPlcfGram() {
		return lcbPlcfGram;
	}

	public long getFcSttbListNames() {
		return fcSttbListNames;
	}

	public long getLcbSttbListNames() {
		return lcbSttbListNames;
	}

	public long getFcSttbfUssr() {
		return fcSttbfUssr;
	}

	public long getLcbSttbfUssr() {
		return lcbSttbfUssr;
	}
}
