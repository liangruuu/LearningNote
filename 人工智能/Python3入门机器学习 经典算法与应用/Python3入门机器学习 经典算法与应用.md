## 第3章 Jupyter Notebook, numpy和matplotlib

### 3.3 Numpy数据基础

对于numpy来说，其下的核心数据结构起始就是array，只不过numpy可以方便地将这个数组看成是一个多维的数组，比如说二维数组或者三维数组来存储二维或者三维的数据，进而将这些数组看成是矩阵来进行矩阵相关的运算 

#### 3.3.1 Python List的特点

Python List也可以表示一维或者多维数组，那么它的缺点是什么呢

![image-20210427082429812](Untitled.assets/image-20210427082429812.png)

Python List其实是一个对类型不做限定的List，与此同时在一个List中的每一个List元素的类型也可以是不同的。所以其的效率相对而言是比较低的，因为Python List需要对其中的每一个元素进行校验检测是哪一种数据类型

![image-20210427082437116](Untitled.assets/image-20210427082437116.png)

其实在Python中也有限定只能存储一种数据类型的数组，这个数组叫array。array本身还有一个缺点，就是它只是将存储在其中的数据当做是一个数组来看，但是无论是基于数组也好或者是二维数组也罢，它没有将这些数据看作是向量或者是矩阵，相应的也没有将这些数据配备和向量相关或者矩阵相关的运算。这就导致我们在机器学习中使用array也不方便，由此numpy这个框架也就应运而生

![image-20210427082747884](Untitled.assets/image-20210427082747884.png)

****

![image-20210427082826436](Untitled.assets/image-20210427082826436.png)

#### 3.3.2 numpy.array

![image-20210427083749653](Untitled.assets/image-20210427083749653.png)

初始化的时候就存在浮点类型
![image-20210427083931629](Untitled.assets/image-20210427083931629.png)

### 3.4 创建Numpy数组(和矩阵)

numpy为我们内置了很多函数，可以去创建特殊的一维或者二维的数组

![image-20210427085133567](Untitled.assets/image-20210427085133567.png)

****

![image-20210427085239501](Untitled.assets/image-20210427085239501.png)

#### 3.4.1 arange

![image-20210427085645350](Untitled.assets/image-20210427085645350.png)

#### 3.4.2 linspace

![image-20210427090024599](Untitled.assets/image-20210427090024599.png)

#### 3.4.3 随机数random

![image-20210427090731703](Untitled.assets/image-20210427090731703.png)

****

![image-20210427090748358](Untitled.assets/image-20210427090748358.png)

### 3.5 Numpy数组(和矩阵)的基本操作

![image-20210427092206262](Untitled.assets/image-20210427092206262.png)

#### 3.5.1 基本属性

![image-20210427092341271](Untitled.assets/image-20210427092341271.png)

#### 3.5.2 numpy.array的数据访问

![image-20210427092838910](Untitled.assets/image-20210427092838910.png)

****

![image-20210427092900639](Untitled.assets/image-20210427092900639.png)

****

![image-20210427093443834](Untitled.assets/image-20210427093443834.png)

****

![image-20210427093859817](Untitled.assets/image-20210427093859817.png)

#### 3.5.3 reshape

![image-20210427094324456](Untitled.assets/image-20210427094324456.png)

### 3.6 Numpy数组(和矩阵)的合并与分割

![image-20210427101042433](Untitled.assets/image-20210427101042433.png)

****

![image-20210427101052865](Untitled.assets/image-20210427101052865.png)

#### 3.6.1 分割操作

![image-20210427102201296](Untitled.assets/image-20210427102201296.png)

****

![image-20210427102212154](Untitled.assets/image-20210427102212154.png)

****

![image-20210427102219524](Untitled.assets/image-20210427102219524.png)

### 3.7 Numpy中的矩阵运算

![image-20210427103028019](Untitled.assets/image-20210427103028019.png)

#### 3.7.1 Universal Funtions

![image-20210427103503538](Untitled.assets/image-20210427103503538.png)

#### 3.7.2 矩阵运算

![image-20210427104504250](Untitled.assets/image-20210427104504250.png)

#### 3.7.3 矩阵的逆

![image-20210427112723220](Untitled.assets/image-20210427112723220.png)

### 3.8 Numpy中的聚合运算

![image-20210427113212277](Untitled.assets/image-20210427113212277.png)

### 3.9 Numpy中的比较和Fancy Indexing

![image-20210427113957012](Untitled.assets/image-20210427113957012.png)

#### 3.9.1 numpy.array的比较

![image-20210427114820556](Untitled.assets/image-20210427114820556.png)

****

![image-20210427114830938](Untitled.assets/image-20210427114830938.png)

### 3.10 Matplotlib数据可视化基础

![image-20210427121648748](Untitled.assets/image-20210427121648748.png)

****

![image-20210427121702806](Untitled.assets/image-20210427121702806.png)

***

![image-20210427121713093](Untitled.assets/image-20210427121713093.png)

#### 3.10.1 Scatter Plot

![image-20210427121856821](Untitled.assets/image-20210427121856821.png)

### 3.11 数据加载和简单的数据探索

![image-20210427123406107](Untitled.assets/image-20210427123406107.png)

****

![image-20210427123417253](Untitled.assets/image-20210427123417253.png)

****

![image-20210427123425085](Untitled.assets/image-20210427123425085.png)

## 第4章 最基础的分类算法-k近邻算法 kNN

### 4.1 k近邻算法基础

![image-20210427123619616](Untitled.assets/image-20210427123619616.png)

****

![image-20210427123812793](Untitled.assets/image-20210427123812793.png)

已经知道的数据点，其实是分布在一个特征空间中的，这里为了便于展示从而使用了二维空间来描绘特征点，但是需要知道的树特征空间不仅仅只有二维，还有更高维度。

横轴代表肿瘤大小，纵轴代表发现肿瘤的时间。每一个病人在特征空间中构成了每一个点，其中恶性肿瘤用蓝色表示，良性肿瘤用红色表示

用绿色代表新增的一个病人肿瘤，那么我们怎么判断这个新增的肿瘤是良性的还是恶性的，K近邻算法就是这样一个算法，首先我们必须取一个k值（这里取3）。则K近邻算法就是在所有的点当中寻找离该点最近的3个点，然后最近的3个点以它们自己的label进行投票。换句话对于这个新增的绿色点，离它最近的3个点都是用蓝色来表示的，所以蓝色对红色是3:0，因此K近邻算法就说这个新增的点有很高概率是恶性肿瘤

K近邻算法的本质就是说：两个样本如果它们足够相似，那么它们就有更高的概率处于同一个类别，当然我们只看离它最近的一个点显然是不够的，所以我们需要设置最合适的K值。我们看两个样本的相似性其实就是看了两个样本在特征空间当中的距离来进行描述的

![image-20210427124835230](Untitled.assets/image-20210427124835230.png)

此时又来了一个新的样本，那么离它最近的3个点红色和蓝色的比例是2:1，红色胜出，所以K近邻算法对于这个新的病人来说他有更高的概率是良性肿瘤患者

K近邻算法首先能解决的就是监督学习中的分类问题

![image-20210427133217367](Untitled.assets/image-20210427133217367.png)

****

![image-20210427133225816](Untitled.assets/image-20210427133225816.png)

#### 4.1.1 kNN的过程

两个特征点的距离计算，其中特征空间有n维

a样本的第i个特征和b样本的第i个特征相减

![image-20210427133431110](Untitled.assets/image-20210427133431110.png)

****

![image-20210427134515719](Untitled.assets/image-20210427134515719.png)

### 4.2 scikit-learn中的机器学习算法封装

```python
import numpy as np
from math import sqrt
from collections import Counter

def kNN_classify(k, X_train, y_train, x):
    
    assert 1 <= k <= X_train.shape[0], "k must be valid"
    assert X_train.shape[0] == y_train.shape[0], \
        "the size of X_train must be equal to the size of y_train"
    assert X_train.shape[1] == x.shape[0], \
        "the feature number of X_predict must be equal to X_train"
    distances = [
        sqrt(np.sum((x_train - x)**2)) for x_train in X_train
    ]
    nearest = np.argsort(distances)

    topK_y = [y_train[i] for i in nearest[:k]]
    votes = Counter(topK_y)

    return votes.most_common(1)[0][0]
```

![image-20210427190552015](Untitled.assets/image-20210427190552015.png)

****

![image-20210427190733335](Untitled.assets/image-20210427190733335.png)

#### 4.2.1 使用scikit-learn中的knn

![image-20210427191802875](Untitled.assets/image-20210427191802875.png)

#### 4.2.2 重新整理我们的kNN代码

```python
import numpy as np
from math import sqrt
from collections import Counter

class KNNClassifier:
    def __init__(self, k):
        """初始化kNN分类器"""
        assert k >= 1, "k must be valid"
        self.k = k
        self._X_train = None
        self._y_train = None

        def fit(self, X_train, y_train):
            """根据训练数据集X_train和y_train训练kNN分类器"""
            assert X_train.shape[0] == y_train.shape[0], \
            "the size of X_train must be equal to the size of y_train"
            assert self.k <= X_train.shape[0], \
            "the size of X_train must be at least k."

            self._X_train = X_train
            self._y_train = y_train
            return self

        def predict(self, X_predict):
            """给定待预测数据集X_predict，返回表示X_predict的结果向量"""
            assert self._X_train is not None and self._y_train is not None, \
            "must fit before predict!"
            assert X_predict.shape[1] == self._X_train.shape[1], \
            "the feature number of X_predict must be equal to X_train"

            y_predict = [self._predict(x) for x in X_predict]
            return np.array(y_predict)

        def _predict(self, x):
            """给定单个待预测数据x，返回x的预测结果值"""
            assert x.shape[0] == self._X_train.shape[1], \
            "the feature number of x must be equal to X_train"

            distances = [
                sqrt(np.sum((x_train - x)**2)) for x_train in self._X_train
            ]
            nearest = np.argsort(distances)

            topK_y = [self._y_train[i] for i in nearest[:self.k]]
            votes = Counter(topK_y)

            return votes.most_common(1)[0][0]

        def __repr__(self):
            return "KNN(k=%d)" % self.k
```

![image-20210427193153912](Untitled.assets/image-20210427193153912.png)

### 4.3 训练数据集，测试数据集

#### 4.3.1 判断机器学习算法的性能

![image-20210427193329610](Untitled.assets/image-20210427193329610.png)

****

**![image-20210427193621664](Untitled.assets/image-20210427193621664.png)**

#### 4.3.2 训练数据集，测试数据集

![image-20210427194947450](Untitled.assets/image-20210427194947450.png)

****

![image-20210427195003586](Untitled.assets/image-20210427195003586.png)

****

![image-20210427195020747](Untitled.assets/image-20210427195020747.png)

```python
import numpy as np

def train_test_split(X, y, test_ratio=0.2, seed=None):
    """将数据 X 和 y 按照test_ratio分割成X_train, X_test, y_train, y_test"""
    assert X.shape[0] == y.shape[0], \
    "the size of X must be equal to the size of y"
    assert 0.0 <= test_ratio <= 1.0, \
    "test_ration must be valid"

    if seed:
        np.random.seed(seed)

        shuffled_indexes = np.random.permutation(len(X))

        test_size = int(len(X) * test_ratio)
        test_indexes = shuffled_indexes[:test_size]
        train_indexes = shuffled_indexes[test_size:]

        X_train = X[train_indexes]
        y_train = y[train_indexes]

        X_test = X[test_indexes]
        y_test = y[test_indexes]

        return X_train, X_test, y_train, y_test
```

#### 4.3.3 使用我们的算法

![image-20210427195953514](Untitled.assets/image-20210427195953514.png)

![image-20210427195959034](Untitled.assets/image-20210427195959034.png)

#### 4.3.4 sklearn中的train_test_split

![image-20210427200228776](Untitled.assets/image-20210427200228776.png)

### 4.4 分类准确度

![image-20210427211943380](Untitled.assets/image-20210427211943380.png)

****

![image-20210427213553653](Untitled.assets/image-20210427213553653.png)

![image-20210427213626113](Untitled.assets/image-20210427213626113.png)

![image-20210427213637083](Untitled.assets/image-20210427213637083.png)

```python
"metrics.py"
def accuracy_score(y_true, y_predict):
    """计算y_true和y_predict之间的准确率"""
    assert len(y_true) == len(y_predict), \
    "the size of y_true must be equal to the size of y_predict"

    return np.sum(y_true == y_predict) / len(y_true)
```

```python
"kNN.py"
def score(self, X_test, y_test):
    """根据测试数据集 X_test 和 y_test 确定当前模型的准确度"""

    y_predict = self.predict(X_test)
    return accuracy_score(y_test, y_predict)
```

#### 4.4.1 scikit-learn中的accuracy_score

![image-20210427220156321](Untitled.assets/image-20210427220156321.png)

### 4.5 超参数

![image-20210427220626823](Untitled.assets/image-20210427220626823.png)

 `kNN_clf = KNeighborsClassifier(n_neighbors=3)`，在sklearn中k值被封装成了n_neighbors，我们之前都是随意的传值，但是对于这个参数，传什么值是最好的呢，那么这就涉及到机器学习领域一个非常重要的问题：超参数问题

超参数：在我们运行机器学习算法之前需要指定的参数，kNN算法中的k就是一个典型超参数。调参其实就是调整超参数

![image-20210427220440487](Untitled.assets/image-20210427220440487.png)

****

![image-20210427220544885](Untitled.assets/image-20210427220544885.png)

****

![image-20210427220946333](Untitled.assets/image-20210427220946333.png)

kNN算法不仅只有k这一个超参数，其实kNN算法还潜藏着一个超参数

![image-20210427221118804](Untitled.assets/image-20210427221118804.png)

当k取3的时候找到距离需要判断的节点最近的3个节点，根据投票情况蓝色节点获胜。但是这个过程只考虑了离绿色节点最近的三个节点，但是却忽略的最近三个节点相应的距离是多少，起始绿色节点距离红色节点是最近的，虽然蓝色节点是距离绿色节点次近的，但是还是距离绿色节点稍远，因此红色节点的权重应该比其他两个蓝色节点的权重要大

这就是K近邻算法另外一个用法，就是考虑了距离的权重（把距离的倒数看作权重），距离越小权重越大

**考虑距离：红色:1		蓝色:1/3+1/4 = 7/12	==> 红色胜**
![image-20210427221714654](Untitled.assets/image-20210427221714654.png)

#### 4.5.1 考虑距离？不考虑距离？

![image-20210427222042813](Untitled.assets/image-20210427222042813.png)

#### 4.5.2 更多关于距离的定义

![image-20210427222102277](Untitled.assets/image-20210427222102277.png)

****

![image-20210427222153517](Untitled.assets/image-20210427222153517.png)

****

![image-20210427222236197](Untitled.assets/image-20210427222236197.png)

****

![image-20210427222243596](Untitled.assets/image-20210427222243596.png)

****

![image-20210427222251512](Untitled.assets/image-20210427222251512.png)

****

![image-20210427222319479](Untitled.assets/image-20210427222319479.png)

****

![image-20210427222343893](Untitled.assets/image-20210427222343893.png)

![image-20210427222640591](Untitled.assets/image-20210427222640591.png)

### 4.6 网格搜索与k近邻算法中更多超参数

![image-20210428064841171](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428064841171.png)

### 4.7 数据归一化

![image-20210428065011723](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428065011723.png)

对于这两个样本来说，样本间如果是用欧拉距离的话就是$\sqrt{(5-1)^2 + (200-100)^2}$，在这种情况下两者间距离被发现时间所主导，这是因为发现时间间隔了100天，而肿瘤大小只相差了4cm。由于不同特征的量纲不同导致最终的距离主要衡量了发现天数之间的差值

![image-20210428065453098](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428065453098.png)

如果把发现天数的量纲改为年的话，样本间距离又被肿瘤大小所主导

如果不进行数据的处理的话，直接计算出样本间距离很有可能是有偏差的，不能很好地同时反应样本中每一个特征的重要程度，正因如此我们要对数据进行归一化处理

![image-20210428065722411](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428065722411.png)

****

![image-20210428065820183](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428065820183.png)

* 分布有明显边界：成绩（0~100），像素点（0~255）...
* 分布没有明显边界：收入...

![image-20210428070019056](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428070019056.png)

#### 4.7.1 最值归一化 Normalization

![image-20210428071133776](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428071133776.png)

****

![image-20210428071204984](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428071204984.png)

##### 4.7.2 均值方差归一化 Standardlization

![image-20210428071527385](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428071527385.png)

### 4.8 scikit-learn中的Scaler

![image-20210428071743015](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428071743015.png)

如果新增一个测试样本，是很难获知该新增点的平均值和方差的。所以需要时用训练数据产生的均值和方差来对测试数据进行归一化

![image-20210428071855011](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428071855011.png)

****

![image-20210428072153650](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428072153650.png)

****

![image-20210428073354503](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428073354503.png)

![image-20210428073406591](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428073406591.png)

```python
"preprocessing.py"
import numpy as np

class StandardScaler:

    def __init__(self):
        self.mean_ = None
        self.scale_ = None

    def fit(self, X):
        """根据训练数据集X获得数据的均值和方差"""
        assert X.ndim == 2, "The dimension of X must be 2"

        self.mean_ = np.array([np.mean(X[:,i]) for i in range(X.shape[1])])
        self.scale_ = np.array([np.std(X[:,i]) for i in range(X.shape[1])])

        return self

    def transform(self, X):
        """将X根据这个StandardScaler进行均值方差归一化处理"""
        assert X.ndim == 2, "The dimension of X must be 2"
        assert self.mean_ is not None and self.scale_ is not None, \
               "must fit before transform!"
        assert X.shape[1] == len(self.mean_), \
               "the feature number of X must be equal to mean_ and std_"

        resX = np.empty(shape=X.shape, dtype=float)
        for col in range(X.shape[1]):
            resX[:,col] = (X[:,col] - self.mean_[col]) / self.scale_[col]
        return resX
```

![image-20210428073556556](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428073556556.png)

## 第5章 线性回归法

### 5.1  简单线性回归

![image-20210428074258145](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428074258145.png)

****

![image-20210428074423059](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428074423059.png)

这个二维平面图和之前讲过的分类问题的二维平面图有很大的区别，这个区别在于分类问题的横纵轴都是样本的特征，也就是每个样本都有两个特征，样本的输出标记是样本的点是红色的还是蓝色的。而在回归问题中，只有横轴是样本的特征，纵轴就已经是样本的输出标记了，也就是房屋的价格。这是因为在回归问题中我们要预测的是一个具体的数值，这个具体的数值是在一个连续的空间里的，而不是可以用简单离散的值来表示的，所以它需要占用一个坐标轴的位置。如果想要解决两个特征样本的回归问题的还，就需要在三维空间进行观察了

![image-20210428074611771](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428074611771.png)

****

![image-20210428075018627](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075018627.png)

****

![image-20210428075125370](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075125370.png)

****

![image-20210428075205186](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075205186.png)

****

![image-20210428075251185](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075251185.png)

****

![image-20210428075344786](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075344786.png)

![image-20210428075412129](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075412129.png)

****

![image-20210428075549361](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075549361.png)

### 5.2 最小二乘法

![image-20210428075826138](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075826138.png)

****

![image-20210428075903393](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075903393.png)

****

![image-20210428075949497](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428075949497.png)

****

![image-20210428080053306](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428080053306.png)

****

![image-20210428080237866](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428080237866.png)

### 5.3 简单线性回归的实现

![image-20210428083207783](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428083207783.png)

![image-20210428083227472](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428083227472.png)

![image-20210428083233656](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428083233656.png)

```python
"SimpleLinearRegression"
import numpy as np

class SimpleLinearRegression:

    def __init__(self):
        """初始化Simple Linear Regression模型"""
        self.a_ = None
        self.b_ = None

    def fit(self, x_train, y_train):
        """根据训练数据集x_train, y_train训练Simple Linear Regression模型"""
        assert x_train.ndim == 1, \
            "Simple Linear Regressor can only solve single feature training data."
        assert len(x_train) == len(y_train), \
            "the size of x_train must be equal to the size of y_train"

        x_mean = np.mean(x_train)
        y_mean = np.mean(y_train)

        num = 0.0  # 分子
        d = 0.0  # 分母
        for x_i, y_i in zip(x, y):
            num += (x_i - x_mean) * (y_i - y_mean)
            d += (x_i - x_mean) ** 2
            
        self.a_ = num / d
		self.b_ = y_mean - self.a_ * x_mean

        return self

    def predict(self, x_predict):
        """给定待预测数据集x_predict，返回表示x_predict的结果向量"""
        assert x_predict.ndim == 1, \
            "Simple Linear Regressor can only solve single feature training data."
        assert self.a_ is not None and self.b_ is not None, \
            "must fit before predict!"

        return np.array([self._predict(x) for x in x_predict])

    def _predict(self, x_single):
        """给定单个待预测数据x，返回x的预测结果值"""
        return self.a_ * x_single + self.b_

    def __repr__(self):
        return "SimpleLinearRegression()"
```

### 5.4 向量化

![image-20210428085935134](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428085935134.png)

****

![image-20210428090037838](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428090037838.png)

```python
"SimpleLinearRegression"
import numpy as np

class SimpleLinearRegression:

    def __init__(self):
        """初始化Simple Linear Regression模型"""
        self.a_ = None
        self.b_ = None

    def fit(self, x_train, y_train):
        """根据训练数据集x_train, y_train训练Simple Linear Regression模型"""
        assert x_train.ndim == 1, \
            "Simple Linear Regressor can only solve single feature training data."
        assert len(x_train) == len(y_train), \
            "the size of x_train must be equal to the size of y_train"

        x_mean = np.mean(x_train)
        y_mean = np.mean(y_train)

        self.a_ = (x_train - x_mean).dot(y_train - y_mean) / (x_train - x_mean).dot(x_train - x_mean)
        self.b_ = y_mean - self.a_ * x_mean

        return self

    def predict(self, x_predict):
        """给定待预测数据集x_predict，返回表示x_predict的结果向量"""
        assert x_predict.ndim == 1, \
            "Simple Linear Regressor can only solve single feature training data."
        assert self.a_ is not None and self.b_ is not None, \
            "must fit before predict!"

        return np.array([self._predict(x) for x in x_predict])

    def _predict(self, x_single):
        """给定单个待预测数据x，返回x的预测结果值"""
        return self.a_ * x_single + self.b_

    def __repr__(self):
        return "SimpleLinearRegression()"
```

### 5.5 衡量线性回归法的指标：MSE，RMSE和MAE

![image-20210428090625220](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428090625220.png)

****

![image-20210428090712851](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428090712851.png)

因为存在求和，所以样本数量1000的可能要比样本数量100的在最终结果上要大，但是不能认为前者的算法要比后者差，因为存在数据量的差异，所以我们应该要让衡量标准与测试样本数量无关

![image-20210428090737962](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428090737962.png)

解决存在量纲上的差异的问题

![image-20210428090935586](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428090935586.png)

****

![image-20210428091049293](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428091049293.png)

****

![image-20210428094405873](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428094405873.png)

![image-20210428094411777](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428094411777.png)

****

#### 5.5.1 使用简单线性回归

![image-20210428094425682](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428094425682.png)

**![image-20210428094435952](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428094435952.png)**

#### 5.5.2 sciki-learn中的MSE和MAE

![image-20210428094523067](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428094523067.png)

### 5.6 最好的衡量线性回归法的指标：R Squared

![image-20210428095243466](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428095243466.png)

![image-20210428095503359](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428095503359.png)

****

![image-20210428095513384](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428095513384.png)

****

![image-20210428095845267](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428095845267.png)

```python
"metrics.py"

def r2_score(y_true, y_predict):
    """计算y_true和y_predict之间的R Square"""

    return 1 - mean_squared_error(y_true, y_predict)/np.var(y_true)
```

### 5.7 多元线性回归和正规方程解

![image-20210428100330336](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428100330336.png)

****

![image-20210428100428791](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428100428791.png)

****

![image-20210428100523608](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428100523608.png)

![image-20210428100549702](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428100549702.png)

****

![image-20210428100744013](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428100744013.png)

****

![image-20210428100942261](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428100942261.png)

****

![image-20210428101247336](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428101247336.png)

 ### 5.8 实现多元线性回归

![image-20210428101353398](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428101353398.png)

```python
import numpy as np
from .metrics import r2_score

class LinearRegression:

    def __init__(self):
        """初始化Linear Regression模型"""
        self.coef_ = None
        self.intercept_ = None
        self._theta = None

    def fit_normal(self, X_train, y_train):
        """根据训练数据集X_train, y_train训练Linear Regression模型"""
        assert X_train.shape[0] == y_train.shape[0], \
            "the size of X_train must be equal to the size of y_train"

        X_b = np.hstack([np.ones((len(X_train), 1)), X_train])
        self._theta = np.linalg.inv(X_b.T.dot(X_b)).dot(X_b.T).dot(y_train)

        self.intercept_ = self._theta[0]
        self.coef_ = self._theta[1:]

        return self

    def predict(self, X_predict):
        """给定待预测数据集X_predict，返回表示X_predict的结果向量"""
        assert self.intercept_ is not None and self.coef_ is not None, \
            "must fit before predict!"
        assert X_predict.shape[1] == len(self.coef_), \
            "the feature number of X_predict must be equal to X_train"

        X_b = np.hstack([np.ones((len(X_predict), 1)), X_predict])
        return X_b.dot(self._theta)

    def score(self, X_test, y_test):
        """根据测试数据集 X_test 和 y_test 确定当前模型的准确度"""

        y_predict = self.predict(X_test)
        return r2_score(y_test, y_predict)

    def __repr__(self):
        return "LinearRegression()"

```

![image-20210428102532596](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428102532596.png)

### 5.9 使用scikit-learn解决回归问题

![image-20210428102843929](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428102843929.png)

### 5.10 线性回归的可解释性

正数系数代表正相关和负数系数代表负相关，

大系数代表强影响和小系数代表微影响

## 第6章 梯度下降法

### 6.1 什么是梯度下降法

![image-20210428123112224](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123112224.png)

****

![image-20210428123434052](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123434052.png)

****

**![image-20210428123611312](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123611312.png)**

****

![image-20210428123719866](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123719866.png)

****

![image-20210428123748353](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123748353.png)

****

![image-20210428123802059](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123802059.png)

****

![image-20210428123815275](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123815275.png)

****

![image-20210428123920730](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123920730.png)

****

![image-20210428123903058](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123903058.png)

****

![image-20210428123942322](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428123942322.png)

### 6.2 模拟实现梯度下降法

![image-20210428131117708](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131117708.png)

****

![image-20210428131130047](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131130047.png)

****

![image-20210428131141120](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131141120.png)

****

![image-20210428131156110](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131156110.png)

****

![image-20210428131206909](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131206909.png)

****

![image-20210428131226182](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131226182.png)

****

![image-20210428131241342](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131241342.png)

### 6.3 多元线性回归中的梯度下降法

![image-20210428133416254](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133416254.png)

****

![image-20210428133438254](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133438254.png)

****

**两个特征的梯度下降**

![image-20210428133510485](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133510485.png)

****

![image-20210428133530838](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133530838.png)

****

![image-20210428133611102](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133611102.png)

****

![image-20210428133725208](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133725208.png)

### 6.4 实现线性回归中的梯度下降法

![image-20210428131547103](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428131547103.png)

#### 6.4.1 使用梯度下降训练

![image-20210428132804431](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428132804431.png)

****

![image-20210428132814000](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428132814000.png)

#### 6.4.2 封装我们的线性回归算法

```python
    "LinearRegression.py"
    def fit_gd(self, X_train, y_train, eta=0.01, n_iters=1e4):
        """根据训练数据集X_train, y_train, 使用梯度下降法训练Linear Regression模型"""
        assert X_train.shape[0] == y_train.shape[0], \
            "the size of X_train must be equal to the size of y_train"

        def J(theta, X_b, y):
            try:
                return np.sum((y - X_b.dot(theta)) ** 2) / len(y)
            except:
                return float('inf')

        def dJ(theta, X_b, y):
            res = np.empty(len(theta))
            res[0] = np.sum(X_b.dot(theta) - y)
            for i in range(1, len(theta)):
                res[i] = (X_b.dot(theta) - y).dot(X_b[:, i])
            return res * 2 / len(X_b)

        def gradient_descent(X_b, y, initial_theta, eta, n_iters=1e4, epsilon=1e-8):

            theta = initial_theta
            cur_iter = 0

            while cur_iter < n_iters:
                gradient = dJ(theta, X_b, y)
                last_theta = theta
                theta = theta - eta * gradient
                if (abs(J(theta, X_b, y) - J(last_theta, X_b, y)) < epsilon):
                    break

                cur_iter += 1

            return theta
```

![image-20210428133208077](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133208077.png)

### 6.5 梯度下降法的向量化和数据标准化

![image-20210428133824174](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428133824174.png)

****

![image-20210428140236407](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428140236407.png)

```python
    "LinearRegression.py"
    def fit_gd(self, X_train, y_train, eta=0.01, n_iters=1e4):
        """根据训练数据集X_train, y_train, 使用梯度下降法训练Linear Regression模型"""
        assert X_train.shape[0] == y_train.shape[0], \
            "the size of X_train must be equal to the size of y_train"

        def J(theta, X_b, y):
            try:
                return np.sum((y - X_b.dot(theta)) ** 2) / len(y)
            except:
                return float('inf')

        def dJ(theta, X_b, y):
            # res = np.empty(len(theta))
            # res[0] = np.sum(X_b.dot(theta) - y)
            # for i in range(1, len(theta)):
            #     res[i] = (X_b.dot(theta) - y).dot(X_b[:, i])
            # return res * 2 / len(X_b)
            return X_b.T.dot(X_b.dot(theta) - y) * 2. / len(X_b)

        def gradient_descent(X_b, y, initial_theta, eta, n_iters=1e4, epsilon=1e-8):

            theta = initial_theta
            cur_iter = 0

            while cur_iter < n_iters:
                gradient = dJ(theta, X_b, y)
                last_theta = theta
                theta = theta - eta * gradient
                if (abs(J(theta, X_b, y) - J(last_theta, X_b, y)) < epsilon):
                    break

                cur_iter += 1

            return theta
```

![image-20210428140944352](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428140944352.png)

****

![image-20210428141455498](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428141455498.png)

****

![image-20210507101303780](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507101303780.png)

### 6.6 随机梯度下降法

![image-20210507082104872](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507082104872.png)

之前的梯度下降法一直是想要最优化的损失函数在某一点theta的梯度值准确地算出来，通过推导的公式可以看出来要想求出准确的梯度出来，则在这个式子中每一项要对所有的样本进行一下计算（求和）。

这样子的梯度下降法又称为批量梯度下降法，也就是说每一次的计算过程都要将样本中的所有信息进行批量地计算，但是这显然就带来了一个问题：如果m的值非常大，也就是说样本量非常大的话，那么计算梯度本身也是非常耗时的

![image-20210507082354151](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507082354151.png)

由于每一项都对m个样本进行计算，那么最后为了取平均值还除以了一个m，所以一个自然延伸的想法就是可不可以每一次只对其中的一个样本进行计算。那么基于这样子的想法，把求和符号去掉，同时对于角标(i)而言m每一次都取固定的一个i，相应的在大括号的外头也就不需要除以m了，直接乘以2就可以了。当然可以对其进行向量化操作，向量化的操作和之前是一样的，只不过此时对于X_b而言每一次只取一行就可以了。我们使用这样一个式子来当做搜索的方向是否可行呢，这里需要注意的是搜索的方向而不是梯度的方向，因为这个式子本身已经不是损失函数的梯度了，只不过我们观察梯度这个式子设想一下每一次都随机取出一个i，对于随机取得的i计算这样一个式子，这个式子也是一个向量，也可以表达一个方向，我们朝着这个方向进行搜索，不停地迭代能不能得到损失函数的最小值呢？这个想法的实现思路就被成为随机梯度下降法

![image-20210507091814113](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507091814113.png)

随机梯度下降法的搜索过程如图所示，如果是批量梯度下降法的话，从外面的一点开始搜索将会坚定不移地沿着一个固定的方向，也就是整个损失函数最小值的方向移动。但是随机梯度下降法不保证诶一次得到的方向一定是损失函数减小的方向，更不能保证一定是减小速度最快的方向，所以搜索路径就会呈现出这样一种态势。但是实验结论告诉我们，即使如此我们通过随机梯度下降法通常依然能够差不多的来到整个函数相应的最小值的附近，虽然它可能不会像批量梯度下降法那样一定来到最小值这个固定的位置，但是当样本数量m非常大的时候，很多时候可能更愿意用一定的精度换区一定的时间，这样随机梯度下降法就有意义了

而且在具体实践的时候有个非常重要的技巧就是在随机梯度下降法的过程中这个学习率的取值就会变得很重要，这是因为在随机梯度下降法的过程中如果我们的学习率一直取一个固定值的话，那很有可能在一定程度上随机梯度下降法已经来到最小值中心左右的位置了，但是由于随机过程不够好，学习率又是一个固定的值，那么很有可能跳出最小值所在位置。所以在实践中使用SGD时学习率是随着循环次数递增而逐渐递减的

![image-20210507093402711](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507093402711.png)

当循环次数比较少的时候，$\eta$下降的太快了，比如当循环次数从1变到2，则$\eta$一下子就下降了50%；但是当循环次数从10000到10001的话，则$\eta$才下降万分之一，前后$\eta$下降速度差别太大，所以通常再具体实现的时候在分母上一般都会添加一个常数来缓解这种情况，常数b一般取值为50，也就是说当循环次数从0上升到1的时候，$\eta$只会下降2%左右，用来缓解在初始情况下$\eta$变化太大的情况

分子如果取1的话在某些情况下也达不到我们想要的效果，所以让分子也取一个常数a=5

a和b就是随机梯度下降法对应的超参数

![image-20210507101343176](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507101343176.png)

![image-20210507101358196](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507101358196.png)

![image-20210507101403364](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507101403364.png)

### 6.7 scikit-learn中的随机梯度下降法

```python
    def fit_sgd(self, X_train, y_train, n_iters=5, t0=5, t1=50):
        """根据训练数据集X_train, y_train, 使用梯度下降法训练Linear Regression模型"""
        assert X_train.shape[0] == y_train.shape[0], \
            "the size of X_train must be equal to the size of y_train"
        assert n_iters >= 1

        def dJ_sgd(theta, X_b_i, y_i):
            return X_b_i * (X_b_i.dot(theta) - y_i) * 2.

        def sgd(X_b, y, initial_theta, n_iters, t0=5, t1=50):

            def learning_rate(t):
                return t0 / (t + t1)

            theta = initial_theta
            m = len(X_b)

            # 在之前调用随机梯度下降法法的时候循环次数是样本个数/3，这种方式显示是不科学的
            # 相对而言更科学的方式显然应该把所有的样本都看一遍，这样才能保证所有样本的信息都考虑进来了
            # 如果基于这样的想法的话n_iters具体取多少值就很难讲了，这跟fit传递过来的样本个数是有关的
            # 所以这种情况下随机梯度下降法中n_iters描述的是对所以样本看几遍，所以n_iters初始化值可以特比小比如5
            # 这代表在梯度下降法中循环次数是要将样本整体最少看五遍
            for cur_iter in range(n_iters):
                # 对原数据进行乱序排序使得最大可能对不同样本进行梯度下降法
                indexes = np.random.permutation(m)
                X_b_new = X_b[indexes]
                y_new = y[indexes]
                for i in range(m):
                    gradient = dJ_sgd(theta, X_b_new[i], y_new[i])
                    theta = theta - learning_rate(cur_iter * m + i) * gradient

            return theta

        X_b = np.hstack([np.ones((len(X_train), 1)), X_train])
        initial_theta = np.random.randn(X_b.shape[1])
        self._theta = sgd(X_b, y_train, initial_theta, n_iters, t0, t1)

        self.intercept_ = self._theta[0]
        self.coef_ = self._theta[1:]

        return self
```

#### 6.7.1 使用我们自己的SGD

![image-20210507105352568](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507105352568.png)

![image-20210507105415148](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507105415148.png)

![image-20210507105443057](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507105443057.png)

### 6.8 如何确定梯度计算的准确性？调试梯度下降法

![image-20210507113528536](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507113528536.png)

****

![image-20210507113542865](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507113542865.png)

![image-20210507122932718](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507122932718.png)

![image-20210507122941511](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210507122941511.png)

## 第7章 PCA与梯度上升法

### 7.1 什么是PCA(主成分分析)

![image-20210428144718515](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428144718515.png)



****

![image-20210428145015643](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145015643.png)



右侧的降维方式是比较合适的，因为点和点之间的距离相对是比较大的，也就是说点和点之间有较大的可区分度，但这并不是最好的方案

![image-20210428145004881](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145004881.png)

****

将所有的点全都映射到一根直线上

![image-20210428145355916](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145355916.png)

****

![image-20210428145334915](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145334915.png)

****

![image-20210428145548491](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145548491.png)

****

![image-20210428145629082](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145629082.png)

****

![image-20210428145646723](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145646723.png)

****

![image-20210428145724211](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145724211.png)

****

![image-20210428145801441](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145801441.png)

****

![image-20210428145938011](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428145938011.png)

****

![image-20210428150025450](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428150025450.png)

****

![image-20210428151124666](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428151124666.png)

****

![image-20210428151137802](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428151137802.png)

****

![image-20210428151304867](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428151304867.png)

### 7.2 使用梯度上升法求解PCA问题

![image-20210428152233373](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428152233373.png)

****

![image-20210428152323714](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428152323714.png)

****

![image-20210428152352622](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428152352622.png)

****

![image-20210428152835316](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428152835316.png)

### 7.3 求数据的主成分PCA

![image-20210428154453741](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428154453741.png)

****

![image-20210428154502486](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428154502486.png)

#### 7.3.1 梯度上升法

![image-20210428161020655](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428161020655.png)

![image-20210428161028648](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428161028648.png)

![image-20210428161036669](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210428161036669.png)

### 7.4 求数据的前n个主成分

![image-20210429080119731](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429080119731.png)

样本点本身都是二维的坐标点，我们将它们映射在轴上之后还不是一维的数据，只不过这些坐标点相应的一个维度从原先的横纵轴中的其中一个轴转变成了斜着的一个轴。但是由于其还是二维的数据，他还应该有另外一个轴，如果对于一个N维数据对应的应该有N个轴，只不过通过PCA进行了重新排列使得第一个轴保持样本点的方差最大，第二个轴次之.....

也就是说PCA本质上说是从一组坐标系转移到了另外一个坐标系，之前我们只求出了第一个轴所在的方向，如何求出下一个主成分的方向呢？

![image-20210429080654881](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429080654881.png)

****

![image-20210429080641209](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429080641209.png)

****

![image-20210429082640951](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429082640951.png)

****

![image-20210429082659465](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429082659465.png)

****

![image-20210429082707886](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429082707886.png)

****

![image-20210429082719962](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429082719962.png)

### 7.5 高维数据映射为低维数据

![image-20210429082912406](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429082912406.png)

W_k表示求出的针对X数据集的前k个主成分，W_k也是一个矩阵。k表示k个主成分，n表示每一个主成分对应的坐标轴应该有n个特征元素，因为PCA本质是从一个坐标系转变成另一个坐标系，原来的坐标系有n个维度的话，转变后的坐标系也应该有n个维度

那么如何将矩阵X从n维转变为k维呢？

X_k：m个样本，k个特征维度

```python
"PCA.py"
import numpy as np

class PCA:

    def __init__(self, n_components):
        """初始化PCA"""
        assert n_components >= 1, "n_components must be valid"
        self.n_components = n_components
        self.components_ = None

    def fit(self, X, eta=0.01, n_iters=1e4):
        """获得数据集X的前n个主成分"""
        assert self.n_components <= X.shape[1], \
            "n_components must not be greater than the feature number of X"

        def demean(X):
            return X - np.mean(X, axis=0)

        def f(w, X):
            return np.sum((X.dot(w) ** 2)) / len(X)

        def df(w, X):
            return X.T.dot(X.dot(w)) * 2. / len(X)

        def direction(w):
            return w / np.linalg.norm(w)

        def first_component(X, initial_w, eta=0.01, n_iters=1e4, epsilon=1e-8):

            w = direction(initial_w)
            cur_iter = 0

            while cur_iter < n_iters:
                gradient = df(w, X)
                last_w = w
                w = w + eta * gradient
                w = direction(w)
                if (abs(f(w, X) - f(last_w, X)) < epsilon):
                    break

                cur_iter += 1

            return w

        X_pca = demean(X)
        self.components_ = np.empty(shape=(self.n_components, X.shape[1]))
        for i in range(self.n_components):
            initial_w = np.random.random(X_pca.shape[1])
            w = first_component(X_pca, initial_w, eta, n_iters)
            self.components_[i,:] = w

            X_pca = X_pca - X_pca.dot(w).reshape(-1, 1) * w

        return self

    def transform(self, X):
        """将给定的X，映射到各个主成分分量中"""
        assert X.shape[1] == self.components_.shape[1]

        return X.dot(self.components_.T)

    def inverse_transform(self, X):
        """将给定的X，反向映射回原来的特征空间"""
        assert X.shape[1] == self.components_.shape[0]

        return X.dot(self.components_)

    def __repr__(self):
        return "PCA(n_components=%d)" % self.n_components
```

![image-20210429084944459](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429084944459.png)

### 7.6 scikit-learn中的PCA

![image-20210429085923783](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429085923783.png)

#### 7.6.1 真实数据集

![image-20210429092501788](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429092501788.png)

![image-20210429092510404](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429092510404.png)

![image-20210429092516890](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429092516890.png)

### 7.7 使用PCA对数据进行降噪

![image-20210429100351472](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429100351472.png)

#### 7.7.1 手写识别数据

![image-20210429100412257](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429100412257.png)

![image-20210429100419568](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429100419568.png)

![image-20210429100429210](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429100429210.png)

## 第8章 多项式回归与模型泛化

### 8.1 什么是多项式回归

线性回归法有一个很大的局限性，他要求假设数据背后是存在线性关系的，但是在我们的实际应用场景中具有线性关系这么强的假设的数据集相对来说是可能比较少的，更多的数据集之间是具有而非线性关系

![image-20210429164806709](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429164806709.png)

****

![image-20210429164835941](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429164835941.png)

****

![image-20210429171537411](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429171537411.png)

![image-20210429171546498](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429171546498.png)

![image-20210429171556627](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429171556627.png)

### 8.2 scikit-learn中的多项式回归与Pipeline

![image-20210429173456349](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429173456349.png)

![image-20210429173504066](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429173504066.png)

****

![image-20210429173812454](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429173812454.png)

#### 8.2.1 Pipeline

![image-20210429174935480](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429174935480.png)

### 8.3 过拟合与欠拟合

![image-20210429193836849](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429193836849.png)

![image-20210429193849661](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429193849661.png)

![image-20210429193905848](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429193905848.png)

![image-20210429193922382](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429193922382.png)

![image-20210429193927805](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429193927805.png)

* 虽然随着拟合次方数不断升高，使得拟合的点获得了更小的误差，但是曲线完全不是我们想要的样子，这种情况被称为**过拟合**
* 就如线性回归一样，这种样子显然也并没有非常好的反应原数据的样本特征，它是太过简单了，这种情况被称为**欠拟合**

### 8.4 为什么要有训练数据集与测试数据集

![image-20210429194339436](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429194339436.png)

在过拟合的场景下，虽然这条曲线将原先的样本点拟合的特别好，但是一旦来了新的样本点，那么它就不能进行很好地预测了。这时我们称得到的预测模型的泛化能力是非常弱的

因此我们衡量模型对训练数据的拟合能力是没有意义的，我们真正需要的是模型的泛化能力，即对新数据的拟合程度

![image-20210429194726975](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429194726975.png)

****

![image-20210429195541876](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429195541876.png)

****

![image-20210429195817392](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429195817392.png)

****

![image-20210429195637676](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429195637676.png)

****

![image-20210429195645107](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429195645107.png)

### 8.5 学习曲线

![image-20210429195936857](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429195936857.png)

****

![image-20210429202024755](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429202024755.png)

![image-20210429202031163](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429202031163.png)

![image-20210429202051409](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429202051409.png)

![image-20210429202101250](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429202101250.png)

****

![image-20210429202108521](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429202108521.png)

****

![image-20210429202117538](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429202117538.png)

### 8.6 验证数据集与交叉验证

![image-20210429204923251](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429204923251.png)

模型在一定程度上围绕着测试数据集打转，也就是说我们在想办法找到一组参数，这组参数使得我们用训练数据集获得的模型在测试数据集上效果最好，但是由于测试数据集是已知的，我们相当于在针对这组测试数据集进行调参，那么模型就可能会对测试数据集过拟合

![image-20210429205016671](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429205016671.png)

****

![image-20210429205340921](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429205340921.png)

****

![image-20210429205406839](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429205406839.png)

****

![image-20210429210554422](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429210554422.png)

![image-20210429210601502](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429210601502.png)

****

![image-20210429210616211](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429210616211.png)

### 8.7 模型泛化与岭回归

![image-20210429211441963](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429211441963.png)

****

![image-20210429211745651](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429211745651.png)

#### 8.7.1 使用岭回归

![image-20210429213522986](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429213522986.png)

![image-20210429213534732](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429213534732.png)

![image-20210429213540732](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429213540732.png)

![image-20210429213548862](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429213548862.png)

![image-20210429213558173](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210429213558173.png)

### 8.8 LASSO回归

![image-20210526205808322](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526205808322.png)

****

![image-20210526205845372](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526205845372.png)

在岭回归取α=100时，得到的模型依然是一个曲线，事实上使用岭回归方式很难得到一条倾斜的直线，它总是保持一种倾斜的形状；而使用LASSO时，α=0.1得到的严格来说依然是一条曲线，但是显然比岭回归方式得到的曲线要平，更像一条直线

直线与曲线的区别在于，曲线表示依然有很多特征前线是存在系数的；当使用LASSO时，倾向使很多特征前面不存在系数，即θ_i=0。这表示LASSO回归认为θ系数对应为0的特征是完全没必要的

![image-20210526205920180](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526205920180.png)

****

![image-20210526210338422](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526210338422.png)

****

![image-20210526210511524](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526210511524.png)

****

![image-20210526210522488](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526210522488.png)

### 8.9 L1, L2和弹性网络

![image-20210526212426746](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526212426746.png)

****

![image-20210526212449730](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526212449730.png)

****

![image-20210526212458371](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526212458371.png)

## 第9章 逻辑回归

### 9.1 什么是逻辑回归

对于机器学习算法来说，本质其实就是求出一个函数f，如果有一个样本x通过f的运算之后就会得到一个预测值，我们通常称之为y。在之前的线性回归和多项式回归中，y的值实际上就是我们关心的那个指标，比如对于房价预测来说，y就是房价；如果要预测学生的成绩，则y就是成绩本身

但是在逻辑回归中，y是一个概率值。也就是对于逻辑回归而言我们是要得到一个函数f，我们把样本扔给f之后，f(x)会计算出一个概率值p，之后我们根据这个概率值p来进行分类，如果p≥0.5，也就是发生概率大于50％我们就将y赋值为1，同理p≤0.5，我们就将y赋值为0。当然这个1和0在具体问题中可以有不同的含义，比如在预测肿瘤大小和时间的问题中，y=1代表恶性肿瘤患者，y=0代表良性肿瘤患者；在银行信用卡问题中，1代表有风险，0代表没风险

![image-20210430105107282](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430105107282.png)

在线性回归算法中，一个样本包含有若干特征，经过得到的f(x)计算得到y对应的值

注意：因为存在theta0，所以x用x_b来表示，就是每来一个样本这个样本前面还要加一个1，这个1和theta9去相乘得到的是截距。这样子算y得到的值是从负无穷——>正无穷，即通过线性回归求得的是任意一个值，但是对于概率而言只能在0-1之间取值。所以解决办法为：我们任然使用线性回归的运算方式，只不过我们将得到的结果再通过sigmoid函数的转换从而转换成一个值域在0~1之间的概率值

![image-20210430105219262](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430105219262.png)

****

![image-20210430105241469](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430105241469.png)

****

![image-20210430105424726](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430105424726.png)

****

![image-20210430105437472](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430105437472.png)

我们制定出了这样一个规则，要求出相应的theta值使得通过这样的方式进行预测在训练数据集上首先它能有非常好的预测结果，也就是拟合这个样本数据集。但是在逻辑回归框架下解决这个问题远远没有线性回归这这么直观，因为在线性回归中，我们可以用MSE来判断拟合的好坏

![image-20210430105531820](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430105531820.png)

****

### 9.2 逻辑回归的损失函数

![image-20210430113251562](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430113251562.png)

如果给定样本的真实y分类为1的话，那么我们估计出来的p越小的话，cost越大，因为p越小就意味着案发越倾向把预测y分类为0，也就是估计错误了，所以cost越大；同理反方向也成立

![image-20210430113521280](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430113521280.png)

****

![image-20210430113819713](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430113819713.png)

****

![image-20210430113843042](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430113843042.png)

****

![image-20210430113929945](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430113929945.png)

****

![image-20210430113946097](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430113946097.png)

****

![image-20210430114104385](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114104385.png)

### 9.3 逻辑回归损失函数的梯度

![image-20210430114152512](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114152512.png)

****

![image-20210430114300010](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114300010.png)

****

![image-20210430114329016](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114329016.png)

****

![image-20210430114521850](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114521850.png)

![image-20210430114539983](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114539983.png)

![image-20210430114913311](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430114913311.png)

****

![image-20210430115007336](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430115007336.png)

****

![image-20210430115200289](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430115200289.png)

****

![image-20210430115141506](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430115141506.png)

### 9.4 实现逻辑回归算法

```python
"LogisticRegression.py"
import numpy as np
from .metrics import accuracy_score

class LogisticRegression:
    def __init__(self):
        """初始化Linear Regression模型"""
        self.coef_ = None
        self.intercept_ = None
        self._theta = None

    def _sigmoid(self, t):
        return 1. / (1. + np.exp(-t))

    def fit(self, X_train, y_train, eta=0.01, n_iters=1e4):
        """根据训练数据集X_train, y_train, 使用梯度下降法训练Logistic Regression模型"""
        assert X_train.shape[0] == y_train.shape[0], \
            "the size of X_train must be equal to the size of y_train"

        def J(theta, X_b, y):
            y_hat = self._sigmoid(X_b.dot(theta))

            try:
                return np.sum(y * np.log(y_hat) +
                              (1 - y) * np.log(1 - y_hat)) / len(y)
            except:
                return float('inf')

        def dJ(theta, X_b, y):
            return X_b.T.dot(self._sigmoid(X_b.dot(theta)) - y) / len(X_b)

        def gradient_descent(X_b,
                             y,
                             initial_theta,
                             eta,
                             n_iters=1e4,
                             epsilon=1e-8):

            theta = initial_theta
            cur_iter = 0

            while cur_iter < n_iters:
                gradient = dJ(theta, X_b, y)
                last_theta = theta
                theta = theta - eta * gradient
                if (abs(J(theta, X_b, y) - J(last_theta, X_b, y)) < epsilon):
                    break

                cur_iter += 1

            return theta

        X_b = np.hstack([np.ones((len(X_train), 1)), X_train])
        initial_theta = np.zeros(X_b.shape[1])
        self._theta = gradient_descent(X_b, y_train, initial_theta, eta,
                                       n_iters)

        self.intercept_ = self._theta[0]
        self.coef_ = self._theta[1:]

        return self

    def predict_proba(self, X_predict):
        """给定待预测数据集X_predict，返回表示X_predict的结果概率向量"""
        assert self.intercept_ is not None and self.coef_ is not None, \
            "must fit before predict!"
        assert X_predict.shape[1] == len(self.coef_), \
            "the feature number of X_predict must be equal to X_train"
        X_b = np.hstack([np.ones((len(X_predict), 1)), X_predict])
        return self._sigmoid(X_b.dot(self._theta))

    def predict(self, X_predict):
        """给定待预测数据集X_predict，返回表示X_predict的结果向量"""
        assert self.intercept_ is not None and self.coef_ is not None, \
            "must fit before predict!"
        assert X_predict.shape[1] == len(self.coef_), \
            "the feature number of X_predict must be equal to X_train"

        proba = self.predict_proba(X_predict)
        return np.array(proba >= 0.5, dtype='int')

    def score(self, X_test, y_test):
        """根据测试数据集 X_test 和 y_test 确定当前模型的准确度"""

        y_predict = self.predict(X_test)
        return accuracy_score(y_test, y_predict)

    def __repr__(self):
        return "LogisticRegression()"
```

![image-20210430122816764](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430122816764.png)

### 9.5 决策边界

![image-20210430122957394](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430122957394.png)

系数和截距的组合构成了theta向量，在逻辑回归中对于theta向量有什么几何意义呢？

![image-20210430131810254](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430131810254.png)

![image-20210430131857452](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430131857452.png)

****

![image-20210430132003334](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430132003334.png)

****

![image-20210430132525958](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430132525958.png)

![image-20210430132530558](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430132530558.png)

### 9.6 在逻辑回归中使用多项式特征

把x1^2和x2^2看成一个特征，他们前面的系数都为1，并且-r^2前面的系数是theta0

![image-20210430133700339](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430133700339.png)

****

![image-20210430134740368](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430134740368.png)

![image-20210430134746433](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430134746433.png)

## 第10章 评价分类结果

### 10.1 准确度的陷阱和混淆矩阵

![image-20210430135205333](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430135205333.png)

![image-20210430135235550](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430135235550.png)

****

![image-20210430135403648](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430135403648.png)

****

![image-20210430135439663](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430135439663.png)

### 10.2 精准率和召回率

![image-20210430135730174](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430135730174.png)

****

![image-20210430135734606](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430135734606.png)

* 精准率：预测癌症患者中有多少真正患癌
* 召回率：真实癌症患者有多少被预测为患癌

![image-20210430140355648](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430140355648.png)

### 10.3 实现混淆矩阵，精准率和召回率

![image-20210430141616739](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430141616739.png)

![image-20210430141632747](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430141632747.png)

![image-20210430141638443](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430141638443.png)

### 10.4 F1 Score

![image-20210430141836012](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430141836012.png)

![image-20210430141921500](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430141921500.png)

![image-20210430141944336](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430141944336.png)

****

![image-20210430142004248](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430142004248.png)

****

![image-20210430142729971](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430142729971.png)

### 10.5 精准率和召回率的平衡

在有些场景我们在使用分类算法的时候可能更加重视精准率，而对于另外一些场景可能更加重视召回率，有些情况我们也希望两者都是越大越好，比如使用F1 Score来综合精准率和召回率。但是对于"两者都是越大越好"这样的愿景可能是无法实现的，因为精准率和召回率是互相矛盾的两个指标，我们要找的是两者之间的一个平衡

![image-20210430202149219](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430202149219.png)

逻辑回归的原理是通过训练的过程找到一组参数theta，用theta和样本特征x点乘之后得到的结果去和0作比较，如果≥0的话通过sigmoid函数去判断该样本其类别为1的概率是≥50%的；同理如果≤0的话分类为1的概率≤50%，所以我们就把它分类为0。基于这样的算法我们就引申出决策边界的概念，换句话说theta点乘样本特征x=0在解析几何中用来表示一条线，这条直线就是分类的决策边界

![image-20210430202720627](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430202720627.png)

此时如果theta和样本特征x≥阈值的话就分类为1，反之分类为0，这样其实也形成了一个决策边界。这样就为回归算法引入了一个超参数，就是threshold，我们通过指定threshold，相当于平移决策边界对应的直线从而影响分类结果

![image-20210430203205493](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430203205493.png)

五角星代表分类为1的样本，圆则代表分类为0的样本，这张图就说明了，如果将0作为分类的阈值的话，那么就将样本分数值大于0的五个样本分类成y=1；小于0的7个样本分类为y=0。此时算法的精准率和召回率分别为0.8和0.67，精准率是指在**我们全部判断分类为1的样本中实际上有多少个分类为1的样本**：判断5个样本分类为1，但其实只有4个为样本类别为1；同理召回率代表**本身有多少个分类为1的样本，通过算法预测了多少个分类为1的样本**：判断5个样本分类为1，但本身有6个分类为1的样本

此时我们通过改变阈值就会得到不同的精准率和召回率，可以发现精准率和召回率是相互矛盾的。我们可以直观的想象一下，如果我们想让精准率提高，那么相应的就是只能对于那些特别有把握的数据才将他们分类为1，比如说只有在样本被判断在概率为95%以上的才被分类为某一类别，在这种情况下就会把**本身为该类别的样本**被排除在外，那么召回率就会变低；同理反过来如果想让召回率升高的话，那么就应该降低判断的概率，比如说在癌症预测系统中可能就希望把一个只有10%患癌可能的患者也视作他为癌症病人，也就是拉地阈值，此时召回率提高，但导致精准率下降 

![image-20210430205755161](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430205755161.png)

![image-20210430205805676](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430205805676.png)

![image-20210430205812277](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430205812277.png)

### 10.6 精准率-召回率曲线 

对于分类算法，我们可以调用decision_function来获得分类算法对于每一个样本来说相应的决策的分数值，默认的在逻辑回归算法中，决策的分数值是以0为判断标准的，≥0就判断分类为一个类别，≤0就判断分类为另一个类别。我们可以基于decision_scores来对阈值进行一个调整，通过对阈值的改变，相应的精准率和召回率也会发生相应的变化，并且两者相互牵制互相平衡

我们也可以通过图表来展示两者的动态变化关系

![image-20210430213402593](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213402593.png)

![image-20210430213410920](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213410920.png)

![image-20210430213416465](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213416465.png)

****

![image-20210430213430886](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213430886.png)

****

![image-20210430213436672](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213436672.png)

****

两者和坐标轴围成的面积越大，则算法模型更好

![image-20210430213457783](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213457783.png)

### 10.7 ROC曲线

![image-20210430213606948](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213606948.png)

****

![image-20210430213627700](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213627700.png)

****

![image-20210430213649717](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213649717.png)

****

![image-20210430213747758](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430213747758.png)

****

![image-20210430215409640](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430215409640.png)

![image-20210430215418490](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430215418490.png)

****

![image-20210430215431544](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430215431544.png)

### 10.8 多分类问题中的混淆矩阵

![image-20210430221431747](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430221431747.png)

![image-20210430221446936](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430221446936.png)

![image-20210430221452016](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210430221452016.png)

## 第11章 支撑向量机 SVM

### 11.1 什么是SVM

![image-20210501093358874](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501093358874.png)

SVM既可以解决分类问题也可以解决回归问题

![image-20210501093827292](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501093827292.png)

在二维特征平面中所有样本分成两类，逻辑回归就在这个特征平面中找到一个决策边界，分类算法就告诉我们如果样本在这个决策边界的某一侧，则这些样本就属于某一类，如果在另一侧就是属于另外的一类

不过对于一些数据存在这样的问题：决策边界并不唯一，对于这样决策边界不唯一的问题通常有一个术语叫做：不适定问题。逻辑回归解决这种不适定问题的方法主要是定义了一个概率函数（sigmoid函数），根据这个概率函数进行建模，形成了一个损失函数，我们最小化一个损失函数从而求出一条决策边界，这里的损失函数是完全由训练数据集所决定的

支撑向量机解决的方式稍微有点不同，假设得出的决策边界是下图所示直线，那么在训练数据集上这个决策平面非常好的将数据分成了两部分，但是现在对于机器学习算法来说有个非常重要的问题：算法的泛化能力，换句话说当我们求除了这条决策边界的时候，这条决策边界对于没有看到的样本点是不是一条好的决策边界呢？它能否特别好的得到那些未知的数据相应的分类结果呢？毕竟对于那些未知的数据进行分类才是机器学习算法真正的目的

![image-20210501094354624](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501094354624.png)

假设有一个未知的样本点如上图黑框所示，很显然对于这个位置的数据样本点来说，根据现在所给的决策边界它应该是分成蓝色，但是直观地看一下就会得到，很有可能对于黑框所圈数据点来说，将它分类成红色的样本更为妥当，换句话说求出的这条决策边界它的泛化效果不够好。只是因为得到的决策边界l离红色的点离的太近了，这就导致很多其他离红色也很近的点被分类为蓝色

![image-20210501094744666](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501094744666.png)

这条新的决策边界的特点是：**离直线最近的样本点距离直线尽可能的远**，既离红色样本点远也离蓝色样本点远。我们直观看的话这条决策边界的泛化能力相对较好

![image-20210501095150090](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501095150090.png)

离决策边界最近的点又构造出两条与决策边界平行的线，这两条直线相当于定义出了一片区域，这两根直线之间不再有任何数据点，SVM得出的决策边界就是这片区域**中间的这条线**

![image-20210501095415990](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501095415990.png)

****

![image-20210501095919805](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501095919805.png)

到现在为止举的例子都是对线性可分问题来说的，就是对于这些样本点来说它奥存在一根直线h或者在高维空间中存在一个超平面k可以讲这些点划分，在这种情况下我们才定义出了这个margin。这样的算法通常被称之为Hard Margin SVM（严格的，切切实实找到了一个决策边界）；但是在真实情况下很多数据都是线性不可分的，那么在这种情况下，SVM算法可以进行改进得到Soft Margin SVM

### 11.2 SVM背后的最优化问题

![image-20210501100405267](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501100405267.png)

****

![image-20210501100420037](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501100420037.png)

样本特征本身是x，写成x_b是因为$\theta$里有一个$\theta_0$，x_b就是在x样本前面加上一个1

而在这里写成$w^Tx+b$的形式，相当于把$\theta_0 \cdot x_0$这一项单独拿出来当成截距b，而将所有样本真实的特征前面的系数用向量$w$来表示，w代表权重(weight)，w相当于给x的每一个特征赋上了一个权值，**$\theta$有n+1个元素，$w$有n个元素**

我们使用这种表现方式是因为：点到直线距离公式分母部分并没有截距的部分，只跟样本特征前面的系数相关

![image-20210501104527937](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501104527937.png)

****

![image-20210501101920686](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501101920686.png)

所有样本点到决策边界的距离都应该是≥d的

****

![image-20210501104604372](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501104604372.png)

****

![image-20210501104618867](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501104618867.png)

因为所有的$w$都有脚标d，所有的$b$都有脚标d，所以把$w_d$统一看成$w$，把$b_d$统一看成$b$

![image-20210501104628170](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501104628170.png)

把分类讨论的式子用一个式子替代

![image-20210501104653443](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501104653443.png)

****

![image-20210501104702733](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501104702733.png)

### 11.3 Soft Margin SVM

![image-20210501113227228](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501113227228.png)

![image-20210501113257898](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501113257898.png)

下面的这条决策边界虽然错误地将上面这个蓝色样本错误的分类了，但是很有可能将这个训练模型放到真实环境中进行实际预测的时候，算法的预测能力会比上面这条决策边界更好的区分不同类别，也就是泛化能力更好

我们必须思考一个机制，对于这个机制来说SVM得到的决策边界能够容忍一定程度的错误，也即拥有一定程度的容错能力

![image-20210501113430305](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501113430305.png)

更一般的情况：样本数据根本是线性不可分的

![image-20210501113326808](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501113326808.png)

对于找到的margin数据区域里必须是一点样本数据都没有的，也就是所有的数据点都应该在wx+b=1和wx+b=-1这两条支撑向量之外。现在我们对这个条件加以宽松，给一个宽松量$\xi$

![image-20210501113830505](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501113830505.png)

****

![image-20210501114146474](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501114146474.png)

$\xi$不是一个固定的值，而是对于每一个$y^(i)$都有一个相应的$\xi_i$，换句话说如果有m个数据点的话那么$\xi$就相应的有m个，对于每一个样本点都求出对应的容错空间

但是仅仅有这个$\xi$条件是不够的，因为很容易让$\xi$取正无穷，让虚线处于直线下面无限远的地方，那么很显然对于所有数据线而言都将满足条件，那么此时容错范围就太大了。我们希望$\xi$有但是不能太大，解决办法就是在最小化方程的地方加上$\xi$求和，这样子做式子就同时顾及了SVM算法最小化目标以及有一定程度的容错空间；并且使用C来平衡前后两者的权重关系，如果C=1，则前后两者的重要程度是一样的；如果0<C<1，则这个最优化式子将以前者为主，反之以后半部分为主，那么C就是一个超参数，C越大容错空间越小，比如如果C是无穷大，就逼迫$\xi$等于0，此时soft就变成了hard

![image-20210501114946814](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501114946814.png)

****

![image-20210501115153031](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501115153031.png)

### 11.4 scikit-learn中的SVM

![image-20210501115707898](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501115707898.png)

****

![image-20210501115726956](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501115726956.png)

![image-20210501115735782](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501115735782.png)

****

![image-20210501130031414](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501130031414.png)

![image-20210501130050318](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501130050318.png)

![image-20210501130114652](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501130114652.png)

![image-20210501130129383](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501130129383.png)

![image-20210501130134800](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501130134800.png)

### 11.5 SVM中使用多项式特征和核函数

![image-20210501134159300](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501134159300.png)

![image-20210501134207826](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501134207826.png)

![image-20210501134212427](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501134212427.png)

对于SVM这个算法而言，在sklearn的封装中其实可以不使用PolynomialFeatures的方式先对数据转化成高维有多项式项特征的数据，再扔进LinearSVM。SVM算法有个特殊的方式可以直接使用多项式的特征，这个特殊的方式被称为多项式核函数

![image-20210501134702811](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501134702811.png)

### 11.6 到底什么是核函数

![image-20210501134851487](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501134851487.png)

****

![image-20210501135627306](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501135627306.png)

 

使用多项式特征的话，之前的方式是对于本来的样本数据$x^(i)$首先添加上多项式特征让它成为$x^‘(i) $ ，对于另外一个样本$x^(j)$添加上多项式特征$x^‘(j) $。这样子做完之后在最大化式子中使用了新的特征，也就是不再使用$x^(i)$和$x^(j)$了，红色方框里变成要求$x^‘(i) $和$x^‘(j) $

![image-20210501135719395](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501135719395.png)

核函数的思想是：先不将两个样本点先分别转换成$x^‘(i) $和$x^‘(j)$，先设置一个函数K()，这个函数先传入两个参数$x^(i)$和$x^(j)$，直接对原来的两个样本进行数学运算，直接计算出$x^‘(i) $和$x^‘(j)$。如果可行的话，那么原先最大化式子中就可以K（$x^(i)$和$x^(j)$）所替换

K函数作用其实是想省略掉$x^(i)$和$x^(j)$转变成$x^‘(i)$和$x^‘(j)$这一步，不要再进行这一步变形了，直接拿原来的样本代入一个函数中，用这个函数直接算出$x^‘(i)$点乘$x^‘(j)$的结果，那么这个K函数就叫做核函数

![image-20210501140000696](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501140000696.png)

很多资料里会把核函数叫做kernel trick，意思就是使用核函数的技巧，这个叫法其实挺准确的。因为即使不使用核函数，也能达到同样的效果，但是在这里更像是一个数学的技巧，我们把和函数应用在这里就免去了原先树数学变形，然后再对变形后的结果进行点乘的运算步骤了。尤其是对一些复杂的变形，通常使用核函数的话一方面计算量会有所减少，一方面也节省了存储的空间

核函数并不是SVM特有的技巧，事实上只要算法转换成了一个最优化的问题，再秋姐这个最优化的问题中存在$x^(i)点乘x^(j)$的式子，我们都可以使用核函数的技巧

#### 11.6.1 多项式核函数

![image-20210501141015868](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501141015868.png)

****

![image-20210501141024434](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501141024434.png)

****

![image-20210501141704261](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501141704261.png)

### 11.7 RBF核函数

![image-20210501141822632](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501141822632.png)

****

![image-20210501142057673](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501142057673.png)

****

![image-20210501142224919](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501142224919.png)

****

![image-20210501142234360](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501142234360.png)

****

![image-20210501142819750](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501142819750.png)

****

![image-20210501143620519](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501143620519.png)

![image-20210501143628087](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501143628087.png)

****

![image-20210501143604443](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501143604443.png)

****

![image-20210501143748870](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501143748870.png)

### 11.8 RBF核函数中的gamma

![image-20210501150037327](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501150037327.png)

#### 11.8.1 sklearn中的高斯核函数

![image-20210501151046752](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501151046752.png)

![image-20210501151056981](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501151056981.png)

![image-20210501151112799](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501151112799.png)

![image-20210501151120869](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501151120869.png)

![image-20210501151125622](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210501151125622.png)

## 第12章 决策树

### 12.1 什么是决策树

![image-20210526124005965](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526124005965.png)

****

![image-20210526124743597](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526124743597.png)

![image-20210526124751110](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526124751110.png)

****

![image-20210526124801923](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526124801923.png)

****

![image-20210526124935789](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526124935789.png)

****

![image-20210526124957948](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526124957948.png)

### 12.2 信息熵

![image-20210526125347454](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526125347454.png)

****

左边的数据每一个都各占三分之一，代表着数据整体不确定性大；右边的第三个样本数据占了绝大多数，所以信息熵较左边的样本分布而言要少

![image-20210526125503317](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526125503317.png)

****

![image-20210526125641776](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526125641776.png)

****

![image-20210526125713074](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526125713074.png)

****

![image-20210526130108981](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526130108981.png)

****

![image-20210526130153890](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526130153890.png)

### 12.3 使用信息熵寻找最优划分

![image-20210526142731497](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526142731497.png)

![image-20210526142738198](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526142738198.png)

![image-20210526142749026](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526142749026.png)

![image-20210526142754019](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526142754019.png)

### 12.4 基尼系数

![image-20210526142907658](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526142907658.png)

****

![image-20210526142937905](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526142937905.png)

****

![image-20210526144405114](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526144405114.png)

![image-20210526144417476](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526144417476.png)

![image-20210526144423113](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526144423113.png)

### 12.5 CART与决策树中的超参数

![image-20210526144713601](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526144713601.png)

样本数量为m，每个样本有n个特征维度

因为在训练模型算法是需要遍历所有特征维度(n)以及每个维度上的所有值(m)，从而挑选出一个最佳的维度以及阈值进行分类划分

![image-20210526144931648](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526144931648.png)

****

![image-20210526154145179](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154145179.png)

![image-20210526154159259](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154159259.png)

![image-20210526154210423](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154210423.png)

![image-20210526154219375](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154219375.png)

![image-20210526154227263](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154227263.png)

****

![image-20210526154240630](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154240630.png)

### 12.6 决策树解决回归问题

分类问题每个叶子节点代表着一个类别，而回归问题中每个叶子节点的值代表着该叶子节点中所有样本点的平均值，把它作为回归问题的预测值

![image-20210526154334093](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154334093.png)

****

![image-20210526154902782](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526154902782.png)

### 12.7 决策树的局限性

![image-20210526155138591](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526155138591.png)

****

![image-20210526155152677](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526155152677.png)

决策树是永远不会出现斜着的分割线的

![image-20210526155212933](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526155212933.png)

****

![image-20210526155248005](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526155248005.png)

把数据分布倾斜之后的分割

![image-20210526155300797](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526155300797.png)

## 第13章 集成学习和随机森林

### 13.1 什么是集成学习

![image-20210526162330863](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526162330863.png)

****

![image-20210526162356690](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526162356690.png)

****

![image-20210526164457594](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526164457594.png)

**![image-20210526164506473](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526164506473.png)**

![image-20210526164514496](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526164514496.png)

### 13.2 Soft Voting Classifier

少数服从多数的算法叫做Hard Voting，但是在很多情况下少数服从多数并不是最合理的。有一种说法叫做"民主暴政"，如果采用一人一票的话反而会得到一个不好的结果

更合理的投票应该是有权值的

![image-20210526171312836](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526171312836.png)

****

![image-20210526171517541](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526171517541.png)

Soft Voting不仅要考虑有多少票分给A，有多少票分给B，还要考虑投给A的票到底有多大的概率确认样本应该分成A类；投给B的票到底有多大的概率确认样本应该分成B类

![image-20210526171541227](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526171541227.png)

****

![image-20210526171741267](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526171741267.png)

****

![image-20210526171824251](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526171824251.png)

待预测样本点分类为红色类别的概率为2/3，分类为蓝色类别的概率为1/3

![image-20210526171856340](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526171856340.png)

 对于决策树算法而言，样本是不断地从根节点走到一个叶子节点。通常一个叶子节点是包含多个样本点的，但是该叶子节点的基尼系数或者信息熵的值可能还不为0，即叶子节点里是包含不同类别的样本点的。这种情况下，哪个类数量多，相应的就把该叶子节点里的验样本分类为该类别。

概率算法就是占比例最大的数据点的数量除以叶子节点中所有数据的数量

![image-20210526172026566](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526172026566.png)

****

![image-20210526172451390](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526172451390.png)

****

![image-20210526172950878](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526172950878.png)

### 13.3 Bagging 和 Pasting

![image-20210526175934173](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526175934173.png)

****

![image-20210526180016888](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526180016888.png)

****

![image-20210526180311414](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526180311414.png)

****

![image-20210526180327519](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526180327519.png)

****

![image-20210526180446374](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526180446374.png)

****

![image-20210526180605383](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526180605383.png)

****

![image-20210526181121376](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181121376.png)

### 13.4 oob (Out-of-Bag) 和关于Bagging的更多讨论

![image-20210526181149669](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181149669.png)

****

![image-20210526181516728](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181516728.png)

****

![image-20210526181537528](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181537528.png)

****

![image-20210526181700303](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181700303.png)

****

![image-20210526181717702](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181717702.png)

****

![image-20210526181856278](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526181856278.png)

### 13.5 随机森林和 Extra-Trees

### 13. 6 Ada Boosting 和 Gradient Boosting

![image-20210526190012673](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526190012673.png)

每一次形成的子模型都是在弥补上一次生成模型没有被成功预测的样本点

![image-20210526190233177](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526190233177.png)

****

![image-20210526190703730](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526190703730.png)

****

![image-20210526190720792](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526190720792.png)

****

![image-20210526190804778](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526190804778.png)

****

![image-20210526190918711](Python3%E5%85%A5%E9%97%A8%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0%20%E7%BB%8F%E5%85%B8%E7%AE%97%E6%B3%95%E4%B8%8E%E5%BA%94%E7%94%A8.assets/image-20210526190918711.png)



