;; Copyright 2017 BigML
;; Licensed under the Apache License, Version 2.0
;; http://www.apache.org/licenses/LICENSE-2.0

(ns bigml.api.anomaly-detector
  "Functions specific for BigML anomaly detection.
     https://bigml.com/api/anomalies"
  (:require (bigml.api [core :as api]
                       [utils :as utils]))
  (:refer-clojure :exclude [list]))

(defn create
  "Creates an anomaly detector from a dataset. A dataset can be
  represented through its id (e.g., `dataset/123123`), or a map as
  returned by `get` or `list`.

  Accepts the optional creation parameters described in the BigML API docs:
     https://bigml.com/api/anomalies#an_anomaly_detector_arguments

  HTTP response information is attached as meta data. Exceptions are thrown
  on failure unless :throw-exceptions is set to false (default is true),
  in which case the HTTP response details are returned as a map on failure."
  [dataset & params]
  (utils/create :target :anomaly :origin [:dataset dataset] :params params))

(defn list
  "Retrieves a list of anomaly detectors. The optional parameters can include
  pagination and filtering options detailed here:
     https://bigml.com/api/anomalies#an_listing_anomaly_detectors

  Pagination details are returned as meta data attached to the list, along
  with the HTTP response information. Exceptions are thrown on failure unless
  :throw-exceptions is set to false (default is true), in which case the
  HTTP response details are returned in a map on failure."
  [& params]
  (apply api/list :anomaly params))
