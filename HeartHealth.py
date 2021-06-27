import pandas as pd
import numpy as np
from sklearn.tree import DecisionTreeClassifier
from sklearn import svm
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import cross_val_score, train_test_split
from sklearn.preprocessing import Imputer, StandardScaler, OneHotEncoder
from sklearn.pipeline import Pipeline
from numpy import gen
from txt import matplotlib
#matplotlib.use('TKAgg')
import matplotlib.pyplot as plt
from sklearn.svm import LinearSVC
from sklearn.decomposition import PCA
import pylab as pl
from itertools import cycle
from sklearn.svm import SVC 

dataset = np.genfromtxt('C:/Users/inspiron/Desktop/cleveland_data.csv',dtype = float, delimiter=',',invalid_raise=False,usemask=False,filling_values=0.0,)
#print dataset
X = dataset[:,0:12] 
y = dataset[:,13]   

#Replacing 1-4 by 1 label
for index, item in enumerate(y):
    if not (item == 0.0):
        y[index] = 1
print y
target_names = ['0', '1']

#Method to plot the graph for reduced Dimesions
def plot_2D(data, target, target_names):
     colors = cycle('rgbcmykw')
     target_ids = range(len(target_names))
     plt.figure()
     for i, c, label in zip(target_ids, colors, target_names):
         plt.scatter(data[target == i, 0], data[target == i, 1],
                    c=c, label=label)
     plt.legend()
     plt.plot()
     plt.show()
     #plt.savefig('Problem 2 Graph')

modelSVM = LinearSVC(C=0.001)
pca = PCA(n_components=2, whiten=True).fit(X)
X_new = pca.transform(X)

# calling plot_2D
plot_2D(X_new, y, target_names)

class Predict:
    def __init__(self):
        self.X = []
        self.Y = []

    def Read_Clean(self,dataset):
        header_row = ['Age', 'Gender', 'Chest_Pain', 'Resting_Blood_Pressure', 'Serum_Cholestrol',
                      'Fasting_Blood_Sugar', 'Resting_ECG', 'Max_Heart_Rate',
                      'Exercise_Induced_Angina', 'OldPeak',
                      'Slope', 'CA', 'Thal', 'Num']
        df = pd.read_csv(dataset, names=header_row)
        df = df.replace('[?]', np.nan, regex=True)
        df = pd.DataFrame(Imputer(missing_values='NaN', strategy='mean', axis=0)
                          .fit_transform(df), columns=header_row)
        df = df.astype(float)
        return df

    def Split_Dataset(self, df):
        self.Y = df['Num'].apply(lambda x: 1 if x > 0 else 0)
        self.X = df.drop('Num', axis=1)

    def Create_Pipeline(self):
        estimators = []
        estimators.append(('standardize', StandardScaler()))
        estimators.append(('tree', svm.SVC()))
        model = Pipeline(estimators)
        return model

    def Cross_Validate(self, clf, cv=5):
        scores = cross_val_score(clf, self.X, self.Y, cv=cv, scoring='f1')
        score = scores.mean()
        print("CV scores mean: %.4f " % (score))

    def Fit_Score(self, clf, label='x'):
        clf.fit(self.X, self.Y)
        fit_score = clf.score(self.X, self.Y)
        print("%s: fit score %.5f" % (label, fit_score))

    def ReturnPredictionValue(self, clf, sample):
        y = clf.predict([sample])
        return y[0]

    def PredictionMain(self, sample, dataset_path='/home/divya/Desktop/cleveland_data.csv'):
        print "dataset: "+ dataset_path
        data = self.Read_Clean(dataset_path)
        self.Split_Dataset(data)
        self.model = self.Create_Pipeline()
        self.Fit_Score(self.model, label='SVM')
        self.Cross_Validate(self.model, 10)
        return self.ReturnPredictionValue(self.model, sample)
   
if __name__ == '__main__':
     sample = [46.0,1.0,4.0,140.0,311.0,0.0,0.0,120.0,1.0,1.8,2.0,2.0,7.0]
     p = Predict()
     print "Prediction value: {}".format(p.PredictionMain(sample))
