# Factory Method Pattern - Code Files | 工厂方法模式 - 代码文件

## File Descriptions | 文件说明

### 1. **Tile.java** - Tile Interface | 地形块接口

**Role**: Product Interface  
**角色**：产品接口

Defines the common interface for all terrain tiles.  
定义所有地形块的通用接口。

**Methods | 方法**:
- `char getCharacter()` - Returns the character representation of the tile | 返回地形块的字符表示
- `String getType()` - Returns the type name of the tile | 返回地形块的类型名称

---

### 2. **Map.java** - Abstract Map Class | 抽象地图类

**Role**: Abstract Creator  
**角色**：抽象创建者

The core abstract class implementing the Factory Method pattern.  
实现工厂方法模式的核心抽象类。

It defines the abstract factory method `createTile()` that subclasses must implement.  
定义了抽象工厂方法 `createTile()`，子类必须实现该方法。

**Fields | 字段**:
- `int width` - Map width | 地图宽度
- `int height` - Map height | 地图高度
- `Tile[][] tiles` - 2D array storing all terrain tiles | 存储所有地形块的二维数组
- `Random random` - Random number generator for terrain generation | 用于地形生成的随机数生成器

**Methods | 方法**:
- `abstract Tile createTile()` - Factory method (implemented by subclasses) | 工厂方法（由子类实现）
- `void display()` - Displays the map as a character matrix | 以字符矩阵形式显示地图

---

### 3. **CityMap.java** - City Map | 城市地图

**Role**: Concrete Creator  
**角色**：具体创建者

Implements the factory method to create city-specific terrain tiles.  
实现工厂方法以创建城市特有的地形块。

**Terrain Types | 地形类型**:
- Building ('B') | 建筑 ('B')
- Road ('R') | 道路 ('R')
- Forest ('F') | 森林 ('F')

**Factory Method | 工厂方法**:  
Randomly selects one of the three city terrain types.  
从三种城市地形类型中随机选择一种。

---

### 4. **WildernessMap.java** - Wilderness Map | 荒野地图

**Role**: Concrete Creator  
**角色**：具体创建者

Implements the factory method to create wilderness-specific terrain tiles.  
实现工厂方法以创建荒野特有的地形块。

**Terrain Types | 地形类型**:
- Forest ('F') | 森林 ('F')
- Swamp ('S') | 沼泽 ('S')
- Water ('W') | 水域 ('W')

**Factory Method | 工厂方法**:  
Randomly selects one of the three wilderness terrain types.  
从三种荒野地形类型中随机选择一种。

---

### 5. **SwampTile.java** - Swamp Terrain | 沼泽地形

**Role**: Concrete Product  
**角色**：具体产品

Represents swamp areas on the map.  
表示地图上的沼泽区域。

- Character | 字符: 'S'
- Type | 类型: "Swamp"

---

### 6. **WaterTile.java** - Water Terrain | 水域地形

**Role**: Concrete Product  
**角色**：具体产品

Represents water bodies (lakes, rivers) on the map.  
表示地图上的水体（湖泊、河流）。

- Character | 字符: 'W'
- Type | 类型: "Water"

---

### 7. **RoadTile.java** - Road Terrain | 道路地形

**Role**: Concrete Product  
**角色**：具体产品

Represents roads on the map.  
表示地图上的道路。

- Character | 字符: 'R'
- Type | 类型: "Road"

---

### 8. **ForestTile.java** - Forest Terrain | 森林地形

**Role**: Concrete Product  
**角色**：具体产品

Represents forest areas on the map.  
表示地图上的森林区域。

- Character | 字符: 'F'
- Type | 类型: "Forest"

---

### 9. **BuildingTile.java** - Building Terrain | 建筑地形

**Role**: Concrete Product  
**角色**：具体产品

Represents buildings on the map.  
表示地图上的建筑物。

- Character | 字符: 'B'
- Type | 类型: "Building"

---

### 10. **Game.java** - Main Game Class | 游戏主类

**Role**: Client  
**角色**：客户端

The entry point of the application.  
应用程序的入口点。

Contains the `main()` method and a factory method for creating different map types.  
包含 `main()` 方法和创建不同地图类型的工厂方法。

**Methods | 方法**:
- `void main(String[] args)` - Program entry point, creates and displays maps | 程序入口点，创建并显示地图
- `Map createMap(String type, int width, int height)` - Factory method for creating maps | 创建地图的工厂方法

---

## How to Run | 运行方法

### Compile | 编译
```bash
mvn compile
```

### Run | 运行
```bash
java -cp target/classes FactoryMethod.Game
```

### Expected Output | 预期输出
```
Creating a 5x5 City map...
B R F B R 
F B R R F 
R F B F B 
B R F R F 
F B B R R 

Creating a 10x10 Wilderness map...
S W F S S W W S S W 
S S F S W F F W S W 
F S W S S F S F W F 
S F F F W W S F S F 
F F F W S W S W W F 
W S S F W W W W W S 
W F W W W W F W S F 
S S F F W W W F F S 
S W W S W W F W W F 
F W S S W W W F F F 
```

