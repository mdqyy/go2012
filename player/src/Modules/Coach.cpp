/**
 * @author fmartin
 * @author Carlos Agüero (caguero@gsyc.es)
 *
 * Version : $Id$
 * This file was generated by Aldebaran Robotics ModuleGenerator
 */

#include "Coach.h"

#include <iostream>
#include <fstream>

//______________________________________________
// constructor
//______________________________________________
Coach::Coach(ALPtr<ALBroker> pBroker, const std::string& pName) :
ALModule(pBroker, pName) {
	setModuleDescription(
			"This an autogenerated module, this description need to be updated.");

	functionName("dataChanged", "Coach", "Receive data");
	addParam("pDataName", "Parameter example.");
	addParam("pValue", "Another parameter example.");
	addParam("pMessage", "Another parameter example.");
	BIND_METHOD(Coach::dataChanged);

	cerr << begin_grey
			<< "\n\n-----------------------------\nBICA initializing"
			<< end_color << endl;

	try {
		AL::ALPtr<AL::ALMotionProxy> pmotion =
				getParentBroker()->getMotionProxy();
		pmotion->setStiffnesses("Body", 1.0);
	} catch (AL::ALError& e) {
		cerr << "Coach::Coach [motion]" << e.toString() << endl;
	}

	leds = Leds::getInstance();
	matchPlayer = MatchPlayer::getInstance();
	striker2 = Striker2::getInstance();
	body = Body::getInstance();
	perception = Perception::getInstance();
	_BallDetector = BallDetector::getInstance();
	_W3DDetector = W3DDetector::getInstance();
	_LineDetector = LineDetector::getInstance();
	_GoalDetector = GoalDetector::getInstance();
	_BGDetector = BGDetector::getInstance();
	_RobotDetector = RobotDetector::getInstance();
	head = Head::getInstance();
	followball = FollowBall::getInstance();
	searchball = SearchBall::getInstance();
	fallen = Fallen::getInstance();
	fsr = FSR::getInstance();
	speech = Speech::getInstance();
	searchnet = SearchNet::getInstance();
	worldmodel = WorldModel::getInstance();
	kinematics = Kinematics::getInstance();
	calibration = Calibration::getInstance();
	Pruebag2gpos = pruebag2gpos::getInstance();
	pruebaAttention = PruebaAttention::getInstance();
	go2gpos = Go2gpos::getInstance();
	go2pos = Go2pos::getInstance();
	go2gposobs = Go2gposObs::getInstance();
	localization = Localization::getInstance();
	bodydetector = BodyDetector::getInstance();
	kick = Kick::getInstance();
	sharedTeamInfo = SharedTeamInfo::getInstance();
	stratego = Stratego::getInstance();
	attention = Attention::getInstance();
	music = Music::getInstance();
	textspeech = TextSpeech::getInstance();
	movie = Movie::getInstance();
	ledscontrol = LedsControl::getInstance();
	footcontact = FootContact::getInstance();
	debug = Debug::getInstance();
	robotLog = RobotLog::getInstance();
	approachBall = ApproachBall::getInstance();
	strategyRoles = StrategyRoles::getInstance();
	goalieURJC = GoalieURJC::getInstance();
	pgoalie = PGoalie::getInstance();
	auxRole = AuxRole::getInstance();
	auxPenalty = AuxPenalty::getInstance();
	_WorldState = WorldState::getInstance();
	servercamera = NaoServerCamera::getInstance();
	servermotors = NaoServerMotors::getInstance();
	serverencoders = NaoServerEncoders::getInstance();
	serverpose3dmotors = NaoServerPose3DMotors::getInstance();
	serverpose3dencoders = NaoServerPose3DEncoders::getInstance();
	sensorrecordernao = SensorRecorderNao::getInstance();
	robotusdetector = RobotUSDetector::getInstance();
	recorderSession = RecorderSession::getInstance();
	playerSession = PlayerSession::getInstance();
	aleatoryMoveComponent = AleatoryMoveComponent::getInstance();

	leds->init("Leds", getParentBroker());
	matchPlayer->init("MatchPlayer", getParentBroker());
	striker2->init("Striker2", getParentBroker());
	body->init("Body", getParentBroker());
	music->init("Music",getParentBroker());
	_BallDetector->init("BallDetector", getParentBroker());
	_W3DDetector->init("W3DDetector", getParentBroker());
	_LineDetector->init("LineDetector", getParentBroker());
	_GoalDetector->init("GoalDetector", getParentBroker());
	_BGDetector->init("BGDetector", getParentBroker());
	_RobotDetector->init("RobotDetector", getParentBroker());
	head->init("Head", getParentBroker());
	followball->init("FollowBall", getParentBroker());
	searchball->init("SearchBall", getParentBroker());
	searchnet->init("SearchNet", getParentBroker());
	fallen->init("Fallen", getParentBroker());
	fsr->init("Fsr", getParentBroker());
	speech->init("Speech", getParentBroker());
	worldmodel->init();
	kinematics->init("Kinematics", getParentBroker());
	calibration->init();
	Pruebag2gpos->init("pruebag2gpos", getParentBroker());
	pruebaAttention->init("PruebaAttention", getParentBroker());
	go2gpos->init("Go2gpos", getParentBroker());
	go2pos->init("Go2Pos", getParentBroker());
	go2gposobs->init("Go2gposObs", getParentBroker());
	sharedTeamInfo->init("SharedTeamInfo", getParentBroker());
	localization->init("Localization", getParentBroker());
	bodydetector->init("BodyDetector", getParentBroker());
	kick->init("Kick", getParentBroker());
	attention->init("Attention", getParentBroker());
	stratego->init("Stratego", getParentBroker());
	textspeech->init("TextSpeech",getParentBroker());
	movie->init("Movie", getParentBroker());
	ledscontrol->init("LedsControl",getParentBroker());
	footcontact->init("FootContact",getParentBroker(),getName());
	debug->init("Debug",getParentBroker());
	robotLog->init("RobotLog", getParentBroker());
	approachBall->init("ApproachBall", getParentBroker());
	strategyRoles->init("StrategyRoles", getParentBroker());
	goalieURJC->init("GoalieURJC", getParentBroker());
	pgoalie->init("PGoalie", getParentBroker());
	auxRole->init("AuxRole", getParentBroker());
	auxPenalty->init("AuxPenalty", getParentBroker());
	perception->init("Perception", getParentBroker());
	_WorldState->init("WorldState", getParentBroker());
	robotusdetector->init("RobotUSDetector", getParentBroker());
	recorderSession->init("RecorderSession", getParentBroker());
	playerSession->init("PlayerSession", getParentBroker());

	servercamera->init("NaoServerCamera", getParentBroker());
	servermotors->init("NaoServerMotors", getParentBroker());
	serverencoders->init("NaoServerEncoders", getParentBroker());
	serverpose3dmotors->init("NaoServerPose3DMotors", getParentBroker());
	serverpose3dencoders->init("NaoServerPose3DEncoders", getParentBroker());
	sensorrecordernao->init("SensorRecorderNao", getParentBroker());

	aleatoryMoveComponent->init("AleatoryMoveComponent", getParentBroker());


	//csched = new CascadeScheduler();
	csched = CascadeScheduler::getInstance();
	csched ->init();

	body->poseInit(0.3);

	/*if(GameController::getInstance()->getPlayerNumber()==1)
		localization->setLocalization("GeneticLocalization");
	else
		localization->setLocalization("NEKFLocalization");*/

	//localization->setLocalization("EKFLocalization");
	localization->setLocalization("GTLocalization");

	//attention->setAttention("P");
	//attention->setAttention("RR");
	attention->setAttention("Q");

	//Init GameController
	GameController *gct = GameController::getInstance();
	initButtons();


	// Set the team number
	std::ifstream in("/home/nao/bica/conf/team.cfg");
	short teamNumber, me;

	if (in) {
		in >> teamNumber >> me;
	}
	sharedTeamInfo->setTeamNumber(teamNumber);

	// Set the color of the team (red or blue)
	std::ifstream in2("/home/nao/bica/conf/player.cfg");
	string colorTeam;
	if (in2) {
		in2 >> colorTeam;
	}
	sharedTeamInfo->setTeamColor(colorTeam);

	if ((colorTeam != "red") && (colorTeam != "blue"))
		cerr << begin_red << "Something goes wrong with the team color\n" << end_color;

	// Set ICE port and player number
	std::ifstream comms("/home/nao/bica/conf/comms.cfg");
	if (comms) {
		comms >> name1 >> ip1;
		comms >> name2 >> ip2;
		comms >> name3 >> ip3;
		comms >> name4 >> ip4;
	}else
		cerr << begin_red << "[Coach::Coach()] Config file (comms.cfg) not found in"
		" /home/nao/bica/conf/ directory\n" << end_color;


	if (getBrokerName() == "player1") {
		me = 1;
		//myIcePort = 10000 + me;
	}else if (getBrokerName() == "player2") {
		me = 2;
		//myIcePort = 10000 + me;
	}else if (getBrokerName() == "player3") {
		me = 3;
		//myIcePort = 10000 + me;
	}else if (getBrokerName() == "player4") {
		me = 4;
		//myIcePort = 10000 + me;
	}else{
		//myIcePort = 10000;
	}
	myIcePort = 10000 + me;

	sharedTeamInfo->setMyId(me);
	cout << "I am player number " << me << " on team " << teamNumber << endl;
	cout << "I am from team " << colorTeam << endl;

	// UDP port
	initUDPConn(9001);

	// "The 'force' will show you your path
	cerr << begin_green << "BICA ready\n" << end_color;
	if (sharedTeamInfo->getTeamColor() == "blue")
		cerr << begin_grey << "The " << begin_blue << "force" << begin_grey
		<< " will be with you..." << end_color << endl;
	else
		cerr << begin_grey << "The " << begin_red << "force" << begin_grey
		<< " will be with you..." << end_color << endl;
	cerr << begin_grey << "-----------------------------\n\n" << end_color
			<< endl;

	try
	{
		psentinel = getParentBroker()->getProxy("ALSentinel" );
		psentinel->callVoid("enableDefaultActionSimpleClick",false);
		psentinel->callVoid("enableDefaultActionDoubleClick",false);
		psentinel->callVoid("enableDefaultActionTripleClick",false);

	}catch( AL::ALError& e )
	{
		cerr<<"Coach::Coach [pfaceball]"<<e.toString()<<endl;
	}

	try {
			psonar = new ALSonarProxy(getParentBroker());

			ALValue params;
			params.arraySetSize(1);
			params[0] = 500;

			psonar->subscribe(getName(), 500, 1.0);

		} catch (ALError& e) {
			ostringstream s;
			s << "Fallen::init() [palinertial]" << e.toString() << endl;
			striker2->writeLog(s.str());
		}


	try {
		palrobotpose = new ALRobotPoseProxy(getParentBroker());

		ALValue params;
		params.arraySetSize(1);
		params[0] = 500;

		//palrobotpose->subscribe(getName(), 500, 1.0);
	} catch (ALError& e) {
		ostringstream s;
		s << "Fallen::init() [palinertial]" << e.toString() << endl;
		striker2->writeLog(s.str());
	}

	try {
		psensors = new ALSensorsProxy(getParentBroker());
		psensors->subscribe(getName(), 500, 1.0);
	} catch (ALError& e) {
		ostringstream s;
		s << "Fallen::init() [palinertial]" << e.toString() << endl;
		striker2->writeLog(s.str());
	}

	pthread_create(&tIceServer, NULL, iceServerThread, &myIcePort);

	//sharedTeamInfo->startTeammateInfoPrx();
	//csched->run("MatchPlayer");

}

//______________________________________________
// destructor
//______________________________________________
Coach::~Coach() {
	try {
		csched->run("Body");
		body->selKick("sentarse");
		sleep(10);

		psensors->unsubscribe(getName());

	} catch (ALError& e) {
		cerr << "Unable to activate " << getName() << ": " << e.toString()
																				<< endl;
	}
}

void Coach::initButtons()
{
	//cerr<<"Buttons inited"<<endl;
	try {
		AL::ALPtr<AL::ALMemoryProxy> pmemory = getParentBroker()->getMemoryProxy();
		pmemory->subscribeToEvent("RightBumperPressed", getName(), "dataChanged");
		pmemory->subscribeToEvent("LeftBumperPressed", getName(), "dataChanged");
		pmemory->subscribeToEvent("ChestButtonPressed", getName(), "dataChanged");

	} catch (ALError& e) {
		cerr << "[FootContact::init()] " << e.toString() << endl;
	}
}

void* Coach::iceServerThread(void *obj)
{
	std::stringstream endpoint;
	int *icePort = (int *)obj;

	string str = "player";
	char* argv[2];
	argv[0] = new char[str.size() + 1];
	std::copy(str.begin(), str.end(), argv[0]);
	argv[0][str.size()] = '\0'; // don't forget the terminating 0

	str = "0";
	argv[1] = new char[str.size() + 1];
	std::copy(str.begin(), str.end(), argv[1]);
	argv[1][str.size()] = '\0'; // don't forget the terminating 0

	//char* argv[] = {name.c_str(), 0};
	int argc = 1;
	int status = 0;
	Ice::CommunicatorPtr ic;
	try {
		endpoint << "default -p " << *icePort;

		//ic = SharedTeamInfo::getInstance()->getIceCommunicator();
		ic = Ice::initialize(argc, argv);
		Ice::ObjectAdapterPtr adapter
		//= ic->createObjectAdapterWithEndpoints("BICAadapter", "default -p 10000");
		= ic->createObjectAdapterWithEndpoints("BICAadapter", endpoint.str());

		adapter->add(Perception::getInstance(), ic->stringToIdentity("ImageProvider"));
		adapter->add(CascadeScheduler::getInstance(), ic->stringToIdentity("SchedulerManager"));
		adapter->add(WorldModel::getInstance(), ic->stringToIdentity("WorldModelProvider"));
		adapter->add(SharedTeamInfo::getInstance(), ic->stringToIdentity("TeamInfoProvider"));
		adapter->add(Calibration::getInstance(), ic->stringToIdentity("CalibrationProvider"));
		adapter->add(pruebag2gpos::getInstance(), ic->stringToIdentity("pruebag2gposManager"));
		adapter->add(Go2gpos::getInstance(), ic->stringToIdentity("Go2gposManager"));
		adapter->add(Go2gposObs::getInstance(), ic->stringToIdentity("Go2gposObsManager"));
		adapter->add(Go2pos::getInstance(), ic->stringToIdentity("Go2posManager"));
		adapter->add(Localization::getInstance(), ic->stringToIdentity("LocalizationProvider"));
		adapter->add(Register::getInstance(), ic->stringToIdentity("ComponentInfoProvider"));
		adapter->add(Head::getInstance(), ic->stringToIdentity("HeadMotionManager"));
		adapter->add(Music::getInstance(), ic->stringToIdentity("MusicManager"));
		adapter->add(TextSpeech::getInstance(), ic->stringToIdentity("TextSpeechManager"));
		adapter->add(Movie::getInstance(), ic->stringToIdentity("MovieManager"));
		adapter->add(Body::getInstance(), ic->stringToIdentity("BodyMotionManager"));
		adapter->add(Debug::getInstance(), ic->stringToIdentity("GrDebugProvider"));
		adapter->add(BallDetector::getInstance(), ic->stringToIdentity("BallDetectorManager"));
		adapter->add(GoalDetector::getInstance(), ic->stringToIdentity("GoalDetectorManager"));
		adapter->add(NEKFLocalization::getInstance(), ic->stringToIdentity("NEKFLineDbgManager"));
		adapter->add(RobotLog::getInstance(), ic->stringToIdentity("LogProvider"));

		adapter->add(NaoServerCamera::getInstance(), ic->stringToIdentity("Camera"));
		adapter->add(NaoServerMotors::getInstance(), ic->stringToIdentity("Motors"));
		adapter->add(NaoServerEncoders::getInstance(), ic->stringToIdentity("Encoders"));
		adapter->add(NaoServerPose3DMotors::getInstance(), ic->stringToIdentity("Pose3DMotors"));
		adapter->add(NaoServerPose3DEncoders::getInstance(), ic->stringToIdentity("Pose3DEncoders"));

		adapter->add(AleatoryMoveComponent::getInstance(), ic->stringToIdentity("AleatoryMoveManager"));

		adapter->activate();
		ic->waitForShutdown();
	} catch (const Ice::Exception& e) {
		cerr << e << endl;
		status = 1;
	} catch (const char* msg) {
		cerr << msg << endl;
		status = 1;
	}
	if (ic) {
		try {
			ic->destroy();
		} catch (const Ice::Exception& e) {
			cerr << e << endl;
			status = 1;
		}
	}
	return &status;
}

void Coach::dataChanged(const std::string& pDataName, const ALValue& pValue,
		const std::string& pMessage) {




	if((int)pValue==1)
	{
		//cerr<<"Informado...["<<pDataName<<","<<pValue<<"]"<<endl;
		if (pDataName.compare("RightBumperPressed")==0)
		{
			GameController::getInstance()->RightBumperPressed();
		}
		if (pDataName.compare("LeftBumperPressed")==0)
		{
			GameController::getInstance()->LeftBumperPressed();
		}
		if (pDataName.compare("ChestButtonPressed")==0)
		{
			GameController::getInstance()->ChestButtonPressed();
		}

		footcontact->dataChanged(pDataName,pValue,pMessage);
	}
}

/**
 * innerTest
 */
bool Coach::innerTest() {
	bool result = true;

	return result;
}

list<string> Coach::getTokens(char *data) {
	list<string> ret;
	string msg = data;
	istringstream iss(msg);
	string token;

	while (getline(iss, token, ':'))
		ret.push_back(token);

	return ret;
}


void Coach::setGT(list<string> args) {
	double x, y, theta, e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ballX, ballY;
	args.pop_front(); //gt

	e0 = atof(args.front().c_str());
	args.pop_front();
	e1 = atof(args.front().c_str());
	args.pop_front();
	e2 = atof(args.front().c_str());
	args.pop_front();
	e3 = atof(args.front().c_str());
	args.pop_front();
	e4 = atof(args.front().c_str());
	args.pop_front();
	e5 = atof(args.front().c_str());
	args.pop_front();
	e6 = atof(args.front().c_str());
	args.pop_front();
	e7 = atof(args.front().c_str());
	//args.pop_front();
	//e8 = atof(args.front().c_str());
	//args.pop_front();
	//e9 = atof(args.front().c_str());

	x = e0;
	y = e2;
	theta = e6;


	//ballX = e7;
	//ballY = e9;

	// From webots coordinates to blue net oriented coordinates
	theta = normalizePi(theta+pi_2);
	//cerr<<"("<<-x<<","<<y<<","<<theta<<")"<<endl;

	localization->setRealPosition(-x, y, theta);

	// Update Ball GT
	//_BallDetector->setGTBallAbs(ballX, ballY);

	// Set GT activated inside GoalDetector (for graphical debug)
	_GoalDetector->setGTActivated();
}

void Coach::UDPmanageRecv(int size) {

	//cerr<<"*"<<endl;

	char *buf = getUDPBuffer();
	buf[size] = '\0';

	list<string> tokens = getTokens(buf);

	if (tokens.front().compare("gt") == 0)
		setGT(tokens);
}