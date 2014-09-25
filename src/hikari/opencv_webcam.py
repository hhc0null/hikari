#!/usr/bin/env python2

from cv2 import cv

cap = cv.CaptureFromCAM(0)
if cap:
    cv.NamedWindow("cam-test", cv.CV_WINDOW_AUTOSIZE)
    frame = cv.QueryFrame(cap)
    if frame:
        cv.ShowImage("cam-test", frame)
        cv.WaitKey(0)
        cv.SaveImage("cam-test.jpg", frame)
cv.DestroyWindow("cam-test")
