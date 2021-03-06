/*
 * Name: BallDetector.h
 * @Author: Eduardo Perdices (eperdices@gsyc.es)
 * @Modified: Carlos Agüero (caguero@gsyc.es)
 * 
 * Description: Class to detect balls from the Regions
 *
 * Created on: 31/05/2010
 *
 * Copyright (C) Universidad Rey Juan Carlos
 * All Rights Reserved.
 *
 */

#ifndef BALLDETECTOR_H_
#define BALLDETECTOR_H_

#include "Detector.h"
#include "../../lib/estimation/ObjectState.h"
#include "../../lib/estimation/SingleObjectModel.h"
#include "Body.h"
#include "Attention.h"
#include "Perception.h"
#include <IceE/IceE.h>
#include <debug.h>
#include "Debug.h"
#include <componentsI.h>
#include "RobotLog.h"
#include "GTLocalization.h"
#include "vision/detectors/GoalDetector.h"
#include "BallAttentionClient.h"

class Perception;
class GoalDetector;


class BallSample : public AbstractSample {
public:

	float ratio;
	float radius;
	float radius_expected;

};

class BallDetector: public Component, public Singleton<BallDetector>, public Detector,
public BallAttentionClient, public DebugIRel, public DebugIAbs, public BallDetectorManager, public LoggableI {
public:
	BallDetector();
	~BallDetector();

	void init(const string newName, AL::ALPtr<AL::ALBroker> parentBroker);
	void step();

	void detect(bool debug);

	void drawValidRegions(IplImage* src);
	void drawDetected(IplImage* src);	

	inline ObjectState* getObj() { return &(ballmodel->estimate); };
	
	bool isSeen();

	bica::ShapeList getGrDebugRel();
	bica::ShapeList getGrDebugAbs();
	virtual VisualMemoryObjPtr getVisualMemoryObject(const Ice::Current& c);
	virtual void predictionUpdate(const Ice::Current& c);
	virtual void measurementUpdate(const Ice::Current& c);

	bool isInsideOwnArea();
	bool isInsideOppArea();

	// Ground truth
	virtual void setGTBallAbs( double x, double y, const Ice::Current& c );
	void setGTBallAbs( double x, double y );
	void getGTBallAbs( double &x, double &y );
	void getGTBallRel( double &x, double &y );

	long elapsedTimeSinceLastObs() const;
	Vector2<double> getPosition() const;
	double getX() const;
	double getY() const;
	double getXerror() const;
	double getYerror() const;
	double getQuality() const;
	double getAngle() const;
	double getDistance() const;
	ObjectState::ObjectReliability getReliability() const;
	std::string getReliabilityString() const;

	BallModel 		*ballmodel;

private:

	void predict_step();
	void update_step();

	void updateFromObservation();
	void updateFromOdometry();
	void predict();

	/*Validate the balls*/
	void validateBalls();

	/*Obtain the radius of the ball if it's possible*/
	bool getBallRadius(BallRegion* ballRegion, BallSample &ball);

	/*Save the values of the ball if the ratio is correct*/
	bool saveValues(BallRegion* ballRegion, int col, int row, int sum1, int sum2, BallSample &ball);
	/*Return true if the ratio is valid for the ball*/
	bool checkBallRatio(int size1, int size2, float &ratio);
	/*Get the expected radius of the ball*/
	void getExpectedRadius(BallSample &ball);
	/*Check if the difference between radius and expected radius is valid*/
	bool checkRadius(BallSample &ball);

	/*Clear the samples already created*/
	void clearDetected();

	static const int MIN_BALL_SUM = 3;
	static const int MIN_THRESHOLD = 2;
	static const float MIN_VALID_RATIO;
	static const float BALL_RADIUS;
	static const int MIN_THRESHOLD_RADIUS = 3;
	static const float MIN_VALID_RATIO_RADIUS;
	static const int MIN_DIST_BALLS = 6;

	CvMemStorage *storage;
	CvSeqWriter writer;

	Body			*body;
	Perception		*perception;
	Kinematics 		*kinematics;
	GTLocalization *_GTLocalization;

	float			lastBodyX, lastBodyY, lastBodyTh;
	long 			lastBallTimestamp;
	list<BallSample> balls;
	bool 			measurement;

	// Ground truth
	double 			_gtBallX;
	double 			_gtBallY;
	bool 			_gtReceived;

	GoalDetector	*goalDetector;
};

#endif /* BALLDETECTOR_H_ */
